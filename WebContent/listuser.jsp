<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>ListUser</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>
	<div class="container-fluid">
		 <header class="clearfix">
            <img src="${pageContext.request.contextPath}/images/logo.gif" alt="rikkeisoft">
            <ul class="nav">
                <li>
                    <a href="${pageContext.request.contextPath}/LogoutController" class="btn btn-default btn-block">Logout</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/TopController" class="btn btn-default btn-block">Top</a>
                </li>
            </ul>
        </header>

		<div class="col-sm-4">
			<form class="form-horizontal" method="post" action="SearchController">
				<h3>Search User</h3>
				<hr>
				<div class="form-group">
					<label class="label-form col-sm-4" for="fullName">Full Name</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="fullName"
							name="fullName" value="${fullName}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4" for="email">Email address</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="email" name="email"
							value="${email}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4" for="sel1">Group Name</label>
					<div class="col-sm-8">
						<select class="form-control" id="sel1" style="display: inline"
							name="groupName">
							<option value=""></option>
							<option value="Trung tâm phát triển chiến lược"
								${groupName=='Trung tâm phát triển chiến lược' ? 'selected' : ''}>Trung tâm phát triển chiến lược</option>
							<option value="Trung tâm phát triển TMDT"
								${groupName=='Trung tâm phát triển TMDT' ? 'selected' : ''}>Trung tâm phát triển TMDT</option>
							<option value="Trung tâm phát triển hê thống"
								${groupName=='Trung tâm phát triển hê thống' ? 'selected' : ''}>Trung tâm phát triển hê thống</option>
							<option value="Trung tâm phát triển mobile"
								${groupName=='Trung tâm phát triển mobile' ? 'selected' : ''}>Trung tâm phát triển mobile </option>
							<option value="Trung tâm phát triển Game"
								${groupName=='Trung tâm phát triển Game' ? 'selected' : ''}>Trung tâm phát triển Game</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<div class="row">
							<div class="col-sm-6">
								<button type="submit" class="btn btn-default btn-block">
									<span class="glyphicon glyphicon-search"></span> Search
								</button>
							</div>
							<div class="col-sm-6">
								<a class="btn btn-default btn-block"
									href="${pageContext.request.contextPath}/register.jsp"> <span
									class="glyphicon glyphicon-edit"></span> Add
								</a>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>


		<table class="col-sm-12">
			<thead>
				<tr>
					<th>Id</th>
					<th>Image</th>
					<th>Name
						<div style="float: right">
							<a
								href="ListUserController?page=${currentPage}&sortType=full_name&direction=ASC">
								<span class="glyphicon glyphicon-chevron-up"></span>
							</a> <a
								href="ListUserController?page=${currentPage}&sortType=full_name&direction=DESC">
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
					</th>

					<th>Kana</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Tel</th>
					<th>Birthday</th>
					<th>Group</th>
					<th>Level
						<div style="float: right">
							<a
								href="ListUserController?page=${currentPage}&sortType=name_level&direction=ASC">
								<span class="glyphicon glyphicon-chevron-up"></span>
							</a> <a
								href="ListUserController?page=${currentPage}&sortType=name_level&direction=DESC">
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
					</th>
					<th>End date
						<div style="float: right">
							<a
								href="ListUserController?page=${currentPage}&sortType=end_date&direction=ASC">
								<span class="glyphicon glyphicon-chevron-up"></span>
							</a> <a
								href="ListUserController?page=${currentPage}&sortType=end_date&direction=DESC">
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>

					</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/DetailController?userId=${user.userId}">${user.userId}</a></td>
						<td><img
							src="${user.linkImage}"
							alt="${user.userId}" width="50px" height="50px"></td>
						<td>${user.fullName}</td>
						<td>${user.fullNameKana}</td>
						<td>${user.gender}</td>
						<td>${user.email}</td>
						<td>${user.tel}</td>
						<td>${user.birthday}</td>
						<td>${user.groupName}</td>
						<td>${user.nameLevel}</td>
						<td>${user.endDate}</td>
						<td>${user.total}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<footer class="col-sm-12" style="padding-left: 0px">
		<ul class="pagination">
			<c:if test="${currentSection != 1}">
				<li><a
					href="ListUserController?page=${(currentSection-2)*sectionSize+1}&sortType=${sortType}&direction=${direction}">&lt;&lt;</a></li>
			</c:if>
			<c:forEach begin="${startPage}" end="${endPage}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<li><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="ListUserController?page=${i}&sortType=${sortType}&direction=${direction}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${currentSection < noOfSection}">
				<li><a
					href="ListUserController?page=${currentSection*sectionSize+1}&sortType=${sortType}&direction=${direction}">>></a></li>
			</c:if>

		</ul>
		</footer>
	</div>
</body>
</html>