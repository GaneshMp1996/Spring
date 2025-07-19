<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Newspaper Details</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #1e3c72, #2a5298);
            color: #fff;
            padding: 40px;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.6);
            padding: 30px;
            border-radius: 15px;
            max-width: 600px;
            margin: auto;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.7);
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #ffeb3b;
        }

        .detail-box {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.1);
        }

        .detail {
            font-size: 1.2em;
            margin: 10px 0;
        }

        .label {
            font-weight: bold;
            color: #80d8ff;
        }

        .error {
            text-align: center;
            color: #ff7777;
            font-weight: bold;
            margin-top: 20px;
        }

        footer {
            text-align: center;
            color: #ccc;
            margin-top: 30px;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>The Required Newspaper Details</h1>

        <!-- If newspapers are found -->
        <c:forEach var="newspaper" items="${ListOfNewspaper}">
            <div class="detail-box">
                <div class="detail"><span class="label">Name:</span> ${newspaper.newsPaperName}</div>
                <div class="detail"><span class="label">Price:</span> ${newspaper.price}</div>
                <div class="detail"><span class="label">Language:</span> ${newspaper.language}</div>
                <div class="detail"><span class="label">No of Pages:</span> ${newspaper.noOfPages}</div>
            </div>
        </c:forEach>

        <!-- If not found -->
        <c:if test="${not empty NotFound}">
            <div class="error">${NotFound}</div>
        </c:if>

        <footer>
            Developer - <strong>Ganesh MP</strong> | Designation - <strong>Java Full Stack Developer</strong>
        </footer>
    </div>
</body>
</html>
