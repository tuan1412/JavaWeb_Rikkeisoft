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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<h2>User Info</h2>
			<table>
				<tbody>
					<tr>
						<th>UserId</th>
						<td>${user.userId}</td>
					</tr>
					<tr>
						<th>Full name</th>
						<td>${user.fullName}</td>
					</tr>
					<tr>
						<th>Full name kana</th>
						<td>${user.fullNameKana}
					</tr>
					<tr>
						<th>Gender</th>
						<td>${user.gender}</td>
					</tr>
					<tr>
						<th>Email</th>
						<td>${user.email}</td>
					</tr>
					<tr>
						<th>Tel</th>
						<td>${user.tel}</td>
					</tr>
					<tr>
						<th>Birthday</th>
						<td>${user.birthday}</td>
					</tr>

					<tr>
						<th>Link Image</th>
						<td>${user.linkImage}</td>
					</tr>
					<tr>
						<th>Group Name</th>
						<td>${user.groupName}</td>
					</tr>
					<tr>
						<th>Name level</th>
						<td>${user.nameLevel}</td>
					</tr>
					<tr>
						<th>End Date</th>
						<td>${user.endDate}</td>
					</tr>
					<tr>
						<th>Total</th>
						<td>${user.total}</td>
					</tr>
				</tbody>
			</table>
			<div class="wrapper row">
				<div class="modal fade" id="confirm-delete" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
							</div>

							<div class="modal-body">
								<p>Do u want to delete this user</p>
								<p class="debug-url"></p>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
								<a class="btn btn-danger btn-ok">Delete</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<a href="${pageContext.request.contextPath}/TopController">
						<button type="button" class="btn btn-primary btn-block">Back</button>
					</a>
				</div>
				<div class="col-sm-4">
					<a href="#"
						data-href="${pageContext.request.contextPath}/DeleteController"
						data-toggle="modal" data-target="#confirm-delete">
						<button type="button" class="btn btn-primary btn-block">Del</button>
					</a>
				</div>
				<div class="col-sm-4">
					<a href="${pageContext.request.contextPath}/edit.jsp">
						<button type="button" class="btn btn-primary btn-block">Edit</button>
					</a>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
	</script>
</body>
</html>