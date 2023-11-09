<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<div class="wrapper">
	<div class="container">
<h1>ログアウトしますか？</h1>
    <form action="LogoutOKServlet" method="get">
        <input type="submit" name="confirm" value="はい">
    </form>
    <form action="LogoutServlet" method="get">
        <input type="submit" name="confirm" value="いいえ">
    </form>
<a href="WelcomeServlet">トップへ</a>
	</main>
	</div>
	</div>
	<%@ include file = "footer.jsp" %>  
</body>
</html>
