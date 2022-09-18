<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save-NewsPaper</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-0 m-0">
		<%@include file="navbar.jsp"%>
		<div class="card shadow bg-white p-0">
			<img alt="" class="img-fluid mx-auto p-0 m-0"
				style="max-width: 150px" src="image/news.png">
			<h1 class="text-primary text-uppercase text-center m-0 p-0"
				style="text-align: center">Save Your News Paper</h1>
			<div 
			class="alert alert-success text-center" role="alert">${validateMessage}
			</div>

			<form action="submitnewspaper.do" method="post">
			<div class="form-row p-0 m-0 ">
				<!-- <div class=" container col-md-4 mb-3 " >
						<input
							name="newsPaperId" 
							type="hidden" class="form-control is-invalid"
							id="validateId" placeholder="Id"  required>
					</div> -->	
				</div>
				<div class="form-row p-0 m-0 ">
					<div class=" container col-md-4 mb-3">
						<label for="validateNewsPaperName">Newspaper Name</label> <input
							name="newsPaperName" type="text" class="form-control is-invalid"
							id="validateNewsPaperName" placeholder="Name" required>
						<div class="invalid-feedback">${validateNewsPaperName}</div>
					</div>
				</div>
				<div class="form-row p-0 m-0">
					<div class=" container col-md-4 mb-3">
						<label for="validatePrice">Price</label> <input name="price"
							type="text" class="form-control is-invalid" id="validatePrice"
							placeholder="Price" required>
						<div class="invalid-feedback">${validatePrice}</div>
					</div>
				</div>
				<div class="form-row p-0 m-0">
					<div class="container col-md-4 mb-3">
						<label for="validateLanguage">Language</label> <input
							name="language" type="text" class="form-control is-invalid"
							id="validateLanguage" placeholder="Language"
							aria-describedby="inputGroupPrepend3" required>
						<div class="invalid-feedback">${validateLanguage}</div>
					</div>
				</div>
				<div class="form-row p-0 m-0">
					<div class="container col-md-4 mb-3">
						<label for="validateNoOfPages">NoOfPages</label> <input
							name="noOfPages" type="text" class="form-control is-invalid"
							id="validateNoOfPages" placeholder="NoOfPages" required>
						<div class="invalid-feedback">${validateNoOfPages}</div>
					</div>
				</div>
				<div class="container text-center">
					<button class="btn btn-primary " type="submit" value="Submit">Submit</button>
				</div>
			</form>


		</div>
	</div>





</body>
</html>