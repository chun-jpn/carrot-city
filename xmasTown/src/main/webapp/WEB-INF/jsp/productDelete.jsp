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
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/responsive.css">
	<link rel="stylesheet" href="css/style_formframe.css">
	<link rel="stylesheet" href="css/style_admin.css">
	<style>
		p  {
			text-align: left;
		}
 	</style>
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
<div class="login-container">
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
        <input type="submit" value="削除">
    </form>
    <form action="AdminLoginServlet" method="GET" class="red">
        <input type="submit" value="キャンセル">
    </form>
</div>
</body>
</html>