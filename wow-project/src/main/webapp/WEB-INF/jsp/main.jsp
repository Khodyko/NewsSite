
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="bean.News"%>
<%@ page import="bean.User"%>
<%@ page import="bean.RoleEnum"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/property.css" type="text/css">
<title>super</title>
<style>
.pagination {
	border-top: 1px white solid;
	margin: 20px;
	margin-left: 0px;
	margin-right: 0px;
	height: 50px;
	background-color: black;
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: black;
}
/* Pagination links */
.pagination a {
	color: white;
	float: center;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
}

/* Style the active/current link */
.pagination a.active {
	background-color: #cd0000;
	color: white;
}

/* Add a grey background color on mouse-over */
.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />


<fmt:message bundle="${loc}" key="local.headline.button.name.register" var="register_button" />
<fmt:message bundle="${loc}" key="local.headline.button.name.addnews" var="add_news_button" />
<fmt:message bundle="${loc}" key="local.headline.button.name.login" var="login_button" />

</head>

<body>
	<div class="headline">

		<a href="Controller?commandToController=GO_TO_MAIN_PAGE" style="text-decoration: none;">
			<h1 style="margin: 20px; background-color: #cd0000">
				<span>News </span>
			</h1>
		</a>
		<div class="conteiner">
			<c:if test="${sessionScope.user != null}">
				<%
				String UserRole = (((User) request.getSession(false).getAttribute("user")).getRole()).toString();
				request.setAttribute("UserRole", UserRole);
				%>

				<c:if test="${UserRole == 'ADMIN'}">
					<form action="Controller" method="post">
						<input type="hidden" name="commandToController" value="ADD_NEWS_PAGE" />
						<button>${add_news_button}</button>
					</form>
				</c:if>
			</c:if>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="REGISTRATION_PAGE" />
				<button>${register_button}</button>
			</form>
			<form action="Controller" method="post">
				<input type="hidden" name="commandToController" value="AUTHORIZATION_PAGE" />
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
	<div style="justify-content: center;">
		<div style="width: 50%; margin: 0 auto; text-align: center;">
			<c:forEach var="news" items="${newses}">

				<a href="Controller?commandToController=GO_CONCRETE_NEWS&choosenNewsId=${news.getId()}" style="text-decoration: none;">
					<h1>
						<c:out value="${news.getTitle()}" />
					</h1>
					<img alt="image" src=<c:out value="${news.getImgLink()}"/>>

					<h4>
						<c:out value="${news.getBrief()}" />
					</h4>
					<hr align="center" size="1" color="white" />
				</a>
			</c:forEach>
		</div>
	</div>

	<div class="pagination" style="width: 50%; margin: 0 auto; text-align: center;">
		<c:if test="${currentPage>1}">
		<a href="Controller?commandToController=GO_TO_MAIN_PAGE&requestCurrentPage=${pageNumList.get(currentPage-2)}">&laquo;</a>
		</c:if>
		
			<c:forEach var="page" items="${pageNumList}">
			<c:if test="${page != currentPage}">
				<a href="Controller?commandToController=GO_TO_MAIN_PAGE&requestCurrentPage=${page}">${page}</a>
			</c:if>
			<c:if test="${page == currentPage}">
				<a class="active" href="#">${page}</a>
			</c:if>
		</c:forEach>
		<c:if test="${pageNumList.size()>currentPage}">
		<a href="Controller?commandToController=GO_TO_MAIN_PAGE&requestCurrentPage=${pageNumList.get(currentPage)}">&raquo;</a>
		</c:if>
	</div>

</body>
</html>