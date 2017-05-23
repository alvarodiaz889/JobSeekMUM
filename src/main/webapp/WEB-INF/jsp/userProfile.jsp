<div class="modal fade" id="profileWindow" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h2 class="modal-title" id="exampleModalLabel">Profile</h2>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body"> 
							<form method="post">
								<div class="image">
									<img id="profileImg" class="img-circle" alt="" src="/JobSeekMum/resources/images/user.jpg">
								</div>
								<div class="form-group">
									<input type="text" id="fullName" class="form-control"
										name="fullName" placeholder="Enter Full Name.." required>
								</div>
								<div class="form-group">
									<div class="col-sm-6">
										<select class="form-control" name="gender">
											<option value="0" selected>Female</option>
											<option value="1">Male</option>
										</select>
									</div>
									<div class="col-sm-6">
										<input type="number" name="birthYear" id="birthYear" placeholder="Birth Year"
											class="form-control" required>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-6">
										<input type="text" name="state" id="state" placeholder="State"
											class="form-control" required>
									</div>
									<div class="col-sm-6">
										<input type="text" name="city" id="city" placeholder="City"
											class="form-control" required>
									</div>
								</div>
								<div class="form-group">
									<input type="text" id="street" name="street" placeholder="Street"
										class="form-control" required>
								</div>
								<div class="form-group">
									<div class="col-sm-6">
										<input type="number" id="zipCode" name="zipCode" placeholder="Zip Code"
											class="form-control" required>
									</div>
									<div class="col-sm-6">
										<input type="email" id="email" name="email" placeholder="Email"
											class="form-control" required>
									</div>
								</div>
								<div class="form-group">
									<input type="password" id="loginPw" class="form-control"
							name="password" placeholder="New Password Here.." required ="required"  pattern ="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$" title="Password should be 6 character or more and should have atleast one capital,one small letter and one digit">
								</div>
								<div class="form-group">
									<input type="password" id="loginPwConf" class="form-control"
										name="confPassword" placeholder="Confirm Password.." required ="required" pattern ="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$" title="Password should be 6 character or more and should have atleast one capital,one small letter and one digit">
								</div>
								<div class="form-group">
									<input type="submit" class="btn" value="Update">
									<a class="btn weather-btn" target="_blank" href="<%=request.getContextPath() %>/viewWeather.do">Weather</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>