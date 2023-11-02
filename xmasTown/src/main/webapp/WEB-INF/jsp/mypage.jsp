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
<h1>マイページ</h1>
<p>ようこそ、<%= name %>さん！</p>

<p><a href="ChangeAccountServlet">登録情報変更</a></p>
<p><a href="DeleteAccountServlet">退会</a></p>
<p><a href="WelcomeServlet">TOPへ</a></p>
</body>
</html>