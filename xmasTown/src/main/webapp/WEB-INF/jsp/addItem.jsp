<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<h1>商品新規登録</h1>
<h2>商品情報</h2>
<form action="AddItemConfirmServlet" method="post">
	<p>商品番号:<input type="text"></p>
	<p>カテゴリ:
		<select name="category">
			<option value=0>ツリー</option>
			<option value=1>オーナメント</option>
			<option value=2>オブジェ</option>
			<option value=3>リース</option>
			<option value=4>オルゴール</option>
			<option value=5>リボン</option>
			<option value=6>カード</option>
			<option value=7>アドベントカレンダー</option>
			<option value=8>ガーランド</option>
		</select>
	</p>
	<p>商品名:<input type="text"></p>
	<p>価格:<input type="text"></p>
	<p>商品コメント:
		<input type="textarea" name="comment">
	</p>
	<p>画像:
		<input type="file" name="picture">
	</p>
	<p>個数:
		<input type="number" name="quantity" min="0" max="99">
	</p>
	<p>公開/非公開:</p>
	<p>
		<input type="radio" name="releaseFlag" value=0>公開
		<input type="radio" name="releaseFlag" value=1>非公開
	</p>
	<input type="submit" value="商品登録">
</form>
<p><a href="AdminLoginOKServlet">戻る</a></p>
</body>
</html>