<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="dao.itemsDAO" --%>
<%@ page import="java.util.List"%>
<%@ page import="model.Items"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
// 1ページあたりのアイテム数
int itemsPerPage = 20;
%>

<%
List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
String item_name = request.getParameter("item_name");
// 現在のページ番号 (デフォルト: ページ1)
int currentPage = 1;
String pageParam = request.getParameter("page");
if (pageParam != null && !pageParam.isEmpty()) {
	currentPage = Integer.parseInt(pageParam);
}
// 表示するアイテムの範囲を計算
int startIdx = (currentPage - 1) * itemsPerPage;
int endIdx = Math.min(startIdx + itemsPerPage, itemsList.size());
%>
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
			for (int i = startIdx; i < endIdx; i++) {
			%>
			<div class="item">
				<a
					href="<%=request.getContextPath()%>/ItemDetailServlet?item_id=<%=itemsList.get(i).getItem_id()%>"
					class="image_link"> <img
					src="itemImage/<%=itemsList.get(i).getPicture()%>" alt="商品画像" width="320"
					height="240" id="img22">
				</a><br>

				<%=itemsList.get(i).getItem_name()%><br> <b>&yen;<fmt:formatNumber
						value="<%=itemsList.get(i).getPrice()%>" type="currency" currencySymbol=""
						maxFractionDigits="0" /></b><br>
			</div>
			<%
			}
			%>
		</div>
				<!-- ページングのリンクを表示 -->
		<div class="paging">
			<%
			if (currentPage > 1) {
			%>
			<a
				href="ItemSearchServlet3?item_name=<%=item_name%>&page=<%=currentPage - 1%>">前のページ</a>
			<%
			}
			%>

			<%
			for (int i = 1; i <= Math.ceil((double) itemsList.size() / itemsPerPage); i++) {
			%>
			<%
			if (i == currentPage) {
			%>
			<%=i%>
			<%
			} else {
			%>
			<a href="ItemSearchServlet3?item_name=<%=item_name%>&page=<%=i%>"><%=i%></a>
			<%
			}
			%>
			<%
			}
			%>

			<%
			if (currentPage < Math.ceil((double) itemsList.size() / itemsPerPage)) {
			%>
			<a
				href="ItemSearchServlet3?item_name=<%=item_name%>&page=<%=currentPage + 1%>">次のページ</a>
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