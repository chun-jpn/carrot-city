<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name = (String) session.getAttribute("name"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" type="text/css" href="css/style_mypage.css">
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>	
<h1>マイページ</h1>
<div class="box27">
<p>ようこそ、<%= name %>さん！</p>
	<div class="box8">
		<p><a href="ChangeAccountServlet" value="登録情報変更">登録情報変更</a></p>
	</div>
	<div class="box8">
		<p><a href="DeleteAccountServlet">退会</a></p>
	</div>
	<div class="box8">
		<p><a href="LogoutServlet">ログアウト</a></p>
	</div>
	<div class="box8">
		<p><a href="WelcomeServlet">TOPへ</a></p>
	</div>
		
	</div>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>