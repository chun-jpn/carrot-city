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
		<h1>管理者ログイン</h1>
		<form action="AdminLoginServlet" method="post">
			管理者ユーザーID:<input type="text" name="ownerId" placeholder="ID"><br><br>
			管理者パスワード:<input type="password" name="ownerPass" placeholder="password"><br><br>
			<a class="b"><input type="submit" value="ログイン"></a><br>
		</form>
	</div>
</body>
</html>
