<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete-NewsPaper</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0">
		<%@include file="navbar.jsp"%>
		<br>
		<div class="card shadow bg-white p-0">
			<img alt="" class="img-fluid  p-0 m-0" style="max-width: 300px"
				src="image/news.png">

			<h1>${validateDeleteMessage}</h1>
			<form class="form-inline" action="deleteNewsPaper.do" method="post">
				<input class="form-control mr-sm-2" type="text"
					name="newsPaperName" placeholder="NewsPaperName">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
					value="DeleteNewsPaper">Delete</button>
			</form>
			<br> <br>

			<h2>${validateNewsPaperName }</h2>
</body>
</html>