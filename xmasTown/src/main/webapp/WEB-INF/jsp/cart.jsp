<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Carts" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>

<% List<Carts> cartsList = (ArrayList<Carts>)session.getAttribute("cartList");  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/items.css">
	<link rel="stylesheet" href="css/style_formframe.css">
	<title>CHRISTMAS TOWN</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<main>
    <h1 class="logout_h1">ショッピングカート</h1>
    <table class="table_box">
    <thead>
        <tr>
        	<th>商品画像</th>
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
            <th></th>
            <th></th>
        </tr>
	</thead>
        <%
            int totalPrice = 0;
            for (Carts cartItem : cartsList) {
                totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        %>
        <tr>
        	<td><img src="itemImage/<%=cartItem.getPicture() %>" alt="商品画像" width="150" height="150"></td>
			<td><%= cartItem.getItem_name() %></td>
			<td><%= cartItem.getPrice() %></td>
			<form action="ChangeCartServlet" method="post">
				<input type="hidden" name="cart_id" value="<%= cartItem.getCart_id() %>">
				<input type="hidden" name="item_id" value="<%= cartItem.getItem_id() %>">
				<td>
					<input type="number" name="quantity" value="<%= cartItem.getQuantity() %>" min="1" max="99">
				</td>
				<td>
					<input type="submit" value="数量変更">
				</td>
			</form>
			<form action="DeleteCartServlet" method="get">
				<input type="hidden" name="cart_id" value="<%= cartItem.getCart_id() %>">
				<input type="hidden" name="item_id" value="<%= cartItem.getItem_id() %>">
				<td>
					<input type="submit" value="削除">
	            </td>
			</form>
		</tr>
		<%
			}
		%>
    </table>
    	<br>
    	<div class="border22">
    	<hr>
    		<p>合計金額: <b><%= totalPrice %> 円</b></p>
    	
    

    <a href="OrderServlet">購入決定</a>
    <a href="WelcomeServlet"  class="button-063">買い物を続ける</a>
    </div>
	</div>
</main>
<%@ include file = "footer.jsp" %>
</body>
</html>