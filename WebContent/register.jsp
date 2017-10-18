<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>Register</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/regformstyle.css">
</head>
<body>
	<div class="container">
		<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate var="currentDay" value="${now}" pattern="yyyy-MM-dd" />
		<form action="AddNewController" method = "post" class="form-horizontal" role="form">
			<h2>Registration Form</h2>
			 <c:forEach items="${errors}" var="item">
    				  <h4 style = "color: red"><c:out value="${item}" /></h4>
 			</c:forEach>
			<!-- Full Name -->
			<div class="form-group">
				<label for="fullName" class="col-sm-3 control-label">Full
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="firstName" placeholder="Full Name"
						class="form-control" name="fullName" value="${regForm.fullName}"autofocus>
				</div>
			</div>
			
			<!-- Full Name Kana -->
			<div class="form-group">
				<label for="fullNameKana" class="col-sm-3 control-label">Full
					Name Kana</label>
				<div class="col-sm-9">
					<input type="text" id="fullNameKana" placeholder="Full Name Kana"
						class="form-control" name="fullNameKana" value="${regForm.fullNameKana}">
				</div>
			</div>
			
			<!-- Gender -->
			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="femaleRadio" value="Nữ" name="gender" ${regForm.gender == 'Nữ' ||  empty regForm.gender ? 'checked' : ''}>Female
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="maleRadio" value="Nam" name="gender" ${regForm.gender == 'Nam' ? 'checked' : ''}>Male
							</label>
						</div>
					</div>
				</div>
			</div>
			
			<!-- Email -->
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="text" id="email" placeholder="Email"
						class="form-control" name="email" value="${regForm.email}">
				</div>
			</div>
			
			<!-- Login Name -->
			<div class="form-group">
				<label for="loginName" class="col-sm-3 control-label">Login
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="loginName" placeholder="Login Name"
						class="form-control" name="loginName" value="${regForm.loginName}">
				</div>
			</div>
			<!-- Password -->
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<input type="password" id="password" placeholder="Password" name="password"
						class="form-control">
				</div>
			</div>
			
			<!-- Confirm Password -->
			<div class="form-group">
				<label for="confirmPassword" class="col-sm-3 control-label">Confirm
					Password</label>
				<div class="col-sm-9">
					<input type="password" id="confirmPassword"
						placeholder="Confirm Password" class="form-control"
						name="confirmPassword">
				</div>
			</div>
			
			<!-- Birth Day -->
			<div class="form-group">
				<label for="startDate" class="col-sm-3 control-label">Birthday
					</label>
				<div class="col-sm-9">
					<input type="date" id="datePicker" class="form-control"
						name="birthday" value="${not empty regForm.birthday ? regForm.birthday : currentDay}">
				</div>
			</div>
			
			<!-- Tel -->
			<div class="form-group">
				<label for="tel" class="col-sm-3 control-label">Tel</label>
				<div class="col-sm-9">
					<input type="text" id="tel" class="form-control" placeholder="Tel"
						name="tel" value="${regForm.tel}">
				</div>
			</div>
			
			<!-- Link Image -->
			<div class="form-group">
				<label for="linkImage" class="col-sm-3 control-label">Image</label>
				<div class="col-sm-9">
					<input type="file" id="linkImage" class="form-control"
						name="linkImage" value="${regForm.linkImage}">
				</div>
			</div>
			
			<!-- Name level -->
			<div class="form-group">
				<label for="nameLevel" class="col-sm-3 control-label">Name
					Level</label>
				<div class="col-sm-9">
					<select id="nameLevel" class="form-control" name="nameLevel">
						<option></option>
						<option ${regForm.nameLevel == 'Trình độ tiếng nhật N1' ? 'selected' : ''}>Trình độ tiếng nhật N1</option>
						<option ${regForm.nameLevel == 'Trình độ tiếng nhật N2' ? 'selected' : ''}>Trình độ tiếng nhật N2</option>
						<option ${regForm.nameLevel == 'Trình độ tiếng nhật N3' ? 'selected' : ''}>Trình độ tiếng nhật N3</option>
						<option ${regForm.nameLevel == 'Trình độ tiếng nhật N4' ? 'selected' : ''}>Trình độ tiếng nhật N4</option>
						<option ${regForm.nameLevel == 'Trình độ tiếng nhật N5' ? 'selected' : ''}>Trình độ tiếng nhật N5</option>
					</select>
				</div>
			</div>
			
			<!-- Total-->
			<div class="form-group">
				<label for="total" class="col-sm-3 control-label">Total</label>
				<div class="col-sm-9">
					<input type="number" id="total" name="total" min="0" max="1000" value="${regForm.total }">
				</div>
			</div>
			
			<!-- Group Name -->
			<div class="form-group">
				<label for="groupName" class="col-sm-3 control-label">Group
					Name</label>
				<div class="col-sm-9">
					<select id="groupName" class="form-control" name="groupName">
						<option></option>
						<option ${regForm.groupName == 'Trung tâm phát triển chiến lược' ? 'selected' : ''}>Trung tâm phát triển chiến lược</option>
						<option ${regForm.groupName == 'Trung tâm phát TMDT' ? 'selected' : ''}>Trung tâm phát triển TMDT</option>
						<option ${regForm.groupName == 'Trung tâm phát triển hệ thống' ? 'selected' : ''}>Trung tâm phát triển hê thống</option>
						<option ${regForm.groupName == 'Trung tâm phát triển mobie' ? 'selected' : ''}>Trung tâm phát triển mobile</option>
						<option ${regForm.groupName == 'Trung tâm phát triển Game' ? 'selected' : ''}>Trung tâm phát triển Game</option>
					</select>
				</div>
			</div>
			
			<!-- Start date -->
			<div class="form-group">
				<label for="startDate" class="col-sm-3 control-label">Start
					Date</label>
				<div class="col-sm-9">
					<input type="date" id="datePicker" class="form-control"
						name="startDate" value="${not empty regForm.startDate ? regForm.startDate : currentDay}">
				</div>
			</div>
			
			<!-- End date -->
			<div class="form-group">
				<label for="endDate" class="col-sm-3 control-label">End Date</label>
				<div class="col-sm-9">
					<input type="date" id="datePicker" class="form-control"
						name="endDate"value="${not empty regForm.endDate ? regForm.endDate : currentDay}">
				</div>
			</div>
			
			<!-- Button -->
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3">
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