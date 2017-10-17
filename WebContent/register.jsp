<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>ListUser</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Register</title>
</head>
<body>
	<div class="container">
	<div class="text-center">
        <h2>Registration Form</h2>
    </div>
	<hr>
	
	<form action="" class="form-horizontal" method="post">
		 <div class="form-group">
			<label class="col-md-2 label-form" for = "name">Name</label>
			<div class="col-md-4">
				<input class="form-control input-sm" id="name" type="text">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2" for = "nameKana">Name Kana</label>
			<div class="col-md-4">
				<input class="form-control input-sm" id="nameKana" type="text">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2" for = "email">Email</label>
			<div class="col-md-8">
				<input class="form-control input-sm" id="email" type="email">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2" for = "emailConfirm">Confirm Email</label>
			<div class="col-md-8">
				<input class="form-control input-sm" id="emailConfirm" type="email">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2">Gender</label>
			<div class="col-md-4">
				<label class="radio-inline">
					<input type="radio" name="optradio">Male
				</label>
				<label class="radio-inline">
					<input type="radio" name="optradio">Female
				</label>
			</div>
		</div>
		
		
		<div class="form-group">
			<label class="col-md-2 " for = "username">Username</label>
			<div class="col-md-8">
				<input class="form-control input-sm" id="username" type="text">
			</div>
		</div>
		
		 <div class="form-group">
			<label class="col-md-2" for = "pwd">Password</label>
			<div class="col-md-4">
				<input class="form-control input-sm" id="pwd" type="password">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2" for = "address">Address</label>
			<div class="col-md-8">
				<input class="form-control input-sm" id="address" type="text">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2" for = "level">Level Japan</label>
			<div class="col-md-4">
				<select class="form-control input-sm" id="level">
					<option>N1</option>
					<option>N2</option>
					<option>N3</option>
					<option>N4</option>
					<option>N5</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-2" for = "day">Birthday</label>
			<div class ="col-md-4">
				<input class = "form-control input-sm" id ="day" type ="date">
			</div>
		</div>
		
		<div class="form-group">
			<label class ="col-md-2">Favorite</label>
			<div class="checkbox col-md-4">
				<label class="checkbox-inline"><input type="checkbox" >Football</label>
				<label class="checkbox-inline"><input type="checkbox" >Read book</label>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-offset-4 col-md-4">
				<button type="submit" class="btn">Reset</button>
				<button type="reset" class="btn">Confirm</button>
			</div>

		</div>
	</form>
	
</div>
</body>
</html>