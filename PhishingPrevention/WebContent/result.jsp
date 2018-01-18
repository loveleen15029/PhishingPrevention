<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phishing Prevention</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" rel="stylesheet"
	href="static/css/materialize.min.css" media="screen,projection" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="static/js/materialize.min.js"></script>
</head>
<body>
<% String key= (String)request.getAttribute("key"); %>
<nav>
	<div class="nav-wrapper">
		<a href="#!" class="brand-logo right">Pp</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">Menu</i></a>
		<ul class="left hide-on-med-and-down">
			<li><a href="login.jsp">LogIn</a></li>
			<li><a href="index.jsp">SignUp</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="login.jsp">LogIn</a></li>
			<li><a href="index.jsp">SignUp</a></li>
		</ul>
	</div>
	</nav>
<div class="row" style="width:800px; text-align: center; margin:0 auto;  padding-top: 50px;">Your Private key is : <%= key %></div>

</body>
</html>