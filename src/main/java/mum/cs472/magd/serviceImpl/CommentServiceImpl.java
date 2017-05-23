package mum.cs472.magd.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import mum.cs472.magd.dao.GenericDao;
import mum.cs472.magd.entity.Comment;
import mum.cs472.magd.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommentServiceImpl implements CommentService {

	@SuppressWarnings("rawtypes")
	@Autowired
	GenericDao dao;
	@Override
	public boolean addComment(Comment comment, String postId, String userId) {
		boolean flag = false;
		String query ="INSERT INTO COMMENTS(USERID,POSTID,COMMENT,DATECREATE,DATEUPDATED) "+
		              "VALUES (?,?,?,SYSDATE(),SYSDATE() )";
		flag = dao.update(query, new Object[]{userId,postId,comment.getCommentText()});
		return flag;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> viewComments(String postId) {
		List<Comment> comments  = new ArrayList<>();
		Object[] params = new Object[]{postId};
		//String query = "SELECT * FROM COMMENTS WHERE POSTID = ?";
		String query = "SELECT * FROM COMMENTS c , USERS u WHERE c.userid = u.userid AND postid = ?";
		comments = dao.getData(query,params);
		return comments;
	}
	@Override
	public boolean deleteComment(String comment) {
		String query = "DELETE FROM COMMENTS WHERE COMMENTID  = ?";
		boolean flag  = dao.update(query, new Object[]{comment});
		return flag;
	}

}
