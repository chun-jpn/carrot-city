<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="css/style_formframe.css">
	<style>	
main {
	font-size: 20px;
}
table {
    /*border: 1px solid rgb(150, 233, 220);*/
    margin:auto;
    margin-left: auto;
    margin-right: auto;
}
.item_Detail img {
    box-shadow: 0 0 10px -3px #00000073;
}
/*モバイル対応*/
@media screen and (max-width: 768px) {
  .last td:last-child {
    border-bottom: solid 1px #ccc;
    width: 100%;
  }
  .item_Detail {
    width: 80%;
  }
  .item_Detail th,
  .item_Detail td {
    border-bottom: none;
    display: block;
    width: 100%;
  }
}
	</style>
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<h1 class="logout_h1">商品詳細</h1>
	<%
	Items items = (Items) session.getAttribute("items");
	%>
<table>
	<tr>	
	<td>
<div class="item_Detail">
	<img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="600"
		height="380">
	<br>
	</td>
	
	<td>
	<span style="margin-bottom: 30px;">商品ID:<%=items.getItem_id()%>
	<%=items.getItem_name()%></span><br>
	
	<p>価格:<b style="font-size: 24px;">&yen;<%=items.getPrice()%></b></p><br>
	<%-- 	<p>在庫</p><%=items.getstock()%>  --%>

	<form method="post" action="http://localhost:8080/xmasTown/CartServlet">
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

	</td>
	</tr>
</div>
</table>
	<p class="link-text">
		<a href="WelcomeServlet" class="b">TOPへ</a>
	</p>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>