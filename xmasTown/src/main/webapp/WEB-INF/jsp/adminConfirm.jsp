<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Admin" %>
<% Admin admin = (Admin) session.getAttribute("admin");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<% String ownerId = admin.getOwnerId(); %>
<% String ownerName = admin.getOwnerName(); %>
<% String ownerPass = admin.getOwnerPass(); %>

<h1>管理者のユーザー情報変更しますか？</h1>
<form action="ChangeAdminAccountServlet" method="post">
	<p>管理者ユーザーID:<%= ownerId %></p>
    <p>管理者ユーザー名:<%= ownerName %></p>
    <p>パスワード: *********</p>
	<p>確認のためパスワードを再度入力してください</p>
	<p><input type="password" name="checkPass"></p>
        <input type="submit" value="変更">
</form>
    <form action="AdminAccountServlet" method="get">
        <input type="submit" name="confirm" value="キャンセル">
    </form>
</form>
</body>
</html>
