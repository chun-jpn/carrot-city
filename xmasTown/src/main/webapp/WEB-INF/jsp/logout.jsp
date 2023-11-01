<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xmas Town</title>
</head>
</head>
<body>
<h1>ログアウトしますか？</h1>
    <form action="LogoutOKServlet" method="get">
        <input type="submit" name="confirm" value="はい">
    </form>
    <form action="LogoutServlet" method="get">
        <input type="submit" name="confirm" value="いいえ">
    </form>
<a href="WelcomeServlet">トップへ</a>
</body>
</html>