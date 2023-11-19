<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Carts"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
List<Carts> cartsList = (ArrayList<Carts>) session.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_formframe.css">
<link rel="stylesheet" href="css/cart.css">
<link rel="stylesheet" type="text/css" href="css/items.css">
<style>
main {
	font-size: 20px;
}
</style>
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<main>
		<h1 class="change_h1">ショッピングカート</h1>
		<table class="table_box" style="border: 2px #808080 solid;" align="center">
			<thead>
				<tr class="thead">
					<th>商品画像</th>
					<th>商品名</th>
					<th>価格</th>
					<th>数量</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<%
			int totalPrice = 0;
			for (Carts cartItem : cartsList) {
				totalPrice += cartItem.getPrice() * cartItem.getQuantity();
			%>
			<tr class="line">
				<td data-label="商品画像" width="200">
					<img src="itemImage/<%=cartItem.getPicture()%>" alt="商品画像"
					width="150px" height="150px">
				</td>
				<td data-label="商品名" width="350">
					<%=cartItem.getItem_name()%>
				</td> <%-- style="font-size: 16px;" --%>
				<div>
				<td data-label="価格" width="130">&yen;<fmt:formatNumber 
						value="<%=cartItem.getPrice()%>"
						type="currency" currencySymbol="" maxFractionDigits="0" /></td>
						
				<form action="ChangeCartServlet" method="post">
					<input type="hidden" name="cart_id"
						value="<%=cartItem.getCart_id()%>">
						<input type="hidden" name="item_id" 
						value="<%=cartItem.getItem_id()%>">

				<td data-label="数量" width="50" >
					<div class="spinner-container">
  						<span class="spinner-sub disabled">-</span>
						<input type="number" class="spinner" name="quantity" 
						value="<%=cartItem.getQuantity()%>" 
						min="1" max="99">
					  	<span class="spinner-add">+</span>
					 </div>					
				</td>
				<td width="120">
					<input type="submit" value="数量変更" class="btn">
				</td>
				</form>
				
				<form action="DeleteCartServlet" method="get">
					<input type="hidden" name="cart_id"
						value="<%=cartItem.getCart_id()%>">
					<input type="hidden" name="item_id" 
						value="<%=cartItem.getItem_id()%>">
				<td>
				<input type="submit" value="削除" class="btn--orange">
				</td>
				</form>
			</tr>
			<%
			}
			%>
		</table>
		<br>
			
			<hr width="61%" noshade>
			<div class="space">		
			<p>
				合計金額: <b style="font-size: 24px;">&yen;<fmt:formatNumber 
				 		value="<%=totalPrice%>" type="currency" currencySymbol="" maxFractionDigits="0" />
				 		</b>
			</p>
			<td>	
			<a href="OrderServlet" class="button-049">購入決定</a><br> 
			<a href="WelcomeServlet" class="button-063">買い物を続ける</a>
			</div>
	</main>
	<%@ include file="footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
	// スピンボタンのjs
	$(function() {
		  $('.spinner').each(function() {
		    var el  = $(this);
		    var add = $('.spinner-add');
		    var sub = $('.spinner-sub');

		    // substract
		    el.parent().on('click', '.spinner-sub', function() {
		      if (el.val() > parseInt(el.attr('min'))) {
		        el.val(function(i, oldval) {
		          return --oldval;
		        });
		      }
		      // disabled
		      if (el.val() == parseInt(el.attr('min'))) {
		        el.prev(sub).addClass('disabled');
		      }
		      if (el.val() < parseInt(el.attr('max'))) {
		        el.next(add).removeClass('disabled');
		      }
		    });

		    // increment
		    el.parent().on('click', '.spinner-add', function() {
		      if (el.val() < parseInt(el.attr('max'))) {
		        el.val(function(i, oldval) {
		          return ++oldval;
		        });
		      }
		      // disabled
		      if (el.val() > parseInt(el.attr('min'))) {
		        el.prev(sub).removeClass('disabled');
		      }
		      if (el.val() == parseInt(el.attr('max'))) {
		        el.next(add).addClass('disabled');
		      }
		    });
		  });
		});
	</script>
</body>
</html>