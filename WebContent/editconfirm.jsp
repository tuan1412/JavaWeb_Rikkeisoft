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
<link rel="stylesheet" href="css/confirmstyle.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">User info</h3>
					</div>
					<div class="panel-body">
						<div class="col-sm-3">
							<img src="${user.linkImage}" alt="${user.userId}" width="100px"
								height="100px">
						</div>
						<div class="col-sm-9">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>User Id</td>
										<td>${user.userId}</td>
									</tr>
									<tr>
										<td>Full Name</td>
										<td>${user.fullName}</td>
									</tr>
									<tr>
										<td>Name Kana</td>
										<td>${user.fullNameKana}</td>
									</tr>
									<tr>
										<td>Gender</td>
										<td>${user.gender}</td>
									</tr>
									<tr>
										<td>Email</td>
										<td>${user.email}</td>
									</tr>
									<tr>
										<td>Tel</td>
										<td>${user.tel}</td>
									</tr>
									<tr>
										<td>Birthday</td>
										<td>${user.birthday}</td>
									</tr>
									<tr>
										<td>Group</td>
										<td>${user.groupName}</td>
									</tr>
									<tr>
										<td>Level</td>
										<td>${user.nameLevel}</td>
									</tr>
									<tr>
										<td>End date</td>
										<td>${user.endDate}</td>
									</tr>
									<tr>
										<td>Total</td>
										<td>${user.total}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="panel-footer">
						
						<a href="${pageContext.request.contextPath}/edit.jsp"
							data-original-title="Back" data-hover="tooltip"
							class="btn  btn-primary"> <i
							class="glyphicon glyphicon-arrow-left"></i>
						</a> <span class="pull-right"> <a
							href="${pageContext.request.contextPath}/SubmitEditController"
							data-original-title="confirm" data-hover="tooltip"
							class="btn btn-warning"> <i class="glyphicon glyphicon-edit"></i>
						</a>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
		<script>
			$(document).ready(function() {
				$('[data-hover="tooltip"]').tooltip();
			});
		</script>
</body>
</html>