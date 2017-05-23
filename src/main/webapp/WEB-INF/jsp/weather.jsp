<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Weather </title>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&key=AIzaSyByuKJU__Q6vqW3CjwYYgVWcpM6ENisElc"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/assets/js/weather.js"></script>
	<link href="<%=request.getContextPath() %>/resources/assets/css/creative.css" rel="stylesheet">
</head>
<body>
<div id='actual'>
	
	<form>
		<p>UNITS:</p>
		<label>
			<input id="zipCo" type="hidden" value="${userInfo[0].zipCode}">
			<input id="cityNa" type="hidden" value="${userInfo[0].city}">
		</label>
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