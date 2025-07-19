<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

        .detail {
            font-size: 1.2em;
            margin: 15px 0;
        }

        .label {
            font-weight: bold;
            color: #80d8ff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>The Required Newspaper Details</h1>

        <div class="detail"><span class="label">Name:</span> ${Name}</div>
        <div class="detail"><span class="label">Price:</span> ${Price}</div>
        <div class="detail"><span class="label">Language:</span> ${Language}</div>
        <div class="detail"><span class="label">No of Pages:</span> ${No_Of_Pages}</div>
    </div>
</body>
</html>
