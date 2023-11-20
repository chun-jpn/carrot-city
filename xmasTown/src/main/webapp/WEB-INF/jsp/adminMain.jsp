<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="login-container">
	<h1>メインページ</h1>
	<form action="ProductSearchServlet" method="post">
		<label> <input type="text" name="item_name" placeholder="商品名">
		</label> <input type="submit" value="商品検索">
	</form>
	<form action="AddItemServlet" method="get" class="blue">
		<input type="submit" value="商品新規登録">
	</form>
		<form action="AdminAccountServlet" method="get" class="orange">
		<input type="submit" value="アカウント管理">
	</form>
    <p>
        <a href="AdminLogoutServlet" class="btn btn--orange btn--radius">ログアウト</a>
    </p>
</div>
</body>
</html>