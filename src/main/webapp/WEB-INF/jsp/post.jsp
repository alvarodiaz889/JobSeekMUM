<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<section class="bg-primary" id="posts">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center posts">
	                <div class="clearfix">
		                <ul class="nav nav-tabs tab-menu pull-left">
						  <li role="presentation"><a href="#" class="tab-link" data-panel="#panel1">Suggested Jobs</a></li>
						  <li role="presentation"><a href="#" class="tab-link" data-panel="#panel2">Job Posts</a></li>
						  <li role="presentation"><a href="#" class="tab-link" data-panel="#panel3">My Posts</a></li>
						</ul>
		                <div class="pull-right filter">
			                <div class="input-group">
						      <input class="form-control" type="text" placeholder="filter by title here">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
						      </span>
						    </div>
					    </div>
	                </div>
					<div class="post-panel panel panel-default hide" id="panel1">
						<div id="mySugPosts">
						
						</div>
					</div>
					<div class="post-panel panel panel-default hide" id="panel2">
						
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