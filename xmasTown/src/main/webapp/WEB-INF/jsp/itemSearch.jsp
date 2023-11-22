<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="dao.itemsDAO" --%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/items.css">
<link rel="stylesheet" href="css/style_formframe.css">
<style>
main {
	font-size: 18px;
}
</style>
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<div class="footerFixed">
	<%@ include file="header.jsp"%>
	<main>
		<h1>検索結果一覧</h1>
		<br>
<!--    <p style="font-size: 24px;">商品一覧</p> -->
		<%-- 	
	<% for (String item_name : request.getAttribute("itemsList")) { %>
	<%= item_name %>
	<% } %>	
--%>
		<div class="items">

			<%
			List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
			%>

			<%
			for (Items items : itemsList) {
			%>
			<div class="item">
				<a
					href="<%=request.getContextPath()%>/ItemDetailServlet?item_id=<%=items.getItem_id()%>"
					class="image_link"> <img
					src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="320"
					height="240" id="img22">
				</a><br>

				<%=items.getItem_name()%><br> <b>&yen;<fmt:formatNumber
						value="<%=items.getPrice()%>" type="currency" currencySymbol=""
						maxFractionDigits="0" /></b><br>
			</div>
			<%
			}
			%>
		</div>


		<p class="link-text">
			<a href="WelcomeServlet" class="b">TOPへ</a>
		</p>
	</main>
	<%@ include file="footer.jsp"%>
	</div>
	<script src="css/js.js"></script>
</body>
</html>