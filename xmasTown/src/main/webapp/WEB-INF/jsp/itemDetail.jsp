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
	<%@ include file = "header.jsp" %>
	<main>
<h1>商品詳細</h1>




	<%
	List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
	%>
	<%
	for (Items items : itemsList) {
	%>
	
	<p>商品ID:</p><%=items.getPrice()%>
	<%=items.getItem_name()%><br>

	<img src = "itemImage/<%=items.getPicture()%>" alt="商品画像" width="300" height="200"><br>
	
	<p>価格:</p><%=items.getPrice()%><br>
    <p>数量</p><%=items.getQuantity()%>
	
    <p>カートに入れる</p>	
	
	
	
	
	<%
	}
	%>






<p>戻る</p>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>