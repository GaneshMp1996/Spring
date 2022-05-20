<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Mail</title>
</head>
<body>
	<div class="container ">
		<h1 style="text-align: center">Java Mail Sender</h1>
	</div>
	<form action="sendMail.do" method="post">
		<div class="form-row p-0 m-0 ">
			<div class=" container col-md-4 mb-3 ">
				<div class="form-group">
					<label for="mailAddress">To</label> <input type="email" name="to"
						class="form-control" id="mailAddress"
						placeholder="name@example.com">
				</div>
			</div>
		</div>
		<div class="form-row p-0 m-0 ">
			<div class=" container col-md-4 mb-3 ">
				<div class="form-group">
					<label for="subject">Subject</label> <input type="text"
						name="subject" class="form-control" id="subject"
						placeholder="Enter your subject here">
				</div>
			</div>
		</div>
		<div class="form-row p-0 m-0 ">
			<div class=" container col-md-4 mb-3 ">
				<div class="form-group">
					<label for="msg">Message</label>
					<textarea class="form-control" name="message" id="msg" rows="3"
						placeholder="Enter your message here"></textarea>
				</div>
			</div>
		</div>
		<div class="container text-center">
		<button type="submit" value="Send" class="btn btn-primary">Send</button>
		</div>
	</form>
	<h2>${message }</h2>



</body>
</html>