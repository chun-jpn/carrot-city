<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xmas Town</title>
</head>
<body>
<h1>マイページ</h1>

<p>ようこそ<%= loginUser.getName() %>さん</p>

<p><a href="ChangeAccount">登録情報変更</a></p>
<p><a href="DeleteAccount">退会</a></p>
<p><a href="Welcom">TOPへ</a></p>
</body>
</html>