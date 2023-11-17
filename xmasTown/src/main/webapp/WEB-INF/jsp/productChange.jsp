<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Items"%>
<%
Items items = (Items) session.getAttribute("items");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
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

<h2>下記内容で商品情報を変更します</h2>
<p>
    商品カテゴリ:<%=category%>
</p>
<p>
    商品名:<%=itemName%>
</p>
<p>
    商品価格:<%=price%>
</p>
<p>
    コメント:<%=comment%>
</p>
<p>
    在庫数:<%=stock%>
</p>
<p>
    公開/非公開:<%=releaseFlagValue%>
</p>
<p>
    <img src="itemImage/<%=picture%>" alt="商品画像" width="300" height="200">
</p>

<form action="ProductChangeOKServlet" method="GET">
    <input type="submit" value="変更">
</form>

<form action="ProductDetailServlet" method="GET">
    <input type="submit" value="キャンセル">
</form>
</body>
</html>