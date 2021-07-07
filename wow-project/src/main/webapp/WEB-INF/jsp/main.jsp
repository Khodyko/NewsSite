<%@page import="bean.News"%>
<%@page import="java.util.ArrayList"%>
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
				<input type="hidden" name="commandToController" value="CHANGE_NEWS_PAGE" />
				<button>Change News</button>
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
<%
ArrayList<News> newses=(ArrayList<News>)request.getAttribute("newses");
String title;
String brief;
String ImgLink;
for(int i=0;i<newses.size();i++){
	title=newses.get(i).getTitle();
	brief=newses.get(i).getBrief();
	ImgLink=newses.get(i).getImgLink();
	out.print("<h1>"+title+"</h1>");
	out.print("<h1>"+brief+"</h1>");
	out.print("<p style=\"text-align:center\"><img src=\""+ImgLink+"\" alt=\"You will be shocked!\"></p>");
}
%>



</body>
</html>