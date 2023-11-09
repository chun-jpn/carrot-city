<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name = (String) session.getAttribute("name"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
<h2>ようこそ、<%= name %>さん！</h2>
<a href="WelcomeServlet">トップへ</a><br>
<a href="LogoutServlet">ログアウト</a>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>
