package mum.cs472.magd.entity;

import java.io.Serializable;
import java.util.Date;

public final class Comment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private Integer commentId;
	private String commentText;
	private Date dateCreated;
	private Date dateUpdated;
	
	public Comment(){}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	
	
}
