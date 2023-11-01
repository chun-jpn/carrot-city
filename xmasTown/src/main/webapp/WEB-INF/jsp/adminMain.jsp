<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xmas Town</title>
</head>
<body>
<form action="ProducSearchServlet" method="post">
	<label>
		<input type="text" placeholder="商品名">
	</label>
		<input type="submit" value="商品検索">
</form>
<p><a href="AddItemServlet">商品新規登録</a></p>
<p><a href="AdminAccountServlet">アカウント管理</a></p>
<p><a href="AdminLogountServlet">ログアウト</a></p>
</body>
</html>