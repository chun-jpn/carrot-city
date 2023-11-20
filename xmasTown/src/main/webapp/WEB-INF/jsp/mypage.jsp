<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name = (String) session.getAttribute("name"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css?family=M+PLUS+1p" rel="stylesheet">
	<link rel="stylesheet" href="css/style_formframe.css">
    <link rel="stylesheet" type="text/css" href="css/style_mypage.css">
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>	
	<h1 class="change_h1">マイページ</h1>
		<div class="box27" style="margin: 0;">
			<p class="font-name">ようこそ、<%= name %>さん！</p>
		<div class="box8">
			<p><a href="ChangeAccountServlet" class="slide-button">登録情報変更</a></p>
		</div>
		<div class="box8">
		<p><a href="DeleteAccountServlet" class="slide-button">退会</a></p>
		</div>	
			<p class="link-text"><a href="WelcomeServlet" class="b">TOPへ</a></p>	
			<p><a href="LogoutServlet" class="btn btn--orange btn--radius">ログアウト</a></p>
		</div>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>