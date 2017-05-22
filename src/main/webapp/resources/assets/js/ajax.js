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
		var dataDisplay = "";
		let postArr = JSON.parse(data).data;
		console.log(postArr);
		for (let x in postArr){
			var aJob = $("<a/>",{
				class: "bold",
				text: postArr[x].POSTTITLE
			});
			
			var s = $("<span>",{
				text: " has suggested this job: "
			});
			var p = $("<a/>",{
				class: "bold",
				text: postArr[x].FULLNAME
			}); 
		
			var d = $("<div>", {
				class: "sugjobs"
			});
			$(d).append(p);
			$(d).append(s);
			$(d).append(aJob);
			$('#mySugPosts').append(d);
		}

		console.log(dataDisplay);
                                                                                                                                                                                                                                                                  
	}
	
	function showError(){
		//Add message Todo
		alert("Error");
	}
	

	
	
	
});