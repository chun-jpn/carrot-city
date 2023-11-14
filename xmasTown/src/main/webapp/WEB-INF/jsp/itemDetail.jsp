<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<h1>商品詳細</h1>




	<%
	Items items = (Items) session.getAttribute("items");
	%>

	<p>商品ID:</p><%=items.getItem_id()%>
	<%=items.getItem_name()%><br>

	<img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="300"
		height="200">
	<br>

	<p>価格:</p><%=items.getPrice()%><br>
	<%-- 	<p>在庫</p><%=items.getstock()%>  --%>

	<form action="CartServlet" method="POST">
<%--<input type="hidden" name="item_id" value="<%=items.getItem_id()%>">  --%>
	<select name="quantity">
		<option value="1" selected>1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
	</select>
	<input type="submit" value="カートに入れる">
	</form>


	<a href="WelcomeServlet">TOPへ</a>
</body>
</html>