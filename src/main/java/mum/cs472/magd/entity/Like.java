package mum.cs472.magd.entity;

import java.io.Serializable;
import java.util.Date;

public final class Like implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer likeId;
	private Post postId;
	private Date dateCreated;
	private Date dateUpdate;
	
	public Like(){}

	public Like(Integer likeId, Post postId, Date dateCreated, Date dateUpdate) {
		super();
		this.likeId = likeId;
		this.postId = postId;
		this.dateCreated = dateCreated;
		this.dateUpdate = dateUpdate;
	}

	public Integer getLikeId() {
		return likeId;
	}

	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdate == null) ? 0 : dateUpdate.hashCode());
		result = prime * result + ((likeId == null) ? 0 : likeId.hashCode());
		result = prime * result + ((postId == null) ? 0 : postId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Like other = (Like) obj;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdate == null) {
			if (other.dateUpdate != null)
				return false;
		} else if (!dateUpdate.equals(other.dateUpdate))
			return false;
		if (likeId == null) {
			if (other.likeId != null)
				return false;
		} else if (!likeId.equals(other.likeId))
			return false;
		if (postId == null) {
			if (other.postId != null)
				return false;
		} else if (!postId.equals(other.postId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", postId=" + postId + ", dateCreated=" + dateCreated + ", dateUpdate="
				+ dateUpdate + "]";
	}
	
	

}
