<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Admin" %>
<% Admin admin = (Admin) session.getAttribute("admin");  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/responsive.css">
	<link rel="stylesheet" href="css/style_formframe.css">
	<link rel="stylesheet" href="css/style_admin.css">
	<title>CHRISTMAS TOWN</title>
</head>
<body>
<% String ownerId = admin.getOwnerId(); %>
<% String ownerName = admin.getOwnerName(); %>
<% String ownerPass = admin.getOwnerPass(); %>
<div class="login-container">
	<h1>下記の内容で<br>変更します</h1>
	<form action="ChangeAdminAccountServlet" method="post">
		<h3>管理者ユーザーID:</h3>
		<p><%= ownerId %></p>
		<h3>管理者ユーザー名:</h3>
		<p><%= ownerName %></p>
		<h3>パスワード:</h3>
		<p>*********</p>
		<h3>確認のためパスワードを再度入力してください</h3>
		<p><input type="password" name="checkPass"></p>
		<input type="submit" value="変更">
	</form>
	    <form action="AdminAccountServlet" method="get">
	        <input type="submit" name="confirm" value="キャンセル">
	    </form>
	</form>
</div>
</body>
</html>
