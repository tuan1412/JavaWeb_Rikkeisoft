<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Confirm</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/regformstyle.css">
<link rel="stylesheet" href="css/confirmstyle.css">
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<h2>Confirm Info</h2>
			<table>
				<tbody>
					<tr>
						<th>Full Name</th>
						<td>${regForm.fullName}</td>
					</tr>
					<tr>
						<th>Full Name Kana</th>
						<td>${regForm.fullNameKana}</td>
					</tr>
					<tr>
						<th>Gender</th>
						<td>${regForm.gender}</td>
					</tr>
					<tr>
						<th>Login Name</th>
						<td>${regForm.loginName}</td>
					</tr>
					<tr>
						<th>Email</th>
						<td>${regForm.email}</td>
					</tr>
					<tr>
						<th>Birthday</th>
						<td>${regForm.birthday}</td>
					</tr>
					<tr>
						<th>Tel</th>
						<td>${regForm.tel}</td>
					</tr>
					<tr>
						<th>Link Image</th>
						<td>${regForm.linkImage}</td>
					</tr>
					<tr>
						<th>Name level</th>
						<td>${regForm.nameLevel}</td>
					</tr>
					<tr>
						<th>Total</th>
						<td>${regForm.total}</td>
					</tr>
					<tr>
						<th>Group Name</th>
						<td>${regForm.groupName}</td>
					</tr>
					<tr>
						<th>Start Date</th>
						<td>${regForm.startDate}</td>
					</tr>
					<tr>
						<th>End Date</th>
						<td>${regForm.endDate}</td>
					</tr>
				</tbody>
			</table>
			<div class="wrapper row">
				<div class="col-sm-4 col-sm-offset-2">
					<a href="${pageContext.request.contextPath}/register.jsp">
						<button type="button" class="btn btn-primary btn-block">Back</button>
					</a>
					
				</div>
				<div class="col-sm-4">
					<a href="${pageContext.request.contextPath}/InsertController">
						<button type="button" class="btn btn-primary btn-block">Confirm</button>
					</a>
				</div>



		</div>
	</div>


</body>
</html>