<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_formframe.css">
<title>CHRISTMAS TOWN</title>
</head>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<h1 class="logout_h1"><span class="marker-border-1">ログアウトしますか？</span></h1>
	<div class="container">
    	<form action="LogoutOKServlet" method="get">
        	<input type="submit" name="confirm" value="はい"  class="btn hv-solid">
    </form>

    <form action="LogoutServlet" method="get" id="form">
        <input type="submit" name="confirm" value="いいえ"  class="btn hv-solid">
    </form>
    </div>
    	<p class="link-text"  id="b">
			<a href="WelcomeServlet" class="b">TOPへ</a>
		</p>
	</main>
	<%@ include file = "footer.jsp" %>  
</body>
</html>
