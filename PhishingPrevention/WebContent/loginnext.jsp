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
<%
	String str = (String) request.getAttribute("imgUrl");
    String str1 = (String) request.getAttribute("dwn");
%>
</head>
<body>
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
	<div class="row">

		<form class="col s12" method="post" action="decryptservlet?download=<%=str1 %>&filename=<%=str%>">
			<div class="row"
				style="width: 800px; text-align: center; margin: 0 auto; padding-top: 50px;">
				<div class="input-field col s12">
					<input id="privatekey" name="privatekey" type="text" class="validate"> <label
						for="privatekey">Private Key:</label>
				</div>
				
				<div class="row">
					<div class="col s12">
						<button class="btn waves-effect waves-light red" type="submit"
							name="action">Decrypt</button>
					</div>
				</div>
	</form>
	<form action="logintest"></form>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input id="first_name" type="text" class="validate"> <label
						for="first_name">UserId</label>
				</div>
				<div class="input-field col s6">
					<input name="Password" id="Password" type="Password"
						class="validate"> <label for="Password">Password</label>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<button class="btn waves-effect waves-light red" type="submit"
						name="action">Login</button>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(".button-collapse").sideNav();
	</script>

</body>
</html>