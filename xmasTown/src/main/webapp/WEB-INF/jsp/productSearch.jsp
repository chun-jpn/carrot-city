<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List,model.Items"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<p
			style="font-size: 24px;>商品一覧</p>
    
<div class="items">
    <%List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");%>
    <%for (Items items : itemsList) {%>
    <div class="item">
    <a
        href="<%=request.getContextPath()%>/ProductDetailServlet?item_id=<%=items.getItem_id()%>" class="image_link">
        <img src="itemImage/<%=items.getPicture()%>" alt="商品画像" width="300"
        height="200"  id="img22">
    </a><br>
    <%=items.getItem_name()%><br>
    <b>&yen;<fmt:formatNumber value="<%=items.getPrice()%>"
						type="currency" currencySymbol="" maxFractionDigits="0" /></b><br>
    </div>
    <%}%>
</div>

    <p class="link-text">
        <a href="AdminLoginServlet" class="b">TOPへ</a>
    </p>
    </main>
	<%@ include file = "footer.jsp" %>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script src="css/js.js"></script>
</body>
</html>