<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
</head>
<body
	style="background-image: url(D:\PostGazettenewspaper3-1585327715.jpg); background-repeat: no-repeat; background-size: 100%;">


	<header style="color: navy; margin: 0%; text-align: center;">
		<h1>Welcome to Newspaper Application</h1>
		<hr>
	</header>
	<pre>
<form action="news.abc">
Name:<input type="text" name="newsPaperName"
				placeholder="Enter NewspaperName" required="Name is manditary">${validateName}<br>
Price:<input type="text" name="Price" placeholder="Enter Price">${validatePrice}<br>
Language:<input type="text" name="Language" placeholder="Enter Language"
				required="Enter Language">${validateLanguage }<br>
No_Of_Pages:<input type="text" name="NoOfPages"
				placeholder="Enter NoOfPages" required="Enter NoOfPages">${validatePages }<br>

<input type="submit" value="save" onclick="validate()"
				style="color: red; background-color: yellow">
</form>
<form action="searchNewsPaper.abc">
<h1>
				<h1>${NotFound }</h1>
			</h1>
<label>Search News Paper:</label><input type="text"
				name="searchNewsPaper" placeholder="Enter NewspaperName"> <input
				type="submit" value="searchNewsPaper" style="color: red;">
</form>
<h1>${SearchValidation}</h1>
<form action="searchLanguage.abc">
<label>Search Language:</label><input type="text" name="searchLanguage"
				placeholder="Enter Language"> <input type="submit"
				value="searchLanguage" style="color: red;">

	</form>
	<a href="getAllNewsPaper.abc">ViewAllNewsPaper</a> <br>
	
	<h1>${validataionMessage}</h1>
	<form action="deleteNewspaper.abc">
		<label>Delete News Paper:</label><input type="text"
				name="newsPaperName" placeholder="Enter News Paper"> <input
				type="submit" value="deleteNewsPaper" style="color: red;">	
			
	</form>
	

<form action="updateNewspaper.abc">
Name:<input type="text" name="newsPaperName"><br>
Price:<input type="text" name="price"><br>
Language:<input type="text" name="language"><br>
No_Of_Pages:<input type="text" name="noOfPages"><br>

<input type="submit" value="update"
				style="color: red; background-color: block">
				<h1>${errorMessage}</h1>




</form>
</pre>
	<footer
		style="color: gray; margin-top: 5%; text-align: center; font-style: oblique; border-style: groove; border-color: teal; background-color: maroon;">

		<h3>@Copy Right</h3>
	</footer>
</body>
</html>