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
    <h1>検索結果一覧</h1>
    <p>商品一覧</p>

    <%
    List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
    %>
    <%
    for (Items items : itemsList) {
    %>
    <a
        href="<%=request.getContextPath()%>/ProductDetailServlet?item_id=<%=items.getItem_id()%>">
        <img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="300"
        height="200">
    </a>
    <br>
    <%=items.getItem_name()%><br>
    <%=items.getPrice()%><br>
    <%
    }
    %>

    <p>
        <a href="AdminLoginServlet">TOPへ</a>
    </p>
</body>
</html>