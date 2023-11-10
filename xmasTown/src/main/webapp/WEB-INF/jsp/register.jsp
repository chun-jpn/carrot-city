<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_formframe.css">
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
				ユーザー名:<input type="text"  class="input-field" name="name"><br>
				住所:<input type="text"  class="input-field" name="address"><br>
				電話番号:<input type="text"  class="input-field" name="tel"><br>
				メールアドレス:<input type="text"  class="input-field" name="mail"><br>
				パスワード:<input type="password"  class="input-field" name="password"><br>
				<a><input type="submit" name="success"  value="決定"></a><br>
					<c:if test="${not empty requestScope.error}">
					<p style="color: red">${requestScope.error}</p>
					</c:if>
					<p><a href="WelcomeServlet">戻る</a></p>
			</form>
	</main>
	</div>
	<%@ include file = "footer.jsp" %>
</body>
</html>
