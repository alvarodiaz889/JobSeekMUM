<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Suggest Post -->    
<div id="suggestPostWindow">
	<h3 class="post-title">Suggest Post</h3>
	<select id="listUserToSug"></select>
	<input type="button" class="btn bg-primary" id="btnSuggetPost" value="SUGGEST POST">
	<input type="hidden" id="idUSerSugPost" value="">
</div>
<!-- Suggets Post -->
    
	<section class="bg-primary" id="posts">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center posts">
	                <ul class="nav nav-tabs">
					  <li role="presentation"><a href="#">Suggested Jobs</a></li>
					  <li role="presentation"><a href="#">Job Posts</a></li>
					  <li role="presentation"><a href="#">My Posts</a></li>
					</ul>
					<div class="post-panel panel panel-default" id="panel1">
						<div id="mySugPosts">
						
						</div>
					</div>
					<div class="post-panel panel panel-default" id="panel2">
<<<<<<< HEAD
						<div class="row">
							<div class="col-sm-12">
								<div class="col-sm-2">
									<img class="img-circle" alt="user image" src="<%=request.getContextPath() %>/resources/images/user.jpg">
									<p>User Name</p>
									<p class="post-date"><span class="grey-txt">Posted on :</span> 01/01/0001</p>
									<p class="post-date"><span class="grey-txt">Last Updated :</span> 01/01/0001</p>
								</div>
								<div class="col-sm-10 text-left">
									<h3 class="post-title">Post Title</h3>
									<h4 class="post-cat grey-txt">Category</h4>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
	                                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
	                                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
	                                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                                        cillum dolore eu fugiat nulla pariatur.
									</p>
								</div>
							</div>
							<div class="col-sm-4 likes">
								<a id="likeLink" data-toggle="tooltip">
									<img id="likeImg" class="" alt="like" src="<%=request.getContextPath() %>/resources/images/like.png">
								</a>
								<input id="likeId" type="hidden" >
								<span id="likeTxt" class="grey-txt">30</span>
							</div>
							<div class="col-sm-4">
								<a href="#" class="view-comments"><em>view comments(10)</em></a>
							</div>
							<div class="col-sm-4">
								<button class="btn bg-primary">Suggest Post</button>
							</div>
						</div>
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
=======
						
>>>>>>> 96f8eedaa84afba1061851091b5a108abe3fc709
					</div>
					<div>
						<div class="post-panel panel panel-default">
							<div class="panel-body" id="panelContent">
							   <div class="form-group">
		                			<div class="col-sm-12">
		                				<select class="form-control  MyPostForm" id="myPostType"  >
		                					<option value="" >Select type</option>
		                					<option value="JAVADEVELOPER" >Java Developer</option>
		                					<option value="NETDEVELOPER">.Net Developer</option>
		                					<option value="WEBDEVELOPER">Web Developer</option>
		                				</select>
		                			</div>
		                			<div class="col-sm-12">
		                				<input type="text" id="myPostTitle" class="form-control MyPostForm" placeholder="Title" >
		                				<br>
		                			</div>
		                			<div class="col-sm-12">
		                				<textarea id="myPostBody" class="form-control MyPostForm"  placeholder="Text" ></textarea>
		                			</div>
		                			<div class="col-sm-12">
		                				<input type="submit" class="btn" value="Submit" id="myPostSubmit" disabled="disabled">
		                			</div>
	                			</div>

							</div>
						</div>
					</div>
					<div class="post-panel  panel panel-default">
						<div class="panel-body" id="panelContent">
						    MyPosts
						</div>
					</div>
	                </div>
            </div>
        </div>
    </section>