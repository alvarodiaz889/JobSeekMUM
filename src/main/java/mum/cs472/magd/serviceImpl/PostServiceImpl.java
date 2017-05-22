package mum.cs472.magd.serviceImpl;

import java.util.ArrayList;

import java.util.List;


import mum.cs472.magd.dao.GenericDao;
import mum.cs472.magd.entity.Post;

import mum.cs472.magd.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostServiceImpl implements PostService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private GenericDao dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPosts() {
		List<Post> posts = new  ArrayList<>();
		String query = "SELECT * FROM POSTS ";
		posts = dao.getData(query);
		return posts;
	}
	@Override
	public boolean insertPost(Post post,String userId) {
		String query = "INSERT INTO POSTS(USERID,POST,POSTTYPE,POSTTITLE,DATECREATED,DATEUPDATED) "+
						"VALUES(?,?,?,?,SYSDATE(),SYSDATE() ) ";
		Object[] params = new Object[]{userId,post.getPostText(),post.getPostType(), post.getPostTitle()};

		boolean flag = dao.update(query, params);
		return flag;
	}
	@Override
	public boolean deletePost(Post post) {
		String query ="DELETE FROM POSTS WHERE POSTID = ? ";
		boolean flag = dao.update(query, new Object[]{post.getPostId()} );
		return flag;
	}
	@Override
	public boolean suggestPost(String userId, String postId, String toUserId) {
		String query = "INSERT INTO SUGGESTPOST(POSTID,USERID,TOUSERID,DATECREATED) "+
				"VALUES(?,?,?,SYSDATE()) ";
		Object[] params = new Object[]{postId, userId,toUserId};
		
		boolean flag = dao.update(query, params);
		return flag;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List listSuggestPost(String userId) {
		List listSugPosts = new ArrayList();
		String query = "SELECT P.POSTID,P.POSTTITLE,U.FULLNAME FROM POSTS P, USERS U, SUGGESTPOST SP " +
						"WHERE P.POSTID = SP.POSTID " +
						"AND P.USERID = U.USERID " +
						" AND SP.TOUSERID = ?";
		listSugPosts = dao.getData(query, new Object[]{userId});
		return listSugPosts;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List listUserPosts() {
		List posts = new ArrayList();
		String query = "SELECT * FROM POSTS P, USERS U " +
						"WHERE P.USERID = U.USERID ";
		posts = dao.getData(query);
		return posts;
	}
	@Override
	public List getMyPosts(String userId) {
		List posts = new ArrayList();
		String query = "SELECT * FROM POSTS P, USERS U " +
						"WHERE P.USERID = U.USERID AND P.USERID = ? ";
		posts = dao.getData(query, new Object[]{userId});
		return posts;
	}
	@Override
	public List getPostById(String postId) {
		String query = "SELECT * FROM POSTS WHERE POSTID = ? ";
		List postList = new ArrayList();
		postList = dao.getData(query, new Object[]{postId});
		return postList;
	}

}
