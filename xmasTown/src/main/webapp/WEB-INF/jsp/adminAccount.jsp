<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Admin" %>
<% Admin account = (Admin)session.getAttribute("account");  %>
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
<% String ownerId = account.getOwnerId(); %>
<% String ownerName = account.getOwnerName(); %>
<% String ownerPass = account.getOwnerPass(); %>
<div class="login-container">
	<h1>管理者<br>登録情報変更</h1>
	<form action="AdminAccountServlet" method="post">
		<p>新しい管理者ユーザーID:<input type="text" name="ownerId" value="<%= ownerId %>"><br></p>
		<p>新しい管理者ユーザー名:<input type="text" name="ownerName" value="<%= ownerName %>"><br></p>
		<p>新しい管理者パスワード:<input type="password" name="ownerPass" value="<%= ownerPass %>"><br></p>
	   <input type="submit" name="confirm" value="変更">
	</form>
	<form action="AdminAccountServlet" method="get" class="red">
		<input type="submit" name="confirm" value="キャンセル">
	</form>
</div>
</body>
</html>
