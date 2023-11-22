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
<link rel="stylesheet" href="css/style_formframe.css">
<link rel="stylesheet" href="css/itemDetail.css">
<style>

</style>
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<div class="footerFixed">
	<%@ include file="header.jsp"%>
	<main align="center">
		<h1 class="change_h1" style="margin: 0;">商品詳細</h1>
		<%
		Items items = (Items) session.getAttribute("items");
		%>
		<table class="login-container"
			style="margin: 0 auto; box-shadow: 0 0 90px rgba(0, 0, 0, 0.2);" width="350">
			<tr>
			<th>
				<div style="margin-top: 0%; " align="center">
					<%--<a href="itemImage/<%=items.getPicture()%> class="image_link" >	--%>
					<img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="540"
						height="500" id="itemImage">
			</th>
			<td  style="border-radius: 10px;" id="size1">
				<div style="margin: 0 auto;">
					<span style="margin-bottom: 30px;" class="product-title"> <%=items.getItem_name()%></span><br>
					<font size="3">商品ID:<%=items.getItem_id()%></font>
				</div>
				<div style="text-align:left;">
					<p style="background: rgb(220, 233, 231); font-size: 16px;"><b>商品説明</b></p>
					<br>
					<p style="margin-top: -20px; font-size: 14px;"><%=items.getComment()%></p>
						<br>
						価格:<b style="font-size: 24px;" class="product-price">&yen;<fmt:formatNumber
						value="<%=items.getPrice()%>" type="currency" currencySymbol=""
						maxFractionDigits="0" /></b> <%-- 	<p>在庫</p><%=items.getstock()%>  --%>
				</div>
				<div class="login-container" id="size2">
				<% if(items.getStock() > 0){ %>
					<form method="post"	action="CartServlet">
						<%--<input type="hidden" name="item_id" value="<%=items.getItem_id()%>">  --%>

						個数:
						<select name="quantity" style="font-size: 18px;">
							<% for(int i = 1 ; i <= items.getStock() ; i++){ %>
								<% if(i == 1){ %>
									<option value="<%= i %>" selected><%= i %></option>
								<% }else{ %>
									<option value="<%= i %>"><%= i %></option>
								<% } %>
							<% } %>
						
						<%--
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						--%>
						</select><br><br>
						<input type="submit" id="button-063" value="カートに入れる">
						
					</form>
					<% }else{ %>
							<p>商品売り切れ中。入荷をお待ちください。</p>
					<% } %>
			</td>
			</tr>
		</table>
		</div>
		</div>
		<p class="link-text">
			<a href="WelcomeServlet" class="b">TOPへ</a>
		</p>
	</main>
	<%@ include file="footer.jsp"%>
	</div>
</body>
</html>