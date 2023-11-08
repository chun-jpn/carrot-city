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

	<%=items.getPicture()%><br>
	<%=items.getItem_name()%><br>
	<%=items.getPrice()%><br>

	<%
	}
	%>



	<p>
		<a href="WelcomServlet">TOPへ</a>
	</p>
</body>
</html>