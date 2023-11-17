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
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/responsive.css">
	<%--<link rel="stylesheet" href="css/style_formframe.css"> --%>
	<link rel="stylesheet" href="css/style_admin.css">
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<% String category = items.getCategory(); %>
	<% String itemName = items.getItem_name(); %>
	<% int price = items.getPrice(); %>
	<% String comment = items.getComment(); %>
	<% int stock = items.getStock(); %>
	<% int releaseFlag = items.getRelease_flag(); %>
	<% String picture = items.getPicture(); %>
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
	<div class="login-container">
		<h1>商品詳細</h1>
		<h2>商品変更・削除</h2>
		<form action="ProductChangeServlet" method="post" enctype="multipart/form-data">
		    <div class="form-section">
			    <p>カテゴリ:
					<select name="category">
						<option value="ツリー" <%= category.equals("ツリー") ? "selected" : "" %>>ツリー</option>
						<option value="オーナメント" <%= category.equals("オーナメント") ? "selected" : "" %>>オーナメント</option>
						<option value="オブジェ" <%= category.equals("オブジェ") ? "selected" : "" %>>オブジェ</option>
						<option value="リース" <%= category.equals("リース") ? "selected" : "" %>>リース</option>
						<option value="オルゴール" <%= category.equals("オルゴール") ? "selected" : "" %>>オルゴール</option>
						<option value="リボン" <%= category.equals("リボン") ? "selected" : "" %>>リボン</option>
						<option value="カード" <%= category.equals("カード") ? "selected" : "" %>>カード</option>
						<option value="アドベントカレンダー" <%= category.equals("アドベントカレンダー") ? "selected" : "" %>>アドベントカレンダー</option>
						<option value="ガーランド" <%= category.equals("ガーランド") ? "selected" : "" %>>ガーランド</option>
					</select>
			    </p>
		    </div>
		    <div class="form-section">
			    <p>
			        商品名:<input type="text" name="itemName" value="<%= itemName %>">
			    </p>
		    </div>
		    <div class="form-section">
			    <p>
			        商品価格:<input type="number" name="price" value="<%= price %>">
			    </p>
		    </div>
		    <div class="form-section">
			    <p>
			        コメント:<textarea name="comment"><%= comment %></textarea>
			    </p>
		    </div>
		    <div class="form-section">
			    <p>
			        在庫数:<input type="number" name="stock" min="0" max="99" value="<%= stock %>">
			    </p>
		    </div>
		    <div class="form-section">
		    <p>画像:<input type="file" name="picture"></p>
			    <p>
			        <img src="itemImage/<%= picture %>" alt="商品画像" width="300" height="200">
			    </p>
			
		    </div>
		    <p>
				<input type="radio" id="public" name="releaseFlag" value="0" <%= releaseFlag == 0 ? "checked" : "" %>>
				<label for="public">公開</label>
				<input type="radio" id="private" name="releaseFlag" value="1" <%= releaseFlag == 1 ? "checked" : "" %>>
				<label for="private">非公開</label>
			</p>
			<input type="submit" value="変更">
		</form>

		<form action="ProductDeleteServlet" method="GET">
			<input type="submit" value="削除">
		</form>

		<p>
			<a href="AdminLoginServlet">TOPへ</a>
		</p>
	</div>
</body>
</html>