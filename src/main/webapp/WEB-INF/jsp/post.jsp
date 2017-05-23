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
					<div class="hide" id="temp-container"></div>
					<div class="post-panel panel panel-default hide" id="panel2">
						
					</div>
					
					<div class="post-panel panel panel-default hide" id="panel3">
						<div class="panel-body" id="panelContent">
						    MyPosts
						</div>						
					</div>
                </div>
            </div>
        </div>
    </section>
    <!-- Suggest Post -->    
    <div class="modal fade" id="suggestModal" tabindex="-1" role="dialog" aria-hidden="true">
       <div class="modal-dialog" role="document">       
           <div class="modal-content">
               <div class="modal-header">
                   <h2 class="modal-title" id="exampleModalLabel">Suggest a Post</h2>
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                       <span aria-hidden="true">&times;</span>
                   </button>
               </div>            
               <div class="modal-body">
					<div id="suggestPostWindow">
						<h3 class="post-title">Suggest Post</h3>
						<select id="listUserToSug"></select>
						<input type="button" class="btn bg-primary" id="btnSuggetPost" value="SUGGEST POST">
						<input type="hidden" id="idPostSug" value="">
					</div>
               </div>
           </div>
         </div>
     </div>
	<!-- Suggets Post -->
    <!-- Post Detail -->    
    <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-hidden="true">
       <div class="modal-dialog" role="document">       
           <div class="modal-content">
               <div class="modal-header">
                   <h2 class="modal-title" id="postTitle"></h2>
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                       <span aria-hidden="true">&times;</span>
                   </button>
               </div>            
               <div class="modal-body">
					<div id="detailPostWindow">
						<p>Posted by : <span id="postedBy" class="bold"></span></p>
						<p>Posted on : <span id="created" class="bold"></span></p>
						<p>Last Updated : <span id="updated" class="bold"></span></p>
						<hr>
						<p>Job Post Category: <span id="postCat" class="bold"></span></p>
						<div class="post-detail-wrapper">
							<p id="postDesc"> </p>
						</div>
					</div>
               </div>
           </div>
         </div>
     </div>
	
    <!-- End Post Detail -->  	