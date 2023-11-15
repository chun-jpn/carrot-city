<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style_formframe.css">
	<link rel="stylesheet" type="text/css" href="css/style_mypage.css">
	<style>
    	p {
    	font-size:20px;
    	}
    </style>
<title>CHRISTMAS TOWN</title>
</head>
	<body>
	<%@ include file = "header.jsp" %>
	<main>
		<h1 class="logout_h1"><p class="marker1"  style="font-size: 30px;"><span>退会が完了しました</span></p></h1>
			<p>ご利用、ありがとうございました。</p>
			<p class="link-text">
				<a href="WelcomeServlet" class="b">TOPへ</a>
			</p>
</main>
<%@ include file = "footer.jsp" %>
</body>
</html>