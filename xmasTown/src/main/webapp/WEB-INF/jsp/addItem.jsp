<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="css/style_admin.css">
	<style>
		p  {
			text-align: left;
		}
 	</style>
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<div class="login-container">
		<h1>商品新規登録</h1>
		<h2>商品情報</h2>
		<form action="AddItemServlet" method="post" enctype="multipart/form-data">
			<div class="form-section">
				<p>カテゴリ:
					<select name="category">
						<option value="ツリー">ツリー</option>
						<option value="オーナメント">オーナメント</option>
						<option value="オブジェ">オブジェ</option>
						<option value="リース">リース</option>
						<option value="オルゴール">オルゴール</option>
						<option value="リボン">リボン</option>
						<option value="カード">カード</option>
						<option value="アドベントカレンダー">アドベントカレンダー</option>
						<option value="ガーランド">ガーランド</option>
					</select>
				</p>
			</div>
			<div class="form-section">
				<p>商品名:<input type="text" name="itemName"></p>
			</div>
			<div class="form-section">
				<p>価格:<input type="text" name="price"></p>
			</div>
			<div class="form-section">
				<p>商品コメント:<textarea name="comment"></textarea></p>
			</div>
			<div class="form-section">
				<p>個数:<input type="number" name="stock" min="0" max="99">	</p>
			</div>
			<div class="form-section">
				<p>画像:<input type="file" name="picture"></p>
			</div>
			<p>公開/非公開:</p>
			<p>
				<input type="radio" name="releaseFlag" value="0" checked>公開
				<input type="radio" name="releaseFlag" value="1">非公開
			</p>
			<input type="submit" value="商品登録">
		</form>
		<p><a href="AdminLoginServlet">戻る</a></p>
	</div>
</body>
</html>