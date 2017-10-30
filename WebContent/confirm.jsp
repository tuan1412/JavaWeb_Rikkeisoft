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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/confirmstyle.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 toppad">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Confirm Info</h3>
					</div>
					<div class="panel-body">
						<div class="col-sm-3">
							<img src="${regForm.linkImage}" alt="${regForm.fullName}"
								width="100px" height="100px">
						</div>
						<div class="col-sm-9">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>Login Name</td>
										<td>${regForm.loginName}</td>
									</tr>
									<tr>
										<td>Full Name</td>
										<td>${regForm.fullName}</td>
									</tr>
									<tr>
										<td>Name Kana</td>
										<td>${regForm.fullNameKana}</td>
									</tr>
									<tr>
										<td>Gender</td>
										<td>${regForm.gender}</td>
									</tr>
									<tr>
										<td>Email</td>
										<td>${regForm.email}</td>
									</tr>
									<tr>
										<td>Tel</td>
										<td>${regForm.tel}</td>
									</tr>
									<tr>
										<td>Birthday</td>
										<td>${regForm.birthday}</td>
									</tr>
									<tr>
										<td>Group</td>
										<td>${regForm.groupName}</td>
									</tr>
									<tr>
										<td>Level</td>
										<td>${regForm.nameLevel}</td>
									</tr>
									<tr>
										<td>Total</td>
										<td>${regForm.total}</td>
									</tr>
									<tr>
										<td>Start date</td>
										<td>${regForm.endDate}</td>
									</tr>
									<tr>
										<td>End date</td>
										<td>${regForm.endDate}</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
					<div class="panel-footer">

						<a href="${pageContext.request.contextPath}/register.jsp"
							data-original-title="Back" data-hover="tooltip"
							class="btn  btn-primary"> <i
							class="glyphicon glyphicon-arrow-left"></i>
						</a> <span class="pull-right"> <a
							href="${pageContext.request.contextPath}/InsertController"
							data-original-title="Confirm" data-hover="tooltip"
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