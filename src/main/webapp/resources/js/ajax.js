/**
 * 
 */

$(function(){
	
	
	$("#myPostSubmit").click(function(){
		createMyPost();
	});
	
	
	
	function createMyPost(){
		let userId = 1;
		let type = $("#myPostType").val();
		let body = $("#myPostBody").val();
		$.ajax("/JobSeekMum/addPost",{
			"type":"POST",
			"data": { 
				"user_id": userId,
				"postType": type,
				"postText": body 
			},
		}).done(myPostCleanMsg)
		  .fail(showError);
	}
	
	function myPostCleanMsg(){
		//Add message Todo
		alert("Insert ok");
	}
	
	function showError(){
		//Add message Todo
		alert("Error");
	}
	
	
	
});