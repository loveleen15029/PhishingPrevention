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
	int x = (int) (Math.random() * 50) + 0;
	int y = (int) (Math.random() * 50) + 0;
	int op = (int) (Math.random() * 3) + 0;
	if(y>x)
	{
		int temp=x;
	    x=y;
	    y=temp;
		
	}
	int result = 0;
	char op1 = '4';
	switch (op) {
	case 0:
		op1 = '+';
		result = x + y;
		break;
	case 1:
		op1 = '-';
		result = x - y;
		break;
	case 2:
		op1 = '*';
		result = x * y;
		break;
	}
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
		<form class="col s12" method="post"
			action="logintest?x=<%=x%>&y=<%=y%>&op=<%=op%>">
			<div class="row">
				<div class="input-field col s6">
					<input name="userid" id="userid" type="text" class="validate"> <label
						for="userid">UserId</label>
				</div>
				<div class="input-field col s6">
					<input name="captcha" id="captcha" type="text" class="validate">
					<label for="captcha">Captcha : <%= x+" "+op1+" "+y %></label>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<button class="btn waves-effect waves-light red" type="submit"
						name="action">Check</button>
				</div>
			</div>
		</form>
	</div>
	<script>
	$(".button-collapse").sideNav();
	</script>

</body>
</html>