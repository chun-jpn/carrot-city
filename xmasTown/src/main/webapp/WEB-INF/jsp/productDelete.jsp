<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,model.Items"%>
<%
Items items = (Items) session.getAttribute("items");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
    <%
    String category = items.getCategory();
    %>
    <%
    String itemName = items.getItem_name();
    %>
    <%
    int price = items.getPrice();
    %>
    <%
    String comment = items.getComment();
    %>
    <%
    int stock = items.getStock();
    %>
    <%
    int releaseFlag = items.getRelease_flag();
    %>
    <%
    String picture = items.getPicture();
    %>

    <%
    String releaseFlagValue = "";
    if (releaseFlag == 0) {
      releaseFlagValue = "公開";
    } else if (releaseFlag == 1) {
      releaseFlagValue = "非公開";
    } else {
      releaseFlagValue = "公開/非公開が選択されていません";
    }
    %>

    <h2>下記の商品を削除します</h2>
    <p>
        商品カテゴリ:<%=category%></p>
    <p>
        商品名:<%=itemName%></p>
    <p>
        商品価格:<%=price%></p>
    <p>
        コメント:<%=comment%></p>
    <p>
        在庫数:<%=stock%></p>
    <p>
        公開/非公開:<%=releaseFlagValue%></p>
    <p>
        商品画像:<br> <img src="itemImage/<%=picture%>" alt="商品画像"
            width="300" height="200">
    </p>
    <form action="ProductDeleteOKServlet" method="GET">
        <%-- POSTからGETに変更 --%>
        <input type="submit" value="削除">
    </form>
    <form action="AdminLoginServlet" method="GET">
        <input type="submit" value="キャンセル">
    </form>
</body>
</html>