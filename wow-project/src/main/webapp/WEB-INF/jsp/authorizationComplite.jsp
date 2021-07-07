<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="bean.RegistrationInfo" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
<title>REGISTRATION PAGE</title>
</head>
<body>
<div class="headline">
		<h1 style="margin: 20px; background-color: #cd0000">
			<font >News </font>
		</h1>
		<div class="conteiner">
		<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="CHANGE_NEWS_PAGE" />
				<button>REGISTER</button>
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="REGISTRATION_PAGE" />
				<button>REGISTER</button>
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="AUTHORIZATION_PAGE" />
				<button>LOGIN</button>
			</form>
		</div>

	</div>
	<h1>Login is complite!</h1>
	<h2>or not complite)))</h2>
	
	
	
</body>
</html>