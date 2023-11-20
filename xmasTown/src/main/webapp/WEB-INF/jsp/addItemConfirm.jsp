<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Items" %>
<% //Items items = (Items)request.getAttribute("item"); %>
<% Items items = (Items)session.getAttribute("item");  %>
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
	<link rel="stylesheet" href="css/style_admin.css">
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<% String category = items.getCategory(); %>
	<% String itemName = items.getItem_name(); %>
	<% int price = items.getPrice(); %>
	<% String comment = items.getComment(); %>
	<% int stock = items.getStock(); %>
	<% int releaseFlag = items.getRelease_flag(); %>
	<% String picture = items.getPicture(); %>
	
	<%
	String releaseFlagValue = "";
	if(releaseFlag == 0) {
		releaseFlagValue = "公開";
	}else if(releaseFlag == 1) {
		releaseFlagValue = "非公開";
	}else {
		releaseFlagValue = "公開/非公開が選択されていません";
	}
	%>
	<div class="login-container">
		<h2>下記の内容で商品を登録します</h2>
		<h3>商品カテゴリ:</h3>
		<p><%= category %></p>
		<h3>商品名:</h3>
		<p><%= itemName %></p>
		<h3>商品価格:</h3>
		<p><%= price %></p>
		<h3>コメント:</h3>
		<p><%= comment %></p>
		<h3>在庫数:</h3>
		<p><%= stock %></p>
		<h3>公開/非公開:</h3>
		<p><%= releaseFlagValue %></p>
		<h3>商品画像:<img src="itemImage/<%= picture %>" alt="商品画像"></h3>
		<form action="AddItemOKServlet" method="POST">
			<input type="submit" value="登録する" />
		</form>
		<form action ="AddItemNGServlet" method="GET" class="red">
			<input type="submit" value="登録をキャンセルする" />
		</form>
	</div>
</body>
</html>