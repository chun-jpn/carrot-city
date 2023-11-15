<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_formframe.css">
<link rel="stylesheet" type="text/css" href="css/style_mypage.css">
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<div class="login-container">
		<h1>新規登録</h1>
				※ログイン時メールアドレスとパスワード必要<br>
				※全ての項目を入力してください<br>
				(一度登録したメールアドレスは再度登録不可)
			<form action="RegisterServlet" method="post">
				<div class="left">
					<p><b>ユーザー名: &nbsp;</b><input type="text"  class="input-field" name="name" placeholder="ユーザー名"></p>
					<p><b>住所: &nbsp;</b><input type="text"  class="input-field" name="address" placeholder="〇〇県～"></p>
					<p><b>電話番号: &nbsp;</b><input type="text"  class="input-field" name="tel" placeholder="0000000000 or 000-000-0000"></p>
					<p><b>メールアドレス: &nbsp;</b><input type="text"  class="input-field" name="mail" placeholder="メールアドレス"></p>
					<p><b>パスワード: &nbsp;</b><input type="password"  class="input-field" name="password" placeholder="oooo"></p>
						<input type="submit" name="success"  value="決定" id="button_solid017">
						<br>
					<c:if test="${not empty requestScope.error}">
					<p style="color: red">${requestScope.error}</p>
					</c:if>
				</div>
					<p class="link-text">
						<a href="WelcomeServlet">戻る</a>
					</p>
			</form>
	</main>
	</div>
	<%@ include file = "footer.jsp" %>
</body>
</html>
