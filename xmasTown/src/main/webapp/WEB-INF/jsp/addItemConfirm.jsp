<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Items" %>
<% //Items items = (Items)request.getAttribute("item"); %>
<% Items items = (Items)session.getAttribute("item");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<% String category = items.getCategory(); %>
<% String itemName = items.getItem_name(); %>
<% int price = items.getPrice(); %>
<% String comment = items.getComment(); %>
<% int stock = items.getStock(); %>
<% int releaseFlag = items.getRelease_flag(); %>
<% String picture = items.getPicture(); %>

<%
String releaseFlagValue = "";
if(releaseFlag == 0) {
	releaseFlagValue = "公開";
}else if(releaseFlag == 1) {
	releaseFlagValue = "非公開";
}else {
	releaseFlagValue = "公開/非公開が選択されていません";
}
%>

<h2>下記の内容で商品を登録します</h2>
<p>商品カテゴリ:<%= category %></p>
<p>商品名:<%= itemName %></p>
<p>商品価格:<%= price %></p>
<p>コメント:<%= comment %></p>
<p>在庫数:<%= stock %></p>
<p>公開/非公開:<%= releaseFlagValue %></p>
<p>商品画像:<img src="itemImage/<%= picture %>" alt="商品画像"></p>
<img src="itemImage/1e129c56-1d8d-4af9-869c-e25d62ab417920231106094315.jpg">
<p><%= picture %>
<form action="AddItemOKServlet" method="POST">
<input type="submit" value="登録する" />
</form>
<form action ="AddItemNGServlet" method="GET">
<input type="submit" value="登録をキャンセルする" />
</form>
</body>
</html>