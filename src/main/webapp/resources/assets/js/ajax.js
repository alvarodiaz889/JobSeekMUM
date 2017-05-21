/**
 * 
 */

$(function(){
	
	var successMsg = "<div class='alert alert-success'><strong>Success!</strong> Indicates a successful or positive action.</div>";
	var errorMsg = "<div class='alert alert-warning'> <strong>Warning!</strong> Indicates a warning that might need attention.</div>";
	
	$("#myPostSubmit").click(function(){
		createMyPost();
	});
	
	$(".MyPostForm").change(function(){
		let type = $("#myPostType").val();
		let body = $("#myPostBody").val();
		let title = $("#myPostTitle").val();

		if(type != "" && body != "" && title != ""){
			$("#myPostSubmit").removeAttr('disabled');
		}
	});
	
	function createMyPost(){
		let userId = 1;
		let type = $("#myPostType").val();
		let body = $("#myPostBody").val();
		let title = $("#myPostTitle").val();
		
		$.ajax("/JobSeekMum/addPost",{
			"type":"POST",
			"data": { 
				"user_id": userId,
				"postType": type,
				"postText": body,
				"postTitle": title
			},
		}).done(myPostCleanMsg)
		  .fail(showError);
	}
	
	function getPosts() {		
		$.get("/JobSeekMum/getPosts").done(retrievePosts).fail(showError);
	}
	
	function retrievePosts(data) {
		
	}
	
	function myPostCleanMsg(){
		//Add message Todo
		$("#messageSpace").append(successMsg);
		setTimeout($("#messageSpace").append(""), 5000);
		
		 $("#myPostType").val('');
		 $("#myPostBody").val('');
		 $("#myPostTitle").val('');
		 $("#myPostSubmit").attr('disabled','disabled');
		alert("Insert ok");
	}
	
	function showError(){
		//Add message Todo
		alert("Error");
	}
	

	
	
	
});