<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_formframe.css">
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %> 
	<main>
	<h1 class="logout_h1"><span class="marker-border-2">ログアウト完了しました</span></h1>
		<div class="maincopy">
		<p style="text-align: center; font-size: 24px">
		ご利用ありがとうございました。またのご利用お待ちしております。<br></p><br>
		</div>
	<p class="link-text"  id="b">
		<a href ="WelcomeServlet" class="b">TOPへ</a>
	</p>
	</main>
 	
	<%@ include file = "footer.jsp" %> 	 
</body>
</html>