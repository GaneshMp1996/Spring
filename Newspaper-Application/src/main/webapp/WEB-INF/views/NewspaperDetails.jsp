<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Newspaper Details</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
<style>
    body {
        font-family: 'Poppins', sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(rgba(0, 0, 50, 0.85), rgba(0, 0, 0, 0.9)), url('newsbg.jpg') no-repeat center center fixed;
        background-size: cover;
        color: #f5f5f5;
    }

    header {
        background-color: rgba(0, 0, 100, 0.8);
        padding: 20px;
        text-align: center;
        color: #ffeb3b;
    }

    main {
        max-width: 700px;
        margin: 40px auto;
        background-color: rgba(255, 255, 255, 0.05);
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.5);
    }

    h1, h2 {
        text-align: center;
        color: #fff176;
    }

    .details {
        font-size: 1.2em;
        line-height: 2;
        margin-top: 20px;
    }

    .label {
        font-weight: bold;
        color: #90caf9;
    }

    footer {
        text-align: center;
        padding: 15px;
        background-color: rgba(0, 0, 50, 0.7);
        color: #ccc;
        font-size: 0.9em;
        position: fixed;
        width: 100%;
        bottom: 0;
    }
</style>
</head>
<body>

<header>
    <h1>📰 Newspaper Information Portal</h1>
    <p>Developer - Ganesh MP | Java Full Stack Developer</p>
</header>

<main>
    <h2>${ValidateMessage}</h2>
    <h2>The Newspaper Details Are Given Below</h2>
    <hr>
    <div class="details">
        <div><span class="label">Name:</span> ${Name}</div>
        <div><span class="label">Price:</span> ${Price}</div>
        <div><span class="label">Language:</span> ${Language}</div>
        <div><span class="label">No. of Pages:</span> ${NoOfPages}</div>
    </div>
</main>

<footer>
    <p>© 2025 Newspaper Portal | Developed by Ganesh MP - Java Full Stack Developer</p>
</footer>

</body>
</html>
