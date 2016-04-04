<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<script src="<c:url value="/js/jquery-min.js" />"></script>
<script src="<c:url value="/js/create.js" />"></script>
<meta charset="UTF-8">
<title>Group 17</title>
</head>
<body style="background-color: #3EA99F">
	<center>
		<font color="white" face="verdana" size="">
			<h2>User Profile</h2>
		</font>

		<form method="POST" action="/cmpe275-lab2/profile">
			<font face="verdana">

				<table>
					<tr height="40">
						<td>UserID:</td>
						<td><input type="text" name="userid"></td>
					</tr>
					<tr height="40">
						<td>First Name:</td>
						<td><input type="text" name="firstname"></td>
					</tr>
					<tr height="40">
						<td>Last Name:</td>
						<td><input type="text" name="lastname"></td>
					</tr>
					<tr height="40">
						<td>Email:</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr height="60">
						<td>Address:</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td>Organization:</td>
						<td><input type="text" name="organization"></td>
					</tr>
					<tr height="60">
						<td>About Myself:</td>
						<td><input type="text" name="aboutmyself"></td>
					</tr>
					<br>
					<tr>

					</tr>
					<tr height="60">

						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Create"
							name="create" class="CREATE_BTN" /></td>
					</tr>

				</table>
			</font>
		</form>
</body>
</html>