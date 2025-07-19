<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete Newspaper</title>
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
            text-align: center;
        }

        h1 {
            color: #ffeb3b;
            margin-bottom: 25px;
        }

        .message {
            font-size: 1.2em;
            margin-top: 20px;
            padding: 15px;
            border-radius: 8px;
        }

        .success {
            background-color: rgba(76, 175, 80, 0.2);
            color: #c8e6c9;
            border: 1px solid #4caf50;
        }

        .error {
            background-color: rgba(244, 67, 54, 0.2);
            color: #ffcdd2;
            border: 1px solid #f44336;
        }

        footer {
            margin-top: 30px;
            font-size: 0.9em;
            color: #ccc;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Delete Newspaper Result</h1>

        <c:if test="${not empty validateDeleteMessage}">
            <div class="message success">${validateDeleteMessage}</div>
        </c:if>

        <c:if test="${not empty validationMessage}">
            <div class="message error">${validationMessage}</div>
        </c:if>

        <footer>
            Developer - <strong>Ganesh MP</strong> | Designation - <strong>Java Full Stack Developer</strong>
        </footer>
    </div>
</body>
</html>
