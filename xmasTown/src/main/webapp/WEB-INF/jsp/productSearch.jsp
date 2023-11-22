<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,model.Items"%>
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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" href="css/responsive.css">
<link rel="stylesheet" href="css/items.css">
<link rel="stylesheet" href="css/style_formframe.css">
<link rel="stylesheet" href="css/style_admin.css">
<style>
main {
	font-size: 18px;
}
</style>
<title>CHRISTMAS TOWN</title>
</head>
<body>

	<main>
		<h1>検索結果一覧</h1>
		<p style="font-size: 24px;">商品一覧</p>

		<div class="items">
			<%
			for (int i = startIdx; i < endIdx; i++) {
			%>
			<%--     <%List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");%>
    <%for (Items items : itemsList) {%>  --%>
			<div class="item">
				<a
					href="<%=request.getContextPath()%>/ProductDetailServlet?item_id=<%=itemsList.get(i).getItem_id()%>"
					class="image_link"> <img
					src="itemImage/<%=itemsList.get(i).getPicture()%>" alt="商品画像"
					width="320" height="240" id="img22">
				</a><br>
				<%=itemsList.get(i).getItem_name()%><br> <b>&yen;<fmt:formatNumber
						value="<%=itemsList.get(i).getPrice()%>" type="currency"
						currencySymbol="" maxFractionDigits="0" /></b><br>
			</div>
			<%}%>
		</div>


		<!-- ページングのリンクを表示 -->
		<div class="paging">
			<%
			if (currentPage > 1) {
			%>
			<a
				href="ProductSearchServlet?item_name=<%=item_name%>&page=<%=currentPage - 1%>">前のページ</a>
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
			<a href="ProductSearchServlet?item_name=<%=item_name%>&page=<%=i%>"><%=i%></a>
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
				href="ProductSearchServlet?item_name=<%=item_name%>&page=<%=currentPage + 1%>">次のページ</a>
			<%
			}
			%>
		</div>


		<p class="link-text">
			<a href="AdminLoginServlet" class="b">TOPへ</a>
		</p>
	</main>
</body>
</html>