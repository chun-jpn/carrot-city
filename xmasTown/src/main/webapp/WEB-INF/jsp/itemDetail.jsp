<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/items.css">
<link rel="stylesheet" href="css/style_formframe.css">
<style>
table .itemsDetail-teble {
	border: none;
}
</style>
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<main>
		<h1 class="change_h1" style="margin: 0;">商品詳細</h1>
		<%
		Items items = (Items) session.getAttribute("items");
		%>
		<table class="login-container"
			style="box-shadow: 0 0 90px rgba(0, 0, 0, 0.2);">
			<td>
				<div style="margin-top: 0%; width: 580px;">
					<%--<a href="itemImage/<%=items.getPicture()%> class="image_link" >	--%>
					<img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="540"
						height="500" id="itemImage">
			</td>
			<td>
				<div style="margin-top: auto;">
					<span style="margin-bottom: 30px;" class="product-title"> <%=items.getItem_name()%></span><br>
					<font size="3">商品ID:<%=items.getItem_id()%></font>
				</div>
				<p style="background: rgb(220, 233, 231);">商品説明</p>
				<br>
				<p style="font-size: 14px"><%=items.getComment()%></p>
				<br>
			<br> 価格:<b style="font-size: 24px;" class="product-price">&yen;<fmt:formatNumber
						value="<%=items.getPrice()%>" type="currency" currencySymbol=""
						maxFractionDigits="0" /></b> <%-- 	<p>在庫</p><%=items.getstock()%>  --%>

				<div class="login-container" style="margin-top: 0%; width: 540px;">
					<form method="post"
						action="http://localhost:8080/xmasTown/CartServlet">
						<%--<input type="hidden" name="item_id" value="<%=items.getItem_id()%>">  --%>

						個数:<select name="quantity" style="font-size: 18px;">
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select><br> <input type="submit" id="button-063" value="カートに入れる">
					</form>
			</td>
		</table>
		</div>
		</div>
		<p class="link-text">
			<a href="WelcomeServlet" class="b">TOPへ</a>
		</p>
	</main>
	<%@ include file="footer.jsp"%>
</body>
</html>