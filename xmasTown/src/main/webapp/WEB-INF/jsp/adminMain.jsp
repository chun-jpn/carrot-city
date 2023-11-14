<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
    <form action="ProductSearchServlet" method="post">
        <label> <input type="text" placeholder="商品名">
        </label> <input type="submit" value="商品検索">
    </form>
    <p>
        <a href="AddItemServlet">商品新規登録</a>
    </p>
    <p>
        <a href="AdminAccountServlet">アカウント管理</a>
    </p>
    <p>
        <a href="AdminLogoutServlet">ログアウト</a>
    </p>
</body>
</html>