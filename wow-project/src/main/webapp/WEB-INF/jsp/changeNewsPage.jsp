<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
<title>super</title>
</head>
<body>
	<div class="headline">
		<h1 style="margin: 20px; background-color: #cd0000">
			<span>News </span>
		</h1>
		<div class="conteiner">
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="ADD_NEWS" />
				<button>ADD NEWS</button>
			</form>
				
		</div>

	</div>
	<div>
	
	<form action="Controller" method="post">
				<input type="text"
				name="title" value="" placeholder="title" />
				<input type="text"		
				name="brief" value="" placeholder="brief" />
				<input type="hidden" name="commandToController" value="ADD_NEWS" />
				<button>LOGIN</button>
			</form>
	</div>
	

</body>
</html>