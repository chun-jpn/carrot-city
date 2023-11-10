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
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/style_loginOK.css">
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<div class="bg" >
  		<span class="title">
		<span><h2>ようこそ！</span><span><%= name %>さん！</h2><span>
		</span>
		<br><br>
		<p class="link-text" id="b">
				<a href="WelcomeServlet">TOPへ</a><br>
		</p>
		<br>
			<div>
				<a href="LogoutServlet">ログアウト</a>
			</div>	
	</div>
				
	</main>
	<%@ include file ="footer.jsp" %>
	<script src="css/loginOK.js"></script>
</body>
</html>
