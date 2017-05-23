"use strict";
		
		$(document).ready(function() {
				
				
			
			$.ajaxSetup({ cache: false });	
			let city = 'fairfield';
			
			var zipCode = $('#zipCo').val();
			var cityName = $('#cityNa').val();
			showWeather(cityName,zipCode,'metric');
			
			// get location button functionality
			$("#submitBtn").click(function(event){
				let city = 	$('#cityName').val();
				let zip = 	$('#zipCode').val();	
				let units = $('input[name=grades]:checked').val();
				
				if(city == '' && zip == '' )
				{
					alert('Fill the ZIP code or the City Name');
					return false;
				}
				
				showWeather(city,zip,units);

			});		
			
			

		});
		
		function showWeather(cityName,zipCode,units)
		{
			let query = '';
			let grades = '';
			
			if(zipCode != '')
				query = 'http://api.openweathermap.org/data/2.5/forecast?zip='+ zipCode +',us&APPID=0a992b780ebcd379816efad9a9237e87';
			else
				query = 'http://api.openweathermap.org/data/2.5/forecast?q='+ cityName +',us&APPID=0a992b780ebcd379816efad9a9237e87';
			
			if(units == 'metric')//Celcius
			{
				query = query + '&units=' + units;
				grades = '&#176;C';
			}
			else if(units == 'imperial')//Fahrenheit
			{
				query = query + '&units=' + units;
				grades = '&#176;F';
			}
			else// default - Kelvin
			{
				grades = '&#176;K';
			}
						
			$.getJSON( query, function(data) {	
					console.log(data);				
					
					
					var geocoder	= new google.maps.Geocoder();
					var latlng		= new google.maps.LatLng(40.6700, -73.9400);
					var mapOptions	= {		// options for map
						zoom: 8,
						center: latlng
					}
					var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);	// create new map in the map-canvas div
					console.log('jsonToGeoJson');
					var jsonToGeoJson = function (weatherItem) {
					//weatherItem indicates the weather data object
					console.log(weatherItem);
						var feature = {
							type: "Feature",
							properties: {
								city: weatherItem.city.name,
								weather: weatherItem.list[0].weather[0].main,
								temperature: weatherItem.list[0].main.temp,
								min: weatherItem.list[0].main.temp_min,
								max: weatherItem.list[0].main.temp_max,
								humidity: weatherItem.list[0].main.humidity,
								pressure: weatherItem.list[0].main.pressure,
								windSpeed: weatherItem.list[0].wind.speed,
								windDegrees: weatherItem.list[0].wind.deg,
								windGust: 0,
								myicon: "http://openweathermap.org/img/w/"+ weatherItem.list[0].weather[0].icon + ".png",
								coordinates: [weatherItem.city.coord.lon, weatherItem.city.coord.lat]
							},	
							geometry: {
							type: "Point",
							coordinates: [weatherItem.city.coord.lon, weatherItem.city.coord.lat]
							}
						};
						map.data.setStyle(function(feature){ //Set the custom marker icon
							return {
								icon: {
								url: feature.getProperty('icon'),
								anchor: new google.maps.Point(100, 100)
								}
							};
						});
						return feature; // returns the translated GeoJson object
					};
									
					
					var getData = function(data){
						
						var days = [];
						var indx = [];
						var count = 0;
						var content = '';
												
						for(let w in data.list)
						{
							let obj = data.list[w];
							let date = obj.dt_txt.split(' ')[0];
							if(days.indexOf(date) == -1)
							{
								days[count] = date;
								indx[count] = w;
								count++;
							}
						}
						
						$('.myclass').css("visibility","hidden");
						//displaying the 5 days
						if(indx.length >= 1)
						{
							let title = data.city.name + ', ' +data.city.country;
							content = data.list[indx[0]].main.temp + ' '+ grades;
							let description = "<b>" + content + '</b><br><br>' 
								+ data.list[indx[0]].weather[0].main + ' :<br>' + data.list[indx[0]].weather[0].description + '<br><br>'
								+ 'humidity:<br>' + data.list[indx[0]].main.humidity + '<br><br>' 
								+ 'pressure:<br>' + data.list[indx[0]].main.pressure;
							$('#actual').css("visibility","visible");
							$('#actual img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[0]].weather[0].icon + ".png");
							$('#actual > p').html(description);
							$('#actual h3').text(title);
							
						}
						
						if(indx.length >= 2)
						{
							let title = new Date(data.list[indx[1]].dt_txt).toString();
							let description = data.list[indx[1]].main.temp + ' '+ grades + '<br>' 
								+ data.list[indx[1]].weather[0].description;
							$('#first').css("visibility","visible");
							$('#first img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[1]].weather[0].icon + ".png");
							$('#first p').html(description);
							$('#first h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
						}
						
						if(indx.length >= 3)
						{
							let title = new Date(data.list[indx[2]].dt_txt).toString();
							let description = data.list[indx[2]].main.temp + ' '+ grades + '<br>' 
								+ data.list[indx[2]].weather[0].description;
							$('#second').css("visibility","visible");
							$('#second img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[2]].weather[0].icon + ".png");
							$('#second p').html(description);
							$('#second h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
						}
						
						if(indx.length >= 4)
						{
							let title = new Date(data.list[indx[3]].dt_txt).toString();
							let description = data.list[indx[3]].main.temp + ' '+ grades + '<br>' 
								+ data.list[indx[3]].weather[0].description;
							$('#third').css("visibility","visible");
							$('#third img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[3]].weather[0].icon + ".png");
							$('#third p').html(description);
							$('#third h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
						}
						if(indx.length >= 5)
						{
							let title = new Date(data.list[indx[4]].dt_txt).toString();
							let description = data.list[indx[4]].main.temp + ' '+ grades + '<br>' 
								+ data.list[indx[4]].weather[0].description;
							$('#fourth').css("visibility","visible");
							$('#fourth img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[4]].weather[0].icon + ".png");
							$('#fourth p').html(description);
							$('#fourth h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
						}
						
						if(indx.length >= 6)
						{
							let title = new Date(data.list[indx[5]].dt_txt).toString();
							let description = data.list[indx[5]].main.temp + ' '+ grades + '<br>' 
								+ data.list[indx[5]].weather[0].description;
							$('#fifth').css("visibility","visible");
							$('#fifth img').attr("src","http://openweathermap.org/img/w/"+ data.list[indx[5]].weather[0].icon + ".png");
							$('#fifth p').html(description);
							$('#fifth h3').text(title.split(' ')[0] + ' ' +title.split(' ')[2]);
						}					
						 
						return content;
						
					}
					
					var drawIcons = function (data,markContent) {
						let contentString = $('#actual').html().split('</form>')[1].split('<p>')[0] + ''+ markContent;
						
						console.log(contentString);
						var coord = new google.maps.LatLng(data.geometry.coordinates[1], data.geometry.coordinates[0]);
						map.data.addGeoJson(data);	
						map.setCenter(coord);
						//alert(data.properties.myicon);
						var marker = new google.maps.Marker({
							position: coord,
							map: map,
							icon: data.properties.myicon
						  });
						
						var infowindow = new google.maps.InfoWindow({
							content: contentString
						  });
						infowindow.open(map, marker);
						//gettingData = false; // Set the flag to finished
						
					};
					
					var geo = jsonToGeoJson(data);				
					var markContent = getData(data);
					drawIcons(geo,markContent);					
					
				
				});
		}