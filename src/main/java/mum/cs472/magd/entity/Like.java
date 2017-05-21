package mum.cs472.magd.entity;

import java.io.Serializable;
import java.util.Date;

public final class Like implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer likeId;
	private Date dateCreated;
	private Date dateUpdate;
	
	public Like(){}

	public Integer getLikeId() {
		return likeId;
	}

	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	
	
	

}
