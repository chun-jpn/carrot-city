<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Items"%>
<%
Items items = (Items) session.getAttribute("items");
%>
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
	<div class="login-container">
		<h2>商品情報の変更が完了しました</h2>
		<br>
		<br>
		<a href="ProductDetailServlet?item_id=<%=items.getItem_id()%>">商品詳細に戻る</a><br>
		<a href="AdminLoginServlet">トップページに戻る</a>
	</div>
</body>
</html>