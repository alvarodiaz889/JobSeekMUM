package mum.cs472.magd.service;

import java.util.List;

import mum.cs472.magd.entity.Post;

import org.springframework.stereotype.Service;

@Service
public interface PostService {

	List<Post> getPosts();
	boolean insertPost(Post post,String userId);
	boolean deletePost(Post post);
	boolean suggestPost(String userId, String postId, String toUserId);
	@SuppressWarnings("rawtypes")
	List listSuggestPost(String userId);
	@SuppressWarnings("rawtypes")
	List listUserPosts();
	
}
