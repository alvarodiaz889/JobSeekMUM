package mum.cs472.magd.service;

import java.util.List;

import mum.cs472.magd.entity.Comment;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	
    List<Comment> viewComments(String postId);
	boolean addComment(String comment,String postId,String userId);
	boolean deleteComment(String comment);
}
