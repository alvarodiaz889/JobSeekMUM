/**
 * 
 */

var totalPosts = 0;
$(function(){
	
	/*
	 * Reload Post and MyPosts
	 */
	function reloadPosts(){
		//Reload MyPosts
		$('#panel3').empty();
		getMyPosts();
		//Reload Posts
		$('#panel2').empty();
		getPosts();
	}
	
	/*
	 * Count Post and Show Notification
	 */
	function countPost(){
		$.get("/JobSeekMum/countPosts")
			.done(function(data){
				data = JSON.parse(data).data;
				
				if(totalPosts != "0"){
					if(totalPosts < data[0].value){
						console.log("New Post" + data[0].value + " Previous: " + totalPosts);
						//Show notification
						$('#notificationWindow').modal('show');
					}
				}
				totalPosts = data[0].value;
				console.log("Total Post: " + totalPosts);
			});
	}
	//Set Interval to show notification
	setInterval(countPost, 5000);
	
	$("#btnSeeNewPost").click(function(){
		$('#notificationWindow').modal('hide');
		reloadPosts();
	});
	
	/*
	 * Show messages
	 */
	function showMessage(msg, source){
		console.log(source);
		$("#messageSpace").empty();
		$("#messageSpace").fadeIn("slow");
		$("#messageSpace").append(msg);
		setTimeout(	function(){
				$("#messageSpace").fadeOut( "slow" )
			}, 5000);
	}
	
	var successMsg = "<div class='alert alert-success'><strong>Success!</strong> </div>";
	var errorMsg = "<div class='alert alert-warning'> <strong>Warning!</strong> There is an error.</div>";
	
	
	var imagePath = "/JobSeekMum/resources/images/";
	//Retrieve suggested posts
	listSuggestedPosts();
	//Retrieve all posts
	getPosts();
	//Retrieve MyPosts
	getMyPosts();
	//CountPost
	countPost();
	
	/*
	 * MyPost
	 */
	$("#myPostSubmit").click(function(){
		createMyPost();
	});
	
	//Activate Button MyPost
	$(".MyPostForm").keyup(function(){
		let type 	= $("#myPostType").val();
		let body 	= $("#myPostBody").val();
		let title 	= $("#myPostTitle").val();
		//console.log(type+" "+body+" "+title);
		if(type != "" && body != "" && title != ""){
			$("#myPostSubmit").attr('disabled', false);
		}
	});
	
	//Create MyPost
	function createMyPost(){
		let userId = 1;
		let type 	= $("#myPostType").val();
		let body 	= $("#myPostBody").val();
		let title 	= $("#myPostTitle").val();
		
		$.ajax("/JobSeekMum/addPost",{
			"type":"POST",
			"data": { 
				"user_id"	: userId,
				"postType"	: type,
				"postText"	: body,
				"postTitle"	: title
			},
		}).done(function(){
			showMessage(successMsg);
			myPostCleanMsg();
			reloadPosts();
		}).fail(function(){
			showMessage(errorMsg,"Error Create My Post");
		})
	}
	
	//Delete MyPost
	$('#panel3').on('click', '.delete-post-btn', function() {
		var postId = $(this).attr("postid");
		$.ajax("/JobSeekMum/deletePost",{
			"type"	:"POST",
			"data"	: { 
						"postId": postId
					  },
		}).done(function(){
			showMessage(successMsg);
			console.log("Delete post");
			reloadPosts();
		})
		  .fail(function(){
			  showMessage(errorMsg, "Error Delete My Post");
		  })
	});
	
	//Get MyPosts
	function getMyPosts() {		
		$.get("/JobSeekMum/listMyPosts")
		.done(retrieveMyPosts)
		.fail(function(){
			showMessage(errorMsg, "Error get my post");
		})
	}
	
	function retrieveMyPosts(data) {
	let postArr = JSON.parse(data).data; 
	let ids = "";
	
	for (let x in postArr){
		
		ids += postArr[x].postid + ',';
		let limit = $('<div>', { class : 'limit-text' });
		let main = $('<div>', { class : 'post-wrapper-my-posts' });
		let one = $('<div>', { class : 'row' });
		let two = $('<div>', { class : 'col-sm-12' });
		let twoTwo = $('<div>', { class : 'col-sm-4 likes' });
		let twoThree = $('<div>', { class : 'col-sm-4' });
		let twoFour = $('<div>', { class : 'col-sm-4' });
		let three = $('<div>', { class : 'col-sm-2' });
		let threeTwo = $('<div>', { class : 'col-sm-10 text-left' });
		let threeImg = $('<img>', {
			class	:	'img-circle',
			alt		:	"user image",
			src		:	imagePath + "user.jpg"
		});
		let threep1 = $('<p>', {
			text	:	postArr[x].fullname
		});
		let threep2 = $('<p>', {
			class	:	'post-date grey-txt',
			text	:	'Posted on : ' + postArr[x].datecreated
		});
		let threep3 = $('<p>', {
			class	:	'post-date grey-txt',
			text	:	'Last Updated : ' + postArr[x].dateupdated
		});
		let threepTwoh3 = $('<h3>', {
			class	:	'post-title',
			text	:	postArr[x].posttitle
		});
		let threepTwoh4 = $('<h4>', {
			class	:	'post-cat grey-txt',
			text	:	postArr[x].posttype
		});
		let threepTwop = $('<p>', {
			class	:	'post-desc',
			text	:	 postArr[x].post
		});
						
		let twoThreea = $('<a>', {
			class		:	'view-comments italic', 
			href		: 	'#', 
			'data-attr'	:	'#' + postArr[x].postid,
			text 		: 	'view comments'
		});			
		let twoFourbtn = $('<button>', {
			class 		: 'btn bg-primary btn-sug-action', 
			'postid' 	: 	postArr[x].postid, 
			text 		: 'Suggest Post'
		});
		let deleteBtn = $('<button>', {
			class 		: 'btn bg-primary delete-post-btn', 
			'postid' 	: 	postArr[x].postid, 
			text 		: 'Delete Post'
			
		});
		let readMore = $('<a>', {
			'href' 	: 	'#' + postArr[x].postid, 
			'class'	:	'readMorePost italic',
			'text' : 	'..readmore'
		});		
		let hiddenPostid = $('<input>', {
			'type' 	: 	'hidden', 
			'class'	:	'postId',
			'value' : 	postArr[x].postid
		});		

		
		$(main).html(one).append(hiddenPostid);
		$(one).html(two);
		$(two).html(three).append(threeTwo);
		
		$(twoThree).html(twoThreea);
		$(twoFour).html(deleteBtn);
		$(three).html(threeImg).append(threep1).append(threep2).append(threep3);
		$(limit).html(threepTwop).append(readMore);
		$(threeTwo).html(threepTwoh3).append(threepTwoh4).append(limit).append(twoTwo).append(twoThree).append(twoFour);


		$('#panel3').append(main);
	}
	
}
	//Get Comments
	function getMyPosts() {		
		$.get("/JobSeekMum/listMyPosts")
		.done(retrieveMyPosts)
		.fail(function(){
			showMessage(errorMsg, "Error get comments");
		})
	}
	/*
	 * SuggetsPost Btn from post 
	 */

	$('#panel2').on('click', '.btn-sug-action', function() {
		//Clear items
		$('#listUserToSug').empty();
		
		//Set idPost
		$("#idPostSug").val($(this).attr("postid"));
		
		//Get all users
		$.ajax("/JobSeekMum/getUsers",{
			"type":"POST"
		}).done(function(data){
			//console.log(data);
			var data = JSON.parse(data).data;
			console.log(data);
			var listitems;
			$.each(data, function(key, value){
			    listitems += '<option value=' + value.userid + '>' + value.fullname + '</option>';
			});
			$("#listUserToSug").append(listitems);
		})
		  .fail(function(){
			  showMessage(errorMsg, "Error suggest post");
		  })
	});
	
	//Action of Suggest Btn in Window
	$("#btnSuggetPost").click(function(){
		//Select userid
		var userId = $("#listUserToSug").val()
		var postId = $("#idPostSug").val(); 
			
		//console.log("Attribute postId:" + postId + " user: " + userId);
		$.ajax("/JobSeekMum/addSuggestPost",{
			"type":"POST",
			"data": { 
				"postId": postId,
				"toUserId": userId
			},
		}).done(function(){
			$('#suggestModal').modal('hide');
			$("#messageSpace").append(successMsg);
		})
		  .fail(function(){
			  showMessage(errorMs, "Error suggest post window");
		  })
	});
	
	
	
	
	/*
	 * Get POSTS
	 */
	$.when(getPosts(), getComments(1)).done(function(data){
		//let com = getComments(1);
		$('#temp-container').text(data);
		console.log(data);
	});
	function getPosts() {		
		$.get("/JobSeekMum/listUserPosts")
			.done(retrievePosts)
			.fail(function(){
				showMessage(errorMsg, "Error Get Posts");
			})
	}
	function retrievePosts(data) {
		let postArr = JSON.parse(data).data; 
		let ids = "";
		for (let x in postArr){
			
			ids += postArr[x].postid + ',';
									
			let limit = $('<div>', { class : 'limit-text' });
			let main = $('<div>', { class : 'post-wrapper' });
			let one = $('<div>', { class : 'row' });
			let two = $('<div>', { class : 'col-sm-12' });
			let twoTwo = $('<div>', { class : 'col-sm-4 likes' });
			let twoThree = $('<div>', { class : 'col-sm-4' });
			let twoFour = $('<div>', { class : 'col-sm-4' });
			let three = $('<div>', { class : 'col-sm-2' });
			let threeTwo = $('<div>', { class : 'col-sm-10 text-left' });
			let threeImg = $('<img>', {
				class	:	'img-circle',
				alt		:	"user image",
				src		:	imagePath + "user.jpg"
			});
			let threep1 = $('<p>', {
				text	:	postArr[x].fullname
			});
			let threep2 = $('<p>', {
				class	:	'post-date grey-txt',
				text	:	'Posted on : ' + postArr[x].datecreated
			});
			let threep3 = $('<p>', {
				class	:	'post-date grey-txt',
				text	:	'Last Updated : ' + postArr[x].dateupdated
			});
			let threepTwoh3 = $('<h3>', {
				class	:	'post-title',
				text	:	postArr[x].posttitle
			});
			let threepTwoh4 = $('<h4>', {
				class	:	'post-cat grey-txt',
				text	:	postArr[x].posttype
			});
			let threepTwop = $('<p>', {
				class	:	'post-desc',
				text	:	 postArr[x].post
			});
			
			/*likes*/
			let twoTwoA = $('<a>', {
				'data-toggle'	:	'tooltip',
				id				:	postArr[x].postid + '_a',
				href			: 	"#",
				class			:	"anchorImage"
			});			
			let twoTwoImg = $('<img>', {
				alt		:	'like',
				src		:	imagePath + 'like.png',
				id		:	postArr[x].postid + '_img'
			});			
			let twoTwoInput = $('<input>', {
				type	:	'hidden',
				id		:	postArr[x].postid + '_input'
			});			
			let twoTwoSpan = $('<span>', {
				class 	: 'grey-txt', 
				text 	: '0',
				id		:	postArr[x].postid + '_span'
			});
			/*likes*/
			
			let twoThreea = $('<a>', {
				class		:	'view-comments italic', 
				'href'		: 	'#', 
				'data-attr'	:	postArr[x].postid,
				'text' 		: 	'view comments'
			});			
			let twoFourbtn = $('<button>', {
				class 		: 	'btn bg-primary btn-sug-action', 
				'data-toggle':	'modal',
				'data-target':	'#suggestModal',
				'postid' 	: 	postArr[x].postid, 
				text 		: 	'Suggest Post'
			});
			let readMore = $('<a>', {
				'href' 	: 	'#' + postArr[x].postid, 
				'class'	:	'readMorePost italic',
				'text' : 	'..readmore'
			});		
			let hiddenPostid = $('<input>', {
				'type' 	: 	'hidden', 
				'class'	:	'postId',
				'value' : 	postArr[x].postid
			});		
			//getComments(1)

			$(twoTwoA).append(twoTwoImg);

			$(main).html(one).append(hiddenPostid);
			$(one).html(two);
			$(two).html(three).append(threeTwo);
			$(twoTwo).html(twoTwoA).append(twoTwoSpan).append(twoTwoInput);
			$(twoThree).html(twoThreea);
			$(twoFour).html(twoFourbtn);
			$(three).html(threeImg).append(threep1).append(threep2).append(threep3);
			$(limit).html(threepTwop).append(readMore);
			$(threeTwo).html(threepTwoh3).append(threepTwoh4).append(limit).append(twoTwo).append(twoThree).append(twoFour);
		

			$('#profileLink').attr('id', postArr[x].userid);
			$('#panel2').append(main);

		}
		
		$('#replyObj1').text(ids);
		setLikes(1);
		
	}
	//get Comments
	function getComments(pid) {				
		$.post("/JobSeekMum/viewComment",{"postId":pid}).done(function(data) {console.log(data);return data});//.fail(showMessage(errorMsg));		
	}	
	
	$('.tab-link').click(function(e){
		   let tabId = $(this).attr('data-panel');
		   $('.tab-link').removeClass('active-tab');
		   $(this).addClass('active-tab');
		   $('.post-panel').addClass('hide');
		   $(tabId).removeClass('hide');
		   e.preventDefault();
   });
	$('.tab-menu li:first-child a').click();
//	$('#panel2').on('click', '.postId', function(x){
//		console.log(x);
//	});
//	$('.postId').click();
//	$('body').on('load', '.post-panel', function(x){
//			$(this).hide();
//	});
	    //$('.post-panel').hide();  
//	    $('.post-panel:first-child').show();
	function retrieveComments(data) {
		let comArr = JSON.parse(data).data; 
		console.log(comArr);
		$('.post-wrapper').append(comArr);
		for (let x in comArr){
			let main = $('<div>', { class : 'post-wrapper' });
			let one = $('<div>', { class : 'row' });
			let two = $('<div>', { class : 'col-sm-12' });
			let twoTwo = $('<div>', { class : 'col-sm-4 likes' });
			let twoThree = $('<div>', { class : 'col-sm-4' });
			let twoFour = $('<div>', { class : 'col-sm-4' });
			let three = $('<div>', { class : 'col-sm-2' });
			let threeTwo = $('<div>', { class : 'col-sm-10 text-left' });
			let threeImg = $('<img>', {
				class	:	'img-circle',
				alt		:	"user image",
				src		:	imagePath + "user.jpg"
			});
			let threep1 = $('<p>', {
				text	:	comArr[x].fullname
			});
			let threep2 = $('<p>', {
				class	:	'post-date grey-txt',
				text	:	'Posted on : ' + comArr[x].datecreated
			});
			let threep3 = $('<p>', {
				class	:	'post-date grey-txt',
				text	:	'Last Updated : ' + comArr[x].dateupdated
			});
			let threepTwoh3 = $('<h3>', {
				class	:	'post-title',
				text	:	comArr[x].posttitle
			});
			let threepTwoh4 = $('<h4>', {
				class	:	'post-cat grey-txt',
				text	:	comArr[x].posttype
			});
			let threepTwop = $('<p>', {
				class	:	'post-desc',
				text	:	 comArr[x].post
			});
			let twoTwoImg = $('<img>', {
				alt		:	'like image',
				src		:	imagePath + 'like.png'
			});
			let twoTwoSpan = $('<span>', {class : 'grey-txt', text : '30'});
			let twoThreea = $('<a>', {
				class		:	'view-comments italic', 
				'href'		: 	'#', 
				'data-attr'	:	comArr[x].postid,
				'text' 		: 	'view comments'
			});			
			let twoFourbtn = $('<button>', {
				class 		: 'btn bg-primary btn-sug-action', 
				'postid' 	: 	comArr[x].postid, 
				text 		: 'Suggest Post'
			});
			let readMore = $('<a>', {
				'href' 	: 	'#' + comArr[x].postid, 
				'class'	:	'readMorePost italic',
				'text' : 	'..readmore'
			});		
			let hiddenPostid = $('<input>', {
				'type' 	: 	'hidden', 
				'class'	:	'postId',
				'value' : 	comArr[x].postid
			});		
			

			
			$(main).html(one).append(hiddenPostid);
			$(one).html(two);
			$(two).html(three).append(threeTwo);
			$(twoTwo).html(twoTwoImg).append(twoTwoSpan);
			$(twoThree).html(twoThreea);
			$(twoFour).html(twoFourbtn);
			$(three).html(threeImg).append(threep1).append(threep2).append(threep3);
			$(threeTwo).html(threepTwoh3).append(threepTwoh4).append(twoTwo).append(twoThree).append(twoFour);
		
			$('#panel2').append(main);
			return two;
		}
		
	}
	/*	 *				
						<div class="row">
							<div class="comment col-sm-10 col-sm-offset-1">
								<div class="col-sm-2">
									<img class="img-circle" alt="user image" src="<%=request.getContextPath() %>/resources/images/user.jpg">
								</div>
								<div class="col-sm-10 text-left">
									<h5 class="comment-name bold clearfix">
										<a href="#" class="pull-left">Mafi M Aboye</a>
										<p class="pull-right grey-txt"><em>2 days ago</em></p>
									</h5>
									<p>
									    Duis aute irure dolor in reprehenderit in voluptate velit esse
                                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
									</p>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="new-comment comment col-sm-10 col-sm-offset-1">
								<div class="col-sm-10 col-sm-offset-1 text-left">
									<form action="">
										<textarea class="form-control" placeholder="Write Your Comment Here..."></textarea>
										<button class="btn bg-primary space-sm" type="submit">Post</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					
					
	 */
	function myPostCleanMsg(){
		 $("#myPostType").val('');
		 $("#myPostBody").val('');
		 $("#myPostTitle").val('');
		 
		 $("#myPostSubmit").attr('disabled','disabled');
		 $("#addPostModal").modal('hide');

	}
	
	/*
	 * SuggestedPosts
	 */
	
	
	function suggestPost(toUserId, postId){
		$.ajax("/JobSeekMum/addSuggestPost",{
			"type":"POST",
			"data": { 
				"toUserId": toUserId,
				"postId": postId
			},
		}).done($("#messageSpace").append(successMsg))
		  .fail(function(){
			  showMessage(errorMsg, "Error Add suggest post");
		  })
	}
	
	function listSuggestedPosts(){
	
		$.ajax("/JobSeekMum/listSuggestPost",{
			"type":"POST"
		}).done(showSuggestedPosts)
		  .fail(function(){
			  showMessage(errorMsg, "Error list suggeted posts");
		  })
	}
	//Show suggested posts
	function showSuggestedPosts(data){
		var dataDisplay = "";
		let postArr = JSON.parse(data).data;
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
	

	
	/******** LIKES *********/
	function setLikes(obj)
	{
		//alert('setLikes' + obj);
		
		let ids = $('#replyObj'+obj).text().split(',');
		if(ids.length > 0)
		{
			console.log(ids);
			for(let i in ids)
			{
				if(ids[i] != '')
				{
					let id_a = ids[i] + '_a';
					let id_input = ids[i] + '_input';
					let id_img = ids[i] + '_img';
					
					getLikePerUserPost(ids[i]);
					updateLikes(ids[i]);//# of likes and names 
					
					$("#" +id_a).click(function(){
						likeUnlikePost(id_img,ids[i],id_input);						
						return false;
					});
				}
			}
		}
	}
	
	
	function likeUnlikePost(id_img,postId,id_input)
	{
		var action = $("#"+id_img).attr("alt");
		var likeId = $("#" +id_input ).val();
		//alert(action);
		if(action === "like")
		{
			saveLike(postId);
		}
		else
		{
			removeLike(likeId,postId);				
		}	
		setTimeout(function(){ updateLikes(postId); }, 1000);
	}
	//**1**----------- ajax call
	function saveLike(postId)
	{
		$.ajax("/JobSeekMum/setLike",{
			"type":"POST",
			"async": "false",
			"data": { 
				"postId": postId
				
			}
		}).done(function(a,b,c){saveLikeSuccess(a,b,c,postId);})
		  .fail(showError);			
	}
	//------------callback------
	function saveLikeSuccess(data,b,c,postId)
	{
		//alert('saveLikeSuccess');
		let id = JSON.parse(data).data[0].likeid;
		$("#" + postId + "_input" ).val(id);
		$("#" + postId + "_img").attr("alt","unlike");
		let src = $("#" + postId + "_img").attr("src").toString();
		src = src.replace("like.png","like2.png");
		$("#" + postId + "_img").attr("src",src);
	}
	//-----------------------------
	
	//**2**----------- ajax call
	function removeLike(likeId,postId)

	{
		$.ajax("/JobSeekMum/unLike",{
			"type":"POST",
			"async": "false",
			"data": { 
				"likeId": likeId
			}

		}).done(function(a,b,c){removeLikeSuccess(a,b,c,likeId,postId)})
		  .fail(showError);

	}
	//------------callback------
	function removeLikeSuccess(data,b,c,likeId,postId)
	{
		$("#" + postId + "_input" ).val("");
		$("#" + postId + "_img").attr("alt","like");
		let src = $("#" + postId + "_img").attr("src").toString();
		src = src.replace("like2.png","like.png");
		$("#" + postId + "_img").attr("src",src);
	}	
	
	//**3**----------- ajax call
	function updateLikes(postId)
	{
		$.ajax("/JobSeekMum/getLikes",{
			"type":"POST",
			"async": "false",
			"data": { 
				"postId": postId
			}
		})
		.done(function(a,b,c){updateLikesSuccess(a,b,c,postId)})
		  .fail(showError);			

	}
	//------------callback------
	function updateLikesSuccess(data,b,c,postId)
	{
		var users = JSON.parse(data).data;
		var usersNames="";
		for(var obj in users)
		{
			usersNames += users[obj].fullname + '\n';
		}
		$("#" + postId + "_span" ).text(users.length);
		$("#" + postId + "_a").attr("title",usersNames);
	}
	//---------------------------
	
	//**4**----------- ajax call
	function getLikePerUserPost(postId)
	{
		
		$.ajax("/JobSeekMum/getLikePerUserPost",{
			"type":"POST",
			"async": "false",
			"data": { 
				"postId": postId
			}
		}).done(function(a,b,c){getLikePerUserPostSuccess(a,b,c,postId)})
		  .fail(showError);			
	}	
	//------------callback------
	function getLikePerUserPostSuccess(data,b,c,postId)
	{		
		console.log('getLikePerUserPostSuccess' + data);
		let objData = JSON.parse(data).data;
		//alert(objData.length);
		if(objData.length > 0)
		{
			$("#" + postId + "_input").val(data.likeid);
			$("#" + postId + "_img").attr("alt","unlike");			
			let src = $("#" + postId + "_img").attr("src").toString();			
			src = src.replace("like.png","like2.png");
			$("#" + postId + "_img").attr("src",src);
		}
	}
	

	function showError()
	{
		console.log("ERRORR");
	}

	/*
	 * Profile Window
	 */
	$("#myProfile").click(function(){
		$('#profile').modal('show');
		$.ajax("/JobSeekMum/viewUserProfile",{
			"type":"POST"
		}).done(function(data){
			data = JSON.parse(data);
			console.log(data);
			$("#fullName").val(data[0].fullname);
			$("#gender").val(data[0].gender);
			$("#birthYear").val(data[0].birthyear);
			$("#state").val(data[0].state);
			$("#city").val(data[0].city);
			$("#street").val(data[0].street);
			$("#zipCode").val(data[0].zipcode);
			$("#email").val(data[0].email);
		}).fail(function(){
			showMessage(errorMsg,"Error Create My Post");
		})
		
	});
	
	
});