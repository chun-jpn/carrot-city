<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xmas Town</title>
</head>
<body>
<h1>管理者ページログイン</h1>
<form action="AdminLoginServlet" method="post">
管理者ユーザーID:<input type="text" name="ownerId"><br>
管理者パスワード:<input type="password" name="ownerPass"><br>
<input type="submit" value="ログイン"><br>
</form>
</body>
</html>
