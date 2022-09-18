<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get-All-NewsPaper</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0">
		<%@include file="navbar.jsp"%>
		<br>
		<div class="card shadow bg-white p-0">
			<img alt="" class="img-fluid  p-0 m-0" style="max-width: 300px"
				src="image/news.png">
		

		<div>
			<a href="getAllNewsPaper.do">View List Of Newspaper</a>
			<c:forEach items="${ListOfNewsPaper}" var="newspaperObject">
				<table class="table table-light">
					<thead>
						<tr>
							<th scope="col">NewsPaperName</th>
							<th scope="col">Price</th>
							<th scope="col">Language</th>
							<th scope="col">NoOfPages</th>
							<th scope="col">Edit</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">${newspaperObject.newsPaperName }</th>
							<td>${newspaperObject.price }</td>
							<td>${newspaperObject.language }</td>
							<td>${newspaperObject.noOfPages }</td>
							<td><a class="btn btn-info" href="updateNewsPaper.do?newsPaperName=${newspaperObject.newsPaperName }">Edit</a></td>
						</tr>
					</tbody>
				</table>
			</c:forEach>
		</div>
</body>
</html>