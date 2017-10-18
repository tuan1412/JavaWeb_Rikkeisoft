<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>ListUser</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="css/style.css">

</head>

<body>
	<div class="container">
		<div>
			<img src="images/logo-manager-user.gif" alt="rikkeisoft"> 
			<span>
				<a class="btn-link" href="${pageContext.request.contextPath}/TopController">
					<button type="button" class="btn">Top</button> 
				</a>
				<a class="btn-link" href="${pageContext.request.contextPath}/LogoutController">
					<button type="button" class="btn">Log out</button>
				</a>
			</span>
		</div>

		<form class="form-horizontal col-sm-4" method="post"
			action="SearchController">
			<div class="form-group">
				<label class="label-form col-sm-4" for="fullName">Full Name</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="fullName"
						value="${fullName}" name="fullName">
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
							${groupName == 'Trung tâm phát triển chiến lược' ? 'selected' : ''}>Trung tâm phát triển chiến lược</option>
						<option value="Trung tâm phát triển TMDT"
							${groupName == 'Trung tâm phát triển TMDT' ? 'selected' : ''}>Trung tâm phát triển TMDT</option>
						<option value="Trung tâm phát triển hê thống"
							${groupName == 'Trung tâm phát triển hê thống' ? 'selected' : ''}>Trung tâm phát triển hê thống</option>
						<option value="Trung tâm phát triển mobile"
							${groupName == 'Trung tâm phát triển mobile' ? 'selected' : ''}>Trung tâm phát triển mobile	</option>
						<option value="Trung tâm phát triển Game"
							${groupName == 'Trung tâm phát triển Game' ? 'selected' : ''}>Trung tâm phát triển Game</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4">
					<button type="submit" class="btn">Search</button>
				<a class="btn-link" href="${pageContext.request.contextPath}/register.jsp">
						<button type="button" class="btn">Add</button>
				</a>	
					
				</div>
			</div>

		</form>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>user_id</th>
						<th>
						full_name							
						<a href="ListUserController?page=${currentPage}&sortType=full_name&direction=ASC" >
          					<span class="glyphicon glyphicon-arrow-up" style="float:right"></span>
          				</a>						 	
						<a href="ListUserController?page=${currentPage}&sortType=full_name&direction=DESC">
       					 	  <span class="glyphicon glyphicon-arrow-down" style="float:right"></span>
       					</a>    					 	
      				    </th>
						
						<th>full_name_kana</th>
						<th>gender</th>
						<th>email</th>
						<th>tel</th>
						<th>birthday</th>
						<th>link_image</th>
						<th>group_name</th>
						<th>name_level
						<a href="ListUserController?page=${currentPage}&sortType=name_level&direction=ASC" >
          					<span class="glyphicon glyphicon-arrow-up" style="float:right"></span>
          				</a>						 	
						<a href="ListUserController?page=${currentPage}&sortType=name_level&direction=DESC">
       					 	  <span class="glyphicon glyphicon-arrow-down" style="float:right"></span>
       					</a></th>
						<th>end_date
						<a href="ListUserController?page=${currentPage}&sortType=end_date&direction=ASC" >
          					<span class="glyphicon glyphicon-arrow-up" style="float:right"></span>
          				</a>						 	
						<a href="ListUserController?page=${currentPage}&sortType=end_date&direction=DESC">
       					 	  <span class="glyphicon glyphicon-arrow-down" style="float:right"></span>
       					</a></th>
						<th>total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.userId}</td>
							<td>${user.fullName}</td>
							<td>${user.fullNameKana}</td>
							<td>${user.gender}</td>
							<td>${user.email}</td>
							<td>${user.tel}</td>
							<td>${user.birthday}</td>
							<td>${user.linkImage}</td>
							<td>${user.groupName}</td>
							<td>${user.nameLevel}</td>
							<td>${user.endDate}</td>
							<td>${user.total}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		
		<ul>
			<c:if test="${currentSection != 1}">
        		<li><a href="ListUserController?page=${(currentSection-2)*sectionSize+1}&sortType=${sortType}&direction=${direction}"><<</a></li>
    		</c:if>
    		 <c:forEach begin="${startPage}" end="${endPage}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li>${i}</li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="ListUserController?page=${i}&sortType=${sortType}&direction=${direction}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
    		<c:if test="${currentSection < noOfSection}">
        		<li><a href="ListUserController?page=${currentSection*sectionSize+1}&sortType=${sortType}&direction=${direction}">>></a></li>
    		</c:if>
			
		</ul>
	</div>
</body>
</html>