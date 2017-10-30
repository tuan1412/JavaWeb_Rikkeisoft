<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>Success</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="refresh"
	content="3; url=${pageContext.request.contextPath}/${des}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<br>
	<br>
	<div class="jumbotron text-center">
		<p>${type} thành công</p>
		<p id="demo">3 s để về trang ${des}</p>
	</div>
	<script>
		var countDownDate = 3;
		var x = setInterval(function() {
			countDownDate--;
			document.getElementById("demo").innerHTML = countDownDate
					+ 's để về trang ${des}';
			if (countDownDate <= 1) {
				clearInterval(x);
			}
		}, 1000);
	</script>
</body>
</html>