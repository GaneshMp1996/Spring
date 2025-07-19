<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper Details</title>
</head>
<body>
<h1>Newspaper details read successfully</h1>
<hr>
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
</body>
</html>