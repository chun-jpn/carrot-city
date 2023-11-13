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
<form action="AddItemServlet" method="post" enctype="multipart/form-data">
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
	<p>商品名:<input type="text" name="itemName"></p>
	<p>価格:<input type="text" name="price"></p>
	<p>商品コメント:
		<textarea name="comment"></textarea>
		<p>個数:
			<input type="number" name="stock" min="0" max="5">
		</p>
	</p>
	<p>画像:
		<input type="file" name="picture">
	</p>
	
	<p>公開/非公開:</p>
	<p>
		<input type="radio" name="releaseFlag" value="0" checked>公開
		<input type="radio" name="releaseFlag" value="1">非公開
	</p>
	<input type="submit" value="商品登録">
</form>
<p><a href="AdminLoginOKServlet">戻る</a></p>
</body>
</html>