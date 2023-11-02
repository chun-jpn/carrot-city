<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Items" %>
<% Items items = (Items)request.getAttribute("item"); %>
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
<% int quantity = items.getQuantity(); %>
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
<p>在庫数:<%= quantity %></p>
<p>公開/非公開:<%= releaseFlagValue %></p>
<p>商品画像:<img src="<%= picture %>" alt="商品画像"></p>
<p><%= picture %>
</body>
</html>