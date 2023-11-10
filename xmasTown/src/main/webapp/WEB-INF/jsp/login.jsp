				<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="css/style_formframe.css">
	<title>CHRISTMAS TOWN</title>
	
</head>
<body>
<%@ include file = "header.jsp" %>
	    <main>
	    <div class="login-container">   
			<h1>ログイン</h1>
			<form action="LoginServlet" method="post">
				メールアドレス:<input type="text" class="input-field" name="mail" placeholder="Mail"><br>
				パスワード:<input type="password" class="input-field" name="password" placeholder="Password"><br><br>
			<a class="b"><input type="submit"  id="login-button" value="ログイン"></a><br><br><br>
			<a href ="RegisterServlet" class="buttonBasic"  class="b">新規会員登録</a><br>
			
			</form>
				<p class="link-text" id="b">
					<a href="WelcomeServlet">TOPへ</a>
				</p>
					<br>
				</p>
  		</main>
  		</div>
<%@ include file = "footer.jsp" %>  
</body>
</html>
