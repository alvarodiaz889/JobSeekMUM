<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Super Omega - Job Discover</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mafi, Alvaro, Daniyal, German">

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath() %>/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath() %>/resources/assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->

<link
	href="<%=request.getContextPath() %>/resources/assets/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS -->

<link
	href="<%=request.getContextPath() %>/resources/assets/css/creative.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/assets/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/assets/js/creative.js"></script>
<!-- AJAX Functions -->
<script type="text/javascript"
	src="<%=request.getContextPath() %>/resources/assets/js/ajax.js"></script>




</head>
<body id="page-top">
	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	<div class="messageSpace" id="messageSpace"></div>

	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top">User
				&nbsp;<span><em>Profile</em></span>
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					
			</ul>
		</div>

		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>







</body>
<header>

<div class="header-content">
	<hr>
	<div class="post-panel panel panel-default">
		<div class='post-wrapper'>
			<div class="row">
				<div class="col-sm-12">
					<img class="img-circle" src="/JobSeekMum/resources/images/user.jpg"
						alt="user-img">
				</div>
				<div class="col-sm-12">
					<h3 class='post-title'>
						${userList[0].fullname} (
						<c:choose>
							<c:when test="${userList[0].gender eq 0}">
         					<u>Female</u> 
							</c:when>
							<c:otherwise>
           				<u>Male</u> 
						
         					</c:otherwise>
						</c:choose>
						)
					</h3>
				</div>

				<div class="col-sm-12">
					<h3 class='post-title'><u>ADDRESS:</u> ${userList[0].street}
						${userList[0].city} ${userList[0].state}</h3>
				</div>
				<div class="col-sm-12">
					<h3 class='post-title'><u>ZIPCODE:</u> ${userList[0].zipcode}</h3>
				</div>
				<div class="col-sm-12">
					<h3 class='post-title'><u>CONTACT INFO:</u> ${userList[0].email}</h3>
				</div>
			</div>
		</div>
	</div>
</div>

</header>
</html>
