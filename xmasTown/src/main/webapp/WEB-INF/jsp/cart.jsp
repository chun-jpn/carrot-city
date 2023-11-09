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
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
        </tr>
        <%
            int totalPrice = 0;
            for (Carts cartItem : cartList) {
                totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        %>
        <tr>
            <td><%= cartItem.getItemName() %></td>
            <td><%= cartItem.getPrice() %></td>
            <td><%= cartItem.getQuantity() %></td>
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