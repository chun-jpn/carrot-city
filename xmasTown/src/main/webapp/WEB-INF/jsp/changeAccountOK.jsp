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
		<h1 class="logout_h1"  style="margin: 0;"><p class="marker2"><span style="font-size: 30px;">登録情報変更が完了しました</span></h1>
		<br>
			<p><a href="MypageServlet" class="button-52" role="button" style="color: #4f4f47;"><b>マイページに戻る<b></b></a></p><br>
			<p class="link-text">
				<a href="WelcomeServlet" class="b">トップページに戻る</a>
			</p>
	</main>
<%@ include file = "footer.jsp" %>
</body>
</html>