<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sign Up</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">	
	<link rel="stylesheet" href="./css/signupAndIn.css" />  	
</head>
<body>

	<%
  		String id = (request.getParameter("id") == null) ? "" : (String) request.getParameter("id");
  	%>

	<div>
		<div class="container">
			<div class="header">SIGN IN</div>
			<form id="signinForm" action="/WebClass/bloglogin" method="post">
				<div class="form-group">
					<label for="id" class="text">ID</label>
					<input value='<%= id %>' name="id" type="text" class="form-control" id="id" placeholder="Id" required>
				</div>
				<div class="form-group">
					<label for="pwd" class="text">Password</label>
					<input name="pwd" type="password" class="form-control" id="pwd" placeholder="Password" required>
				</div>
				<input type="submit" class="btn btn-primary center" />	
			</form>
		</div>
	</div>
	
	<%@ include file="../jsp/modal.jsp" %>
	
	<script>
	<%
		if ("error".equals(request.getAttribute("result"))) {
	%>

	var myModal = $('#myModal');
	myModal.find('.modal-title').text('Login Error');
	myModal.find('.modal-body').text('Invalid username or password');
	myModal.modal();

	<% } %>
	</script>
	
</body>
</html>