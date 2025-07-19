<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Newspaper Application</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(rgba(0,0,0,0.75), rgba(0,0,0,0.85)), url('PostGazettenewspaper3-1585327715.jpg') no-repeat center center fixed;
            background-size: cover;
            color: #f1f1f1;
        }

        header {
            background-color: rgba(0, 0, 50, 0.8);
            text-align: center;
            padding: 20px 0;
        }

        header h1 {
            margin: 0;
            font-size: 2.4em;
            color: #ffd54f;
        }

        header p {
            margin-top: 8px;
            font-size: 1em;
            color: #ccc;
        }

        .container {
            display: grid;
            grid-template-columns: 220px 1fr;
            height: calc(100vh - 130px);
        }

        .sidebar {
            background-color: rgba(255, 255, 255, 0.1);
            border-right: 1px solid rgba(255, 255, 255, 0.2);
            padding: 20px;
        }

        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }

        .sidebar li {
            margin-bottom: 15px;
            cursor: pointer;
            font-weight: 500;
            padding: 10px;
            border-radius: 6px;
            background-color: rgba(255, 255, 255, 0.05);
            transition: background-color 0.3s;
        }

        .sidebar li:hover {
            background-color: rgba(255, 255, 255, 0.2);
        }

        .content {
            padding: 30px;
        }

        .form-box {
            display: none;
            animation: fadeIn 0.4s ease-in-out;
        }

        .form-box.active {
            display: block;
        }

        form {
            background-color: rgba(255,255,255,0.08);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.4);
        }

        form input[type="text"], form input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 6px;
            border: none;
            font-size: 1em;
        }

        input[type="text"] {
            background-color: #eee;
            color: #333;
        }

        input[type="submit"] {
            background-color: #009688;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #00796b;
        }

        footer {
            text-align: center;
            padding: 15px;
            background-color: rgba(50, 0, 0, 0.8);
            color: #ccc;
            font-size: 0.9em;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<header>
    <h1>📰 Newspaper Management Application</h1>
    <p>Developer - Ganesh MP | Java Full Stack Developer</p>
</header>

<div class="container">
    <div class="sidebar">
        <ul>
            <li onclick="showForm('add')">➕ Add Newspaper</li>
            <li onclick="showForm('searchName')">🔍 Search by Name</li>
            <li onclick="showForm('searchLang')">🗣️ Search by Language</li>
            <li onclick="showForm('viewAll')">📄 View All</li>
            <li onclick="showForm('delete')">🗑️ Delete Newspaper</li>
            <li onclick="showForm('update')">✏️ Update Newspaper</li>
        </ul>
    </div>

    <div class="content">
        <!-- Add Newspaper -->
        <div id="add" class="form-box active">
            <form action="news" method="post">
                <h2>➕ Add Newspaper</h2>
                <input type="text" name="newsPaperName" placeholder="Name">
                <input type="text" name="price" placeholder="Price">
                <input type="text" name="language" placeholder="Language">
                <input type="text" name="noOfPages" placeholder="No Of Pages">
                <input type="submit" value="Save">
                <p style="color: lightgreen;">${validataionMessage}</p>
            </form>
        </div>

        <!-- Search by Name -->
        <div id="searchName" class="form-box">
            <form action="searchNewsPaper.abc">
                <h2>🔍 Search by Name</h2>
                <input type="text" name="searchNewsPaper" placeholder="Enter Newspaper Name">
                <input type="submit" value="Search Newspaper">
                <p style="color: yellow;">${NotFound}</p>
            </form>
        </div>

        <!-- Search by Language -->
        <div id="searchLang" class="form-box">
            <form action="searchLanguage.abc">
                <h2>🗣️ Search by Language</h2>
                <input type="text" name="searchLanguage" placeholder="Enter Language">
                <input type="submit" value="Search Language">
                <p style="color: yellow;">${SearchValidation}</p>
            </form>
        </div>

        <!-- View All -->
        <div id="viewAll" class="form-box">
            <form>
                <h2>📄 View All Newspapers</h2>
                <a href="getAllNewsPaper.abc" style="color: #03a9f4; font-weight: bold;">Click here to view all records</a>
            </form>
        </div>

        <!-- Delete Newspaper -->
        <div id="delete" class="form-box">
            <form action="deleteNewspaper.abc">
                <h2>🗑️ Delete Newspaper</h2>
                <input type="text" name="newsPaperName" placeholder="Enter Name">
                <input type="submit" value="Delete">
            </form>
        </div>

        <!-- Update Newspaper -->
        <div id="update" class="form-box">
            <form action="updateNewspaper.abc">
                <h2>✏️ Update Newspaper</h2>
                <input type="text" name="newsPaperName" placeholder="Name">
                <input type="text" name="price" placeholder="Price">
                <input type="text" name="language" placeholder="Language">
                <input type="text" name="noOfPages" placeholder="No Of Pages">
                <input type="submit" value="Update">
                <p style="color: orange;">${errorMessage}</p>
            </form>
        </div>
    </div>
</div>

<footer>
    <p>© 2025 Newspaper App | Developed by Ganesh MP - Java Full Stack Developer</p>
</footer>

<script>
    function showForm(id) {
        const forms = document.querySelectorAll('.form-box');
        forms.forEach(f => f.classList.remove('active'));
        document.getElementById(id).classList.add('active');
    }
</script>

</body>
</html>
