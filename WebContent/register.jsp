<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Register</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/regformstyle.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate var="currentDay" value="${now}" pattern="yyyy-MM-dd" />
		<form action="ValidateRegController" method="post"
			class="form-horizontal" role="form" enctype="multipart/form-data">
			<h2>Registration Form</h2>

			<!-- Full Name -->
			<c:if test="${not empty errors.fullName}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<p>${errors.fullName}</p>
				</div>
			</c:if>
			<div class="form-group">

				<label for="fullName" class="col-sm-4 control-label">Full
					Name</label>
				<div class="col-sm-8">
					<input type="text" id="firstName" placeholder="Full Name"
						class="form-control" name="fullName" value="${regForm.fullName}"
						autofocus>
				</div>
			</div>

			<!--         Full Name Kana -->
			<c:if test="${not empty errors.kana}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<p>${errors.kana}</p>
				</div>
			</c:if>
			<div class="form-group">

				<label for="fullNameKana" class="col-sm-4 control-label">Full
					Name Kana</label>
				<div class="col-sm-8">
					<input type="text" id="fullNameKana" placeholder="Full Name Kana"
						class="form-control" name="fullNameKana"
						value="${regForm.fullNameKana}">
				</div>
			</div>

			<!--         Gender -->
			<div class="form-group">
				<label class="control-label col-sm-4">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="femaleRadio" value="Nữ" name="gender"
								${regForm.gender == 'Nữ' ||  empty regForm.gender ? 'checked' : ''}>Female
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="maleRadio" value="Nam" name="gender"
								${regForm.gender == 'Nam' ? 'checked' : ''}>Male
							</label>
						</div>
					</div>
				</div>
			</div>

			<!--         Email -->
			<c:if test="${not empty errors.email}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errors.email}

				</div>
			</c:if>
			<div class="form-group">

				<label for="email" class="col-sm-4 control-label">Email</label>
				<div class="col-sm-8">
					<input type="text" id="email" placeholder="Email"
						class="form-control" name="email" value="${regForm.email}">
				</div>
			</div>

			<!--         Login Name -->
			<c:if test="${not empty errors.loginName}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<p>${errors.loginName}</p>
				</div>
			</c:if>
			<div class="form-group">
				<label for="loginName" class="col-sm-4 control-label">Login
					Name</label>
				<div class="col-sm-8">
					<input type="text" id="loginName" placeholder="Login Name"
						class="form-control" name="loginName" value="${regForm.loginName}">
				</div>
			</div>
			<!--         Password -->
			<c:if test="${not empty errors.password}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errors.password}

				</div>
			</c:if>
			<div class="form-group">

				<label for="password" class="col-sm-4 control-label">Password</label>
				<div class="col-sm-8">
					<input type="password" id="password" placeholder="Password"
						name="password" class="form-control">
				</div>
			</div>

			<!--         Confirm Password -->
			<c:if test="${not empty errors.repassword}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errors.repassword}

				</div>
			</c:if>
			<div class="form-group">

				<label for="confirmPassword" class="col-sm-4 control-label">Confirm
					Password</label>
				<div class="col-sm-8">
					<input type="password" id="confirmPassword"
						placeholder="Confirm Password" class="form-control"
						name="confirmPassword">
				</div>
			</div>

			<!--         Birth Day -->
			<div class="form-group">
				<label for="startDate" class="col-sm-4 control-label">Birthday
				</label>
				<div class="col-sm-8">
					<input type="date" id="datePicker" class="form-control"
						name="birthday"
						value="${not empty regForm.birthday ? regForm.birthday : currentDay}">
				</div>
			</div>

			<!--         Tel -->
			<c:if test="${not empty errors.tel}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errors.tel }
				</div>
			</c:if>
			<div class="form-group">

				<label for="tel" class="col-sm-4 control-label">Tel</label>
				<div class="col-sm-8">
					<input type="text" id="tel" class="form-control" placeholder="Tel"
						name="tel" value="${regForm.tel}">
				</div>
			</div>

			<!--         Link Image -->
			<c:if test="${not empty errors.linkImage}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errors.linkImage}

				</div>
			</c:if>
			<div class="form-group">

				<label for="linkImage" class="col-sm-4 control-label">Image</label>
				<div class="col-sm-8">
					<input type="file" id="linkImage" class="form-control"
						name="linkImage" value="${regForm.linkImage}">
				</div>
			</div>

			<!--         Name level -->
			<c:if test="${not empty errors.nameLevel}">
				<div
					class="alert alert-danger alert-dismissable col-sm-8 col-sm-offset-4">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errors.nameLevel}
				</div>
			</c:if>
			<div class="form-group">
				<label for="nameLevel" class="col-sm-4 control-label">Name
					Level</label>
				<div class="col-sm-8">
					<select id="nameLevel" class="form-control" name="nameLevel">
						<option></option>
						<option
							${regForm.nameLevel == 'Trình độ tiếng Nhật cấp 1' ? 'selected' : ''}>Trình độ tiếng Nhật cấp 1</option>
						<option
							${regForm.nameLevel == 'Trình độ tiếng Nhật cấp 2' ? 'selected' : ''}>Trình độ tiếng Nhật cấp 2</option>
						<option
							${regForm.nameLevel == 'Trình độ tiếng Nhật cấp 4' ? 'selected' : ''}>Trình độ tiếng Nhật cấp 4</option>
						<option
							${regForm.nameLevel == 'Trình độ tiếng Nhật cấp 4' ? 'selected' : ''}>Trình độ tiếng Nhật cấp 4</option>
						<option
							${regForm.nameLevel == 'Trình độ tiếng Nhật cấp 5' ? 'selected' : ''}>Trình độ tiếng Nhật cấp 5</option>
					</select>
				</div>
			</div>

			<!--         Total -->
			<div class="form-group">
				<label for="total" class="col-sm-4 control-label">Total</label>
				<div class="col-sm-8">
					<input class="form-control" type="number" id="total" name="total"
						min="0" max="1000" value="${regForm.total }">
				</div>
			</div>

			<!--         Group Name -->
			<div class="form-group">
				<label for="groupName" class="col-sm-4 control-label">Group
					Name</label>
				<div class="col-sm-8">
					<select id="groupName" class="form-control" name="groupName">
						<option></option>
						<option
							${regForm.groupName == 'Trung tâm phát triển chiến lược' ? 'selected' : ''}>Trung tâm phát triển chiến lược</option>
						<option
							${regForm.groupName == 'Trung tâm phát triển TMDT' ? 'selected' : ''}>Trung tâm phát triển TMDT</option>
						<option
							${regForm.groupName == 'Trung tâm phát triển hê thống' ? 'selected' : ''}>Trung tâm phát triển hê thống</option>
						<option
							${regForm.groupName == 'Trung tâm phát triển mobie' ? 'selected' : ''}>Trung tâm phát triển mobile</option>
						<option
							${regForm.groupName == 'Trung tâm phát triển Game' ? 'selected' : ''}>Trung tâm phát triển Game</option>
					</select>
				</div>
			</div>

			<!-- 			Start date -->
			<div class="form-group">
				<label for="startDate" class="col-sm-4 control-label">Start
					Date</label>
				<div class="col-sm-8">
					<input type="date" id="datePicker" class="form-control"
						name="startDate"
						value="${not empty regForm.startDate ? regForm.startDate : currentDay}">
				</div>
			</div>

			<!-- 			End date -->
			<div class="form-group">
				<label for="endDate" class="col-sm-4 control-label">End Date</label>
				<div class="col-sm-8">
					<input type="date" id="datePicker" class="form-control"
						name="endDate"
						value="${not empty regForm.endDate ? regForm.endDate : currentDay}">
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<a href="${pageContext.request.contextPath}/TopController">
						<button type="button" class="btn btn-primary btn-block">Back</button>
					</a>
				</div>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary btn-block">Register</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>