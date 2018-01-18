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
		<form class="col s12" method="post" action="signupdata" >
			<div class="row">
				<div class="input-field col s12">
					<input id="userid" name="userid" type="text" class="validate"> <label
						for="userid">UserId</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input id="firstname" name="firstname" type="text" class="validate"> <label
						for="firs_tname">First Name</label>
				</div>
				<div class="input-field col s6">
					<input id="lastname" name="lastname" type="text" class="validate"> <label
						for="last_name">Last Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="password" name="password" type="password" class="validate"> <label
						for="password">Password</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="email" name="email" type="email" class="validate"> <label
						for="email">Email</label>
				</div>
			</div>

			<div class="row">
				<div class="col s12">
					<div class="input-field inline">
						<h5>Gender</h5>
						<p>
							<input name="group1" type="radio" id="test1" /> <label
								for="test1">Male</label>
						</p>
						<p>
							<input name="group1" type="radio" id="test2" /> <label
								for="test2">Female</label>
						</p>
					</div>
				</div>
			</div>
			<div>
			
			</div>
			<div class="row">
				<div class="col s12">
					<button class="btn waves-effect waves-light red" type="submit"
						name="action">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<script>
	$(".button-collapse").sideNav();
	</script>

</body>
</html>