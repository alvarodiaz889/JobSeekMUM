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