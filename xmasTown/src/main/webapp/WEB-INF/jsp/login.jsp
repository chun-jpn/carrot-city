<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<h1>ログイン</h1>
<form action="LoginServlet" method="post">
メールアドレス:<input type="text" name="mail"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="ログイン"><br>
<a href ="RegisterServlet" class="button">新規会員登録</a><br>
<br>
<p><a href="WelcomeServlet">TOPへ</a></p>
</form>
</body>
</html>
