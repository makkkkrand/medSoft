<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- <html xmlns:th="http://www.thymeleaf.org">  -->
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="css/styles.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<meta charset="UTF-8">
<title>Welcome Page</title>
<script type="text/javascript"
	src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div><%@include file="base.jsp"%></div>
	<div class="container"></div>

	<div><%@include file="footer.jsp"%></div>
</body>
</html>