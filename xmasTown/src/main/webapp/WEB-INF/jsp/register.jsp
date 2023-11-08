<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<h1>新規登録</h1>
※ログイン時メールアドレスとパスワード必要<br>
※全ての項目を入力してください<br>
(一度登録したメールアドレスは再度登録不可)
<form action="RegisterServlet" method="post">
ユーザー名:<input type="text" name="name"><br>
住所:<input type="text" name="address"><br>
電話番号:<input type="text" name="tel"><br>
メールアドレス:<input type="text" name="mail"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" name="success"  value="決定"><br>
<c:if test="${not empty requestScope.error}">

        <p style="color: red">${requestScope.error}</p>

    </c:if>
<p><a href="WelcomeServlet">戻る</a></p>
</form>
</body>
</html>
