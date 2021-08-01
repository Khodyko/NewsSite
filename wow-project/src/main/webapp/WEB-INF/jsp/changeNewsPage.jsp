<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>CHANGE NEWS PAGE</title>
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />


<fmt:message bundle="${loc}" key="local.headline.button.name.register"
	var="register_button" />
<fmt:message bundle="${loc}" key="local.headline.button.name.changenews"
	var="change_news_button" />
<fmt:message bundle="${loc}" key="local.headline.button.name.login"
	var="login_button" />
</head>
<body>
	<div class="headline">

		<h1 style="margin: 20px; background-color: #cd0000">
			<span>News </span>
		</h1>
		<div class="conteiner">

			<form action="Controller" method="post">
				<input type="hidden" name="commandToController"
					value="CHANGE_NEWS_PAGE" />
				<button>${change_news_button}</button>
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController"
					value="REGISTRATION_PAGE" />
				<button>${register_button}</button>
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController"
					value="AUTHORIZATION_PAGE" />
				<button>${login_button}</button>
			</form>
		</div>
	</div>
	<div class="conteiner">
		<form action="Controller" method="post">
			<input type="hidden" name="commandToController" value="CHANGE_LOCAL" />
			<button type="submit" name="local" value="en"
				style="background-color: Transparent; background-repeat: no-repeat; border: none; cursor: pointer; overflow: hidden; width: 60px; height: 60px;">
				<img src="resources/pictures/usFlag.png">
			</button>
		</form>
		
		
		<form action="Controller" method="post">
			<input type="hidden" name="commandToController" value="CHANGE_LOCAL" />
			<button type="submit" name="local" value="ru"
				style="background-color: Transparent; background-repeat: no-repeat; border: none; cursor: pointer; overflow: hidden; width: 60px; height: 60px;">
				<img src="resources/pictures/ruFlag.png">
			</button>
		</form>

	</div>
	<div class="registrationDiv">
	<h2 style="font-weight: 600;">Add New News</h2>
	<br /> <br /> <br /> 
		<form action="Controller" method="post">
			<input type="text" name="title" value="" placeholder="title" />
			<br /> <br /> 
			
			 <input
				type="text" name="brief" value="" placeholder="brief" style="size:80px" /> <input
				type="hidden" name="commandToController" value="ADD_NEWS" />
				
				<br /> <br /> <br /> <br /> 
			<button>Send</button>
		</form>
	</div>
	

</body>
</html>