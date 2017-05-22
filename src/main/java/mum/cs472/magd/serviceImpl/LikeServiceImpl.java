package mum.cs472.magd.serviceImpl;

import mum.cs472.magd.dao.GenericDao;
import mum.cs472.magd.entity.*;
import mum.cs472.magd.service.LikeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LikeServiceImpl implements LikeService {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	GenericDao dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Like> viewListPerPost(String postId) {
		List<Like> likes  = new ArrayList<>();
		Object[] params = new Object[]{postId};
		String query = "SELECT * FROM LIKES WHERE POSTID = ?";
		likes = dao.getData(query,params);
		return likes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> viewUsersPerPost(String postId) {
		List<User> users  = new ArrayList<>();
		Object[] params = new Object[]{postId};
		String query = "SELECT U.* FROM LIKES L,USERS U WHERE U.USERID = L.USERID AND L.POSTID = ?";
		users = dao.getData(query,params);
		return users;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Like> getLastLike(String postId, String userId) {
		List<Like> likes = new ArrayList<>();
		Object[] params = new Object[]{userId,postId};
		String query = "SELECT * FROM LIKES WHERE USERID = ? AND POSTID = ? ORDER BY LIKEID DESC LIMIT 1";
		likes = dao.getData(query,params);
		return likes;
	}
	
	@Override
	public boolean like(String postId, String userId) {
		boolean flag = false;
		String query ="INSERT INTO LIKES(USERID,POSTID,DATECREATED,DATEUPDATED) "+
		              "VALUES (?,?,SYSDATE(),SYSDATE() )";
		flag = dao.update(query, new Object[]{userId,postId});
		return flag;
	}

	@Override
	public boolean unlike(String likeId) {
		String query = "DELETE FROM LIKES WHERE LIKEID  = ?";
		boolean flag  = dao.update(query, new Object[]{likeId});
		return flag;
	}

}
