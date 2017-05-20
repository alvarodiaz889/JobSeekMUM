package mum.cs472.magd.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class GenericDao<T> {
	@Autowired
	private DataSource basicDataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	private BasicDataSource source = null;

	@Autowired
	public void setDataSource(DataSource basicDataSource) {
		this.basicDataSource = basicDataSource;
		this.jdbcTemplate = new JdbcTemplate(basicDataSource);
	}

	// function with no parameter query and return list
	@SuppressWarnings("finally")
	public List getData(String query) {
		List list = null;
		try {
			list = this.jdbcTemplate.queryForList(query);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return list;
		}

	}

	// function with parameterized query and return list
	@SuppressWarnings("finally")
	public List getData(String query, Object[] params) {
		List list = null;
		try {
			list = this.jdbcTemplate.queryForList(query, params);
		} catch (Exception ex) {
			list = null;
			ex.printStackTrace();
		} finally {
			return list;
		}
	}

	@SuppressWarnings("finally")
	public int getIntData(String query) {
		int val = 0;
		try {
			val = this.jdbcTemplate.queryForInt(query);
		} catch (Exception ex) {
			val = 0;
			ex.printStackTrace();
		} finally {
			return val;
		}
	}
	
	// function with no parameterized query and return object
	@SuppressWarnings("finally")
	public boolean update(String query, Object[] params) {
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			this.jdbcTemplate.update(query, params);
			transactionManager.commit(status);
			flag = true;
		} catch (Exception ex) {
			flag = false;
			transactionManager.rollback(status);
			ex.printStackTrace();
		} finally {
			return flag;
		}
	}

	@SuppressWarnings("finally")
	public boolean updateAll(List<String> qryList, List<Object[]> params) {
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			for (int i = 0; i < qryList.size(); i++) {
				Object[] par = params.get(i);
				if (par != null && par.length > 0) {
					this.jdbcTemplate.update(qryList.get(i), par);
				}
			}
			transactionManager.commit(status);
			flag = true;
		} catch (Exception ex) {
			flag = false;
			transactionManager.rollback(status);
			ex.printStackTrace();
		} finally {
			return flag;
		}
	}

	/**
	 * @return the transactionManager
	 */
	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * @param transactionManager
	 *            the transactionManager to set
	 */
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			this.transactionManager = transactionManager;
			this.source = (BasicDataSource) transactionManager.getDataSource();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
