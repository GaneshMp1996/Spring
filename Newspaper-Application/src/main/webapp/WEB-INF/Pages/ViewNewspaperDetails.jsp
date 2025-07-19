<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper Details</title>
</head>
<body>
<h1>${NotFound }</h1>
<h1>${searchValidationMessage}</h1>
<header style="color: navy;margin: 0%;text-align: center;">
<h1> the required Newspaper Details as followed Below.....</h1>
<hr>
</header>
<div>

<c:forEach items="${ListOfNewspaper}" var="newspaperobj">
<tr>
             <td>${newspaperobj.newsPaperName}</td> <br>
                   
					<td>${newspaperobj.price}</td><br>
					
					<td>${newspaperobj.language}</td><br>
					
					<td>${newspaperobj.noOfPages}</td><br>
					<hr>
					</tr>
			</c:forEach>
			</div>

</html>