
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>REGISTRATION PAGE</title>
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
</head>
<body style="background: linear-gradient(45deg, #040404, #240303)">
	<div class="headline">
		<h1 style="margin: 20px; background-color: #cd0000">
			<font>News </font>
		</h1>
		<div class="conteiner">
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController"
					value="REGISTRATION_PAGE" />
				<button>REGISTER</button>
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController"
					value="AUTHORIZATION_PAGE" />
				<button>LOGIN</button>
			</form>
		</div>

	</div>

	<div class="registrationDiv">
		<h2 style="font-weight: 600;">MD-JD2-76-21</h2>
		<font style="text-size: 16; font-weight: 600;">Create your MD2
			account</font>
		<div style="display: flex; flex-direction: line;">
			<font style="text-size: 5;">Already have an account?</font>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController"
					value="AUTHORIZATION_PAGE" /> <a
					href="http://localhost:8080/wow-project/Controller?commandToController=AUTHORIZATION_PAGE">Log
					in</a>
			</form>
		</div>
		<form action="Controller" method="post">
			<br /> <br /> <input type="hidden" name="commandToController"
				value="REGISTRATION_NEW_USER" /> <br /> <input type="text"
				name="login" value="" placeholder="Your login" /><br /> <br /> <input
				type="password" name="password" value="" placeholder="Your password" /><br />
			<br /> <br /> <input type="submit" class="redbutton1" value="Send" /><br />
		</form>
		<font class="systemMessage"> <%
 String message = (String) request.getParameter("message");
 if (message != null) {
 	out.print(message);
 }
 %>
		</font>

	</div>

</body>
</html>