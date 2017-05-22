package mum.cs472.magd.service;

import java.util.List;
import org.springframework.stereotype.Service;
import mum.cs472.magd.entity.*;

@Service
public interface LikeService {
	
	List<Like> viewListPerPost(String postId);
	List<User> viewUsersPerPost(String postId);
	boolean like(String postId,String userId);
	boolean unlike(String likeId);	
	List<Like> getLastLike(String postId,String userId);
	
	

}
