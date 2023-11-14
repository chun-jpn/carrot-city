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
		<h1  class="logout_h1"><p class="marker2" style="font-size: 30px;"><span>登録完了</span></p></h1>
			<p>CHRISTMAS TOWNへようこそ！<br>
			この度は、アカウント登録いただき誠にありがとうございます。<br>
			登録が完了しました。引き続きお買い物をお楽しみください。</p>
		<p class="link-text">
			<a href="WelcomeServlet" class="b">トップへ</a>
		</p>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>
