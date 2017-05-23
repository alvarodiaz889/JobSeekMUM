<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Weather </title>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/assets/js/weather.js"></script>
	<style type="text/css">
		
		body{
			background:#4479ce;
			font-family:arial;
		}
		
		h1{text-align:center;}
		
		.myclass{
			width:120px;
			height:210px;
			background:#becfea;
			float:left;
			margin:5px;
			box-sizing:border-box;
			padding: 10px;
		}
		
		#actual{
			float:right;
			width:30%;
			background:#becfea;
			box-sizing:border-box;
			padding: 10px;
		}
		
		#map-canvas{
			width:90%;
			background:blue;
			margin:20px auto; 
			height:400px;
			
		}
		
		#itemscontainer{
			width:80%;
			background:#4479ce;
			margin:0 auto; 
			height:220px;
		}
		
		#map-container{
			width:70%;
			float:left;
		}
	</style>
</head>
<body>
<div id='actual'>
	
	<form>
		<p>UNITS:</p>
		<label><input type="radio" name="grades" value="metric" checked> Celcius</label>
		<label><input type="radio" name="grades" value="imperial"> Fahrenheit</label>
		<label><input type="radio" name="grades" value="" > Kelvin</label>
		<p>City Name:</p>
		<label><input id='cityName' type="text" ></label>
		<p>ZIP Code:</p>
		<label><input id='zipCode' type="text" ></label>
		<input id='submitBtn' type="button" value='Search'>
	</form>
	
	<hr>
	<h3></h3>
	<img />
	<p></p>
</div>
<div id="map-container">
	<h1>WEATHER FORECAST</h1>
	<div id='map-canvas'>
	</div>
	<div id='itemscontainer'>
		<div class='myclass' id='first'>
			<h3></h3>
			<img />
			<p></p>
		</div>
		<div class='myclass' id='second'>
			<h3></h3>
			<img />
			<p></p>
		</div>
		<div class='myclass' id='third'>
			<h3></h3>
			<img />
			<p></p>
		</div>
		<div class='myclass' id='fourth'>
			<h3></h3>
			<img />
			<p></p>
		</div>
		<div class='myclass' id='fifth'>
			<h3></h3>
			<img />
			<p></p>
		</div>
	</div>
</div>
</body>
</html>