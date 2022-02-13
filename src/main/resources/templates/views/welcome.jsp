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
<title>Welcome Page</title>
<!-- <meta charset="UTF-8">
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="icon" type="image/x-icon" href="images/favicon.ico">
<!-- <META http-equiv="refresh" content="4;/home"> -->
<link rel="icon" type="image/x-icon" href="images/favicon.ico">
<!-- <META http-equiv="refresh" content="4;/home"> -->
</head>
<body>
	<div class="center">
		<h1>
			<span> <label>Welcome to MedSoft Technologies</label>
			</span>
		</h1>
	</div>
	<div><%@include file="footer.jsp"%></div>
</body>
</html>