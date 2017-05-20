package mum.cs472.magd.service;

import java.util.List;

import mum.cs472.magd.entity.Post;

import org.springframework.stereotype.Service;

@Service
public interface PostService {

	List<Post> getPosts();
	
}
