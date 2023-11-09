<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Admin" %>
<% Admin account = (Admin)session.getAttribute("account");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<% String ownerId = account.getOwnerId(); %>
<% String ownerName = account.getOwnerName(); %>
<% String ownerPass = account.getOwnerPass(); %>

<h1>管理者のユーザー登録情報変更</h1>
<form action="AdminAccountServlet" method="post">
	<p>新しい管理者ユーザーID:<input type="text" name="ownerId" value="<%= ownerId %>"><br></p>
	<p>新しい管理者ユーザー名:<input type="text" name="ownerName" value="<%= ownerName %>"><br></p>
	<p>新しい管理者パスワード:<input type="password" name="ownerPass" value="<%= ownerPass %>"><br></p>
   <input type="submit" name="confirm" value="変更">
</form>
    <form action="AdminAccountServlet" method="get">
        <input type="submit" name="confirm" value="キャンセル">
    </form>
</form>
</body>
</html>
