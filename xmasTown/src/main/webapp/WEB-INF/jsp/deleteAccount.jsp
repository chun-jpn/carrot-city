<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHRISTMAS TOWN</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<main>
<h2>退会確認</h2>
<p>退会する場合、メールアドレスとパスワードを入力して「退会する」ボタンを押してください</p>
<form action="DeleteAccountOKServlet" method="post">
<p>メールアドレス:<input type="text" name="checkMail"></p>
<p>パスワード:<input type="password" name="checkPass"></p>
<input type="submit" value="退会する">
<p><a href="MypageServlet">マイページに戻る</a></p>
</form>
</main>
<%@ include file = "footer.jsp" %>
</body>
</html>