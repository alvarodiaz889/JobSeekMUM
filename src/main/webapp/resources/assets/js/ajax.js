/**
 * 
 */

$(function(){
	
	var successMsg = "<div class='alert alert-success'><strong>Success!</strong> Indicates a successful or positive action.</div>";
	var errorMsg = "<div class='alert alert-warning'> <strong>Warning!</strong> Indicates a warning that might need attention.</div>";
	
	listSuggestedPosts();
	
	/*
	 * MyPost
	 */
	$("#myPostSubmit").click(function(){
		createMyPost();
	});
	
	$(".MyPostForm").keydown(function(){
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
	
	/*
	 * SuggestedPosts
	 */
	function listSuggestedPosts(){
	
		$.ajax("/JobSeekMum/listSuggestPost",{
			"type":"POST"
		}).done(showSuggestedPosts)
		  .fail(showError);
	}
	
	function showSuggestedPosts(data){
		console.log(data);
	}
	
	function showError(){
		//Add message Todo
		alert("Error");
	}
	
	/******** LIKES *********/
	$("#likeImg").click(function(){
		
		var action = $("#likeImg").attr("alt");
		var userId = 4;
		var postId = 1;
		var likeId = $("#likeId").val();
		//alert(action);	
		if(action === "like")
		{
			saveLike(postId);
		}
		else
		{
			removeLike(likeId);				
		}	
		setTimeout(function(){ updateLikes(postId); }, 1000);	
		
	});
	
	function saveLike(postId)
	{
		$.ajax("/JobSeekMum/setLike",{
			"type":"POST",
			"async": "false",
			"data": { 
				"postId": postId
				
			}
		})
		.done(saveLikeSuccess)
		  .fail(showError);			
	}
	
		
	function removeLike(likeId)
	{
		$.ajax("/JobSeekMum/unLike",{
			"type":"POST",
			"async": "false",
			"data": { 
				"likeId": likeId
			}
		}).done(removeLikeSuccess)
		  .fail(showError);
	}
	
	function updateLikes(postId)
	{
		$.ajax("/JobSeekMum/getLikes",{
			"type":"POST",
			"async": "false",
			"data": { 
				"postId": postId
			}
		})
		.done(updateLikesSuccess)
		  .fail(showError);			
	}
	
	//--callbacks--
	function saveLikeSuccess(data)
	{
		console.log(data);
		let id = JSON.parse(data).data[0].likeid;
		$("#likeId").val(id);
		$("#likeImg").attr("alt","unlike");
		let src = $("#likeImg").attr("src").toString();
		src = src.replace("like.png","like2.png");
		$("#likeImg").attr("src",src);
	}
	
	function removeLikeSuccess()
	{
		$.ajaxSetup({ cache: false });
		$("#likeId").val("");
		$("#likeImg").attr("alt","like");
		let src = $("#likeImg").attr("src").toString();
		src = src.replace("like2.png","like.png");
		$("#likeImg").attr("src",src);
	}
	
	function updateLikesSuccess(data)
	{
		var users = JSON.parse(data).data;
		var usersNames="";
		for(var obj in users)
		{
			usersNames += users[obj].fullname + '\n';
		}
		$("#likeTxt").text(users.length);
		$("#likeLink").attr("title",usersNames);
	}
		
});