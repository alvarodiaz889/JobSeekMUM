<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
						
					</div>
					<div class="post-panel panel panel-default" id="panel2">
						<div class="row">
							<div class="col-sm-2">
								<img class="img-circle" alt="user image" src="<%=request.getContextPath() %>/resources/images/user.jpg">
								<p>User Name</p>
								<p class="post-date"><span class="grey-txt">Posted on :</span> 01/01/0001</p>
								<p class="post-date"><span class="grey-txt">Updated on :</span> 01/01/0001</p>
							</div>
							<div class="col-sm-10 text-left">
								<h3 class="post-title">Post Title</h3>
								<h4 class="post-cat grey-txt">Category</h4>
								<p>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
								</p>
							</div>
							<div class="col-sm-4">
								<img class="" alt="like image" src="<%=request.getContextPath() %>/resources/images/like.png">
							</div>
							<div class="col-sm-4"></div>
							<div class="col-sm-4"></div>
							<hr>
						</div>
					</div>
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
					<div class="post-panel  panel panel-default">
						<div class="panel-body" id="panelContent">
						    MyPosts
						</div>
					</div>
	                </div>
            </div>
        </div>
    </section>