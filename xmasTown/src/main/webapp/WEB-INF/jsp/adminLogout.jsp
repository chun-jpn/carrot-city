<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
</head>
<body>
<h1>管理者ログアウトしますか？</h1>
    <form action="AdminLogoutOKServlet" method="get">
        <input type="submit" name="confirm" value="はい">
    </form>
    <form action="AdminLoginServlet" method="get">
        <input type="submit" name="confirm" value="いいえ">
    </form>
</body>
</html>
