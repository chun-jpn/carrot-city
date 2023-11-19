<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style_formframe.css">
	<link rel="stylesheet" type="text/css" href="css/style_mypage.css">
	<title>CHRISTMAS TOWN</title>
	<style>
    	p {
    	font-size:20px;
    	}
    </style>
</head>
<body>
<%@ include file = "header.jsp" %>
	<main>
	<h1 class="logout_h1"  style="margin: 0; font-size: 28px;">退会確認</h1>
	<div class="login-container" style="margin-top: 0%; width: 600px;">
				<p>退会する場合、メールアドレスとパスワードを入力して「退会する」ボタンを押してください</p>
		<div class="left">
		<form action="DeleteAccountOKServlet" method="post">
				<p><b>メールアドレス:</b><input type="text" name="checkMail" class="input-field"></p>
				<p><b>パスワード:</b><input type="password" name="checkPass" class="input-field"></p>
				<input type="submit" value="退会する" id="button-arrow-inner">
		</div>
		<br>
			<p><a href="MypageServlet" class="button-52" role="button">マイページに戻る</a></p>
		</form>
	</main>
<%@ include file = "footer.jsp" %>
</body>
</html>