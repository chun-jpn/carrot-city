<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<div class="login-container">
		<h1>CONTACT</h1>
		<form action="ContactOKServle" class="input-field" method="post">
			Name:<input type="text" class="input-field" name="name"  placeholder="Name"><br>
			Mail:<input type="text" class="input-field" name="mail"  placeholder="Mail"><br>
			Message:<input type="text" class="input-field" name="message"  placeholder="Message" id="example2"><br>
			<br><br>
		<a class="b"><input type="submit" value="send"></a>
		</form>

		<p  class="link-text">
			<a href="WelcomServlet" class="b">TOPへ</a></p>
			<br>

	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>