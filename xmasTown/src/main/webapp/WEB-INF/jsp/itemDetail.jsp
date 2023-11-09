<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>商品詳細</h1>

<p>商品ID</p>
<p>商品名</p>
<p>価格</p>
<p>数量</p>


	<%
	List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
	%>
	<%
	for (Items items : itemsList) {
	%>

	<img src = "itemImage/<%=items.getPicture()%>" alt="商品画像" width="300" height="200"><br>
	<%=items.getItem_name()%><br>
	<%=items.getPrice()%><br>

	<%
	}
	%>





<p>カートに入れる</p>
<p>戻る</p>
</body>
</html>