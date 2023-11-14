<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<% Users user = (Users)session.getAttribute("user");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<% String userName = user.getUserName(); %>
<% String address = user.getAddress(); %>
<% String tel = user.getTel(); %>
<% String mail = user.getMail(); %>
<% String password = user.getPassword(); %>

<%@ include file = "header.jsp" %>
<main>
<h2>下記内容で変更します</h2>
<form action="ChangeAccountOKServlet" method="POST">
	<p>ユーザー名:<%= userName %></p>
	<p>住所:<%= address %></p>
	<p>電話番号:<%= tel %></p>
	<p>メースアドレス:<%= mail %></p>
	<p>パスワード: *********</p>
	<p>確認のためパスワードを再度入力してください</p>
	<p><input type="password" name="checkPass"></p>
	<p><input type="submit" value="変更確定" ></p>
</form>
<form action="ChangeAccountServlet" method="GET">
	<input type="submit" value="キャンセル" >
</form>
<p><a href="MypageServlet">マイページへ</a></p>
<p><a href="WelcomServlet">TOPへ</a></p>
</main>
<%@ include file = "footer.jsp" %>
</body>
</html>