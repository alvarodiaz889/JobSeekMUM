<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/post.do">
		<table>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" /></td>
			</tr>
		</table>
	</form>
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
	</form>
</body>
</html>