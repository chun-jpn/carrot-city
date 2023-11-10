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
<title>CHRISTMAS TOWN</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<main>
    <h1>ショッピングカート</h1>

    <table border="1">
        <tr>
        	<th>商品画像</th>
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
            <th></th>
            <th></th>
        </tr>
        <%
            int totalPrice = 0;
            for (Carts cartItem : cartsList) {
                totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        %>
        <tr>
        	<td><img src="itemImage/<%=cartItem.getPicture() %>" alt="商品画像" width="100" height="100"></td>
            <td><%= cartItem.getItem_name() %></td>
            <td><%= cartItem.getPrice() %></td>
            <td>
            	<input type="number" name="quantity" value="<%= cartItem.getQuantity() %>" min="1" max="99">
            </td>
            <td><a href="ChangeCartServlet">購入数変更</a></td>
            <td><a href="DeleteCartServlet">削除</a></td>
        </tr>
        <%
            }
        %>
    </table>

    <p>合計金額: <%= totalPrice %></p>

    <a href="OrderServlet">購入決定</a>
    <a href="WelcomeServlet">買い物を続ける</a>
</main>
<%@ include file = "footer.jsp" %>
</body>
</html>