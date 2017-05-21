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
		String query = "INSERT INTO POSTS(POSTID,USERID,POST,DATECREATED,DATEUPDATED) "+
						"VALUES(SEQ_POSTS_POSTID,?,?,CURDATE(),CURDATE() ";
		Object[] params = new Object[]{userId,post.getPostText()};
		boolean flag = dao.update(query, params);
		return flag;
	}

	

}
