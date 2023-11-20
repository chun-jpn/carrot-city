<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<% Users user = (Users)session.getAttribute("user");  %>
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
<% String userName = user.getUserName(); %>
<% String address = user.getAddress(); %>
<% String tel = user.getTel(); %>
<% String mail = user.getMail(); %>
<% String password = user.getPassword(); %>

<%@ include file = "header.jsp" %>
	<main>
	<h1 class="change_h1">下記内容で変更します</h1>
	<div class="login-container" style="margin-top: 0%; width: 40%;">
		<form action="ChangeAccountOKServlet" method="POST">
			<div class="left">
			<p><b>ユーザー名: &nbsp;</b><%= userName %></p>
			<p><b>住所: &nbsp;</b><%= address %></p>
			<p><b>電話番号: &nbsp;</b><%= tel %></p>
			<p><b>メースアドレス: &nbsp;</b><%= mail %></p>
			<p><b>パスワード: &nbsp;</b>*********</p>
			<p>確認のためパスワードを再度入力してください</p>
			<p><input type="password" class="input-field" name="checkPass"></p>
					<input type="submit" value="変更確定" id="button-arrow-inner">
			</div>
					<p><a href="ChangeAccountServlet"  id="button-arrow-inner-can">キャンセル</a></p>
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