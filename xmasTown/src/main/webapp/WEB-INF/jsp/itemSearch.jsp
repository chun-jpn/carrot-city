<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="dao.itemsDAO" --%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<h1>検索結果一覧</h1>
	<p>商品一覧</p>
	<%-- 	
	<% for (String item_name : request.getAttribute("itemsList")) { %>
	<%= item_name %>
	<% } %>	
--%>

	<%
	List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
	%>
	<%
	for (Items items : itemsList) {
	%>
	<a href="<%=request.getContextPath()%>/ItemDetailServlet?item_id=<%=items.getItem_id()%>">
	<img src = "itemImage/<%=items.getPicture()%>" alt="商品画像" width="300" height="200"></a><br>
 	
 	<%=items.getItem_name()%><br>

	<%=items.getPrice()%><br>

	<%
	}
	%>



	<p>
		<a href="WelcomeServlet">TOPへ</a>
	</p>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>