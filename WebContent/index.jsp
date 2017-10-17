<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>

<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
 
<body>
	<c:if test="${not empty username}">
		<c:redirect url="/ListUserController"/>	
	</c:if>
	<div class="container">
		<div class="row ">
			<div class="col-sm-offset-4 col-sm-4">
				<h1>Đăng nhập</h1>
				
				 <c:forEach items="${errors}" var="item">
    				  <h4 style = "color: red"><c:out value="${item}" /></h4>
 				 </c:forEach>
				
				<form method="post" action="LoginController">
					<div class="form-group">
						<label for="usr">Name:</label> 
						<input type="text"
							class="form-control" id="usr" name="username">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						 <input type="password"
							class="form-control" id="pwd" name="password">
					</div>
					<div class="row">
						<div class="col-sm-6">
							<button type="submit" class="btn btn-primary btn-block">Submit</button>
						</div>
						<div class="col-sm-6">
							<button type="reset" class="btn btn-danger btn-block">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>