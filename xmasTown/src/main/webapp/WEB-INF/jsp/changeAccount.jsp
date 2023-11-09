<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<% Users account = (Users)session.getAttribute("account");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<% String userName = account.getUserName(); %>
<% String address = account.getAddress(); %>
<% String tel = account.getTel(); %>
<% String mail = account.getMail(); %>
<% String password = account.getPassword(); %>

<%@ include file = "header.jsp" %>
<main>
<h2>登録情報の変更</h2>
<form action="ChangeAccountServlet" method="POST">
	<p>ユーザー名:<input type="text" name="userName" value="<%= userName %>"></p>
	<p>住所:<input type="text" name="address" value="<%= address %>"></p>
	<p>電話番号:<input type="text" name="tel" value="<%= tel %>"></p>
	<p>メースアドレス:<input type="text" name="mail" value="<%= mail %>"></p>
	<p>パスワード:<input type="password" name="password" value="<%= password %>"></p>
	<input type="submit" value="変更内容送信" />
</form>
<p><a href="ChangeAccountServlet">戻る</a></p>
<p><a href="MypageServlet">マイページへ</a></p>
<p><a href="WelcomServlet">TOPへ</a></p>
</main>
<%@ include file = "footer.jsp" %>
</body>
</html>