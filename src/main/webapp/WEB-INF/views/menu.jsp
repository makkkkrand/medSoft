<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="css/styles.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">MedSoft Technologies</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="#">Common</a></li>
				<li><a href="#">Task</a></li>
				<li><a href="#">Report</a></li>
				<li><a href="#">Setting</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" >
				<li><a href="#">About</a></li>
				<li><a href="#">Logout</a></li>
			</ul>
		</div>
	</nav>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>