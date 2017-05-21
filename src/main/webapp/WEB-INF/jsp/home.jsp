Skip to content
This repository
Search
Pull requests
Issues
Gist
 @danialSaeed92
 Sign out
 Watch 3
  Star 0
  Fork 0 danialSaeed92/JobSeekMum
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Pulse  Graphs  Settings
Branch: master Find file Copy pathJobSeekMum/src/main/webapp/WEB-INF/jsp/home.jsp
55f8f35  23 minutes ago
@MafiM MafiM not able to find resources
2 contributors @MafiM @danialSaeed92
RawBlameHistory     
156 lines (142 sloc)  6.25 KB
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Super Omega - Job Discover</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mafi, Alvaro, Danyal, German">


    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
<<<<<<< HEAD
    <link href="src/main/resources/assets/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->

    <link href="src/main/resources/assets/css/creative.css" rel="stylesheet">
=======
    <link href="<%=request.getContextPath() %>/resources/assets/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->

    <link href="<%=request.getContextPath() %>/resources/assets/css/creative.css" rel="stylesheet">
>>>>>>> origin/master

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
</head>
<body id="page-top">
	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Super Omega &nbsp;<span><em>Job Discover</em></span></a>
            </div>				
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                		<h5 class="msg">${msg }</h5>
                	</li>
                    <li>
                        <a class="page-scroll" href="#" data-toggle="modal" data-target="#loginModal">LOG IN</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#" data-toggle="modal" data-target="#signupModal">SIGN UP</a>
                    </li>                    
                </ul>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLabel">Log In</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
<<<<<<< HEAD
                ...
=======
                	<form action="<%=request.getContextPath()%>/post.do">
                		<div class="form-group">
                			<input type="email" id="loginEmail" class="form-control" name="email" placeholder="Enter Email Here.." required>
                		</div>
                		<div class="form-group">
                			<input type="password" id="loginPw" class="form-control" name="password" placeholder="Enter Password Here.." required>
                		</div>
                		<div class="form-group">
                			<input type="submit" class="btn" value="Log In">
                		</div>
					</form>
>>>>>>> origin/master
                </div>
            </div>
        </div>
    </div>
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title" id="exampleModalLabel">Sign Up</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                	<form action="<%=request.getContextPath()%>/signUp.do" method="post">
                		<div class="form-group">
                			<input type="text" id="fullName" class="form-control" name="fullName" placeholder="Enter Full Name.." required>
                		</div>
                		<div class="form-group">
                			<div class="col-sm-6">
                				<select class="form-control" name="gender">
                					<option value="f" selected>Female</option>
                					<option value="m">Male</option>
                				</select>
                			</div>
                			<div class="col-sm-6">
                				<input type="number" name="birthYear" placeholder="Birth Year" class="form-control" required>
                			</div>
                		</div>
                		<div class="form-group">
                			<div class="col-sm-6">
                				<input type="text" name="state" placeholder="State" class="form-control" required>
                			</div>
                			<div class="col-sm-6">
                				<input type="text" name="city" placeholder="City" class="form-control" required>
                			</div>
                		</div>
                		<div class="form-group">
                			<div class="col-sm-6">
                				<input type="number" name="zipCode" placeholder="Zip Code" class="form-control" required>
                			</div>
                			<div class="col-sm-6">
                				<input type="email" name="email" placeholder="Email" class="form-control" required>
                			</div>
                		</div>
                		<div class="form-group">
                			<input type="password" id="loginPw" class="form-control" name="password" placeholder="Enter Password Here.." required>
                		</div>
                        <div class="form-group">
                            <input type="password" id="loginPwConf" class="form-control" name="confPassword" placeholder="Confirm Password.." required>
                        </div>
                		<div class="form-group">
                			<input type="submit" class="btn" value="Sign Up">
                		</div>
					</form>
                </div>
            </div>
        </div>
    </div>
    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">Your Favorite Source of Free Job posts</h1>
                <hr>
                <p>
                    Start browsing public and suggested posts. And, add your own post as well!
                </p>
                <!-- <a href="#about" class="btn btn-primary btn-xl page-scroll">Find Out More</a> -->
            </div>
        </div>
    </header>	
	<jsp:include page="post.jsp" />
	
	<h1>${msg }</h1>

	<form action="<%=request.getContextPath()%>/signUp.do" method="post">
		<table>
			<tr>
				<td><label>Full Name</label></td>
				<td><input type="text" name="fullName" /></td>
			</tr>
			<tr>
				<td><label>Gender</label></td>
				<td><select name="gender"><option value="f">Female</option>
						<option value="m">Male</option></select></td>
			</tr>
			<tr>
				<td><label>BirthYear</label></td>
				<td><input type="text" name="birthYear" /></td>
			</tr>
			<tr>
				<td><label>State</label></td>
				<td><input type="text" name="state" /></td>
			</tr>
			<tr>
				<td><label>Street</label></td>
				<td><input type="text" name="street" /></td>
			</tr>
			<tr>
				<td><label>City</label></td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td><label>Zip Code</label></td>
				<td><input type="number" name="zipCode" /></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="signUp" />
	</form>q
>>>>>>> 783a28154b7d31a484c6c6d78611acb4ecf42117
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/assets/js/bootstrap.min.js"></script>
</html>
