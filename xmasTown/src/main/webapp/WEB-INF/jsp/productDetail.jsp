<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,model.Items"%>
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
    <p>在庫</p><%=items.getStock()%>

    <p>商品ID:</p><%=items.getItem_id()%>
    <%=items.getItem_name()%><br>

    <img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="300"
        height="200">
    <br>

    <form action="AddItemOKServlet" method="GET">
        <input type="submit" value="変更" />
    </form>
    <form action="AddItemNGServlet" method="GET">
        <input type="submit" value="削除">
    </form>
    <p>
        <a href="ProductSearchServlet">商品一覧へ</a>
    </p>
</body>
</html>