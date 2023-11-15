<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<% Users account = (Users)session.getAttribute("account");  %>
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
<% String userName = account.getUserName(); %>
<% String address = account.getAddress(); %>
<% String tel = account.getTel(); %>
<% String mail = account.getMail(); %>
<% String password = account.getPassword(); %>

<%@ include file = "header.jsp" %>
	<main>
	<h1 class="change_h1">登録情報の変更</h1>
	<div class="login-container" style="margin-top: 0%; width: 600px;">
			
			<form action="ChangeAccountServlet" method="POST">
				<div class="left">
					<p><b>ユーザー名: &nbsp;</b><input type="text" class="input-field" name="userName" value="<%= userName %>"></p>
					<p><b>住所: &nbsp;</b><input type="text"  class="input-field"  name="address" value="<%= address %>"></p>
					<p><b>電話番号: &nbsp;</b><input type="text" class="input-field"  name="tel" value="<%= tel %>"></p>
					<p><b>メースアドレス: &nbsp;</b><input type="text"  class="input-field" name="mail" value="<%= mail %>"></p>
					<p><b>パスワード: &nbsp;</b><input type="password"  class="input-field"  name="password" value="<%= password %>"></p>
						<input type="submit" value="変更内容送信" id="button-arrow-inner">
				</div>
			</form>
			<br>
					<p><a href="MypageServlet" class="button-52" role="button">マイページへ</a></p>				
						<p class="link-text">
							<a href="WelcomeServlet" class="b">TOPへ</a>
					</p>
	</main>
	
	</div>
<%@ include file = "footer.jsp" %>
</body>
</html>