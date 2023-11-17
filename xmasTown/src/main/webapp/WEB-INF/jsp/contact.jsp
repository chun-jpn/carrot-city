<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_formframe.css">
<style>
.button-send {
    display       : inline-block;
	border-radius : 5%;          /* 角丸       */
	font-size     : 18pt;        /* 文字サイズ */
	text-align    : center;      /* 文字位置   */
	cursor        : pointer;     /* カーソル   */
	padding       : 10px 10px;   /* 余白       */
	background    : #c7c744;     /* 背景色     */

	color         : #3d3d17;     /* 文字色     */
	line-height   : 1em;         /* 1行の高さ  */
	transition    : .3s;         /* なめらか変化 */
	box-shadow    : 6px 6px 3px #666666;  /* 影の設定 */
	border        : 2px solid rgba(127, 127, 0, 0.77);    /* 枠の指定 */
}
.button-send:hover {
    box-shadow    : none;        /* カーソル時の影消去 */
    color         : rgba(127, 127, 0, 0.77);     /* 背景色     */
    background    : #ffffff;     /* 文字色     */
}
</style>
<title>CHRISTMAS TOWN</title>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<main>
	<div class="login-container">
		<h1  style="margin: 0;">CONTACT</h1>
		<form action="ContactServlet" class="input-field" method="post">
			Name:<input type="text" class="input-field" name="name"  placeholder="Name"><br>
			Mail:<input type="text" class="input-field" name="mail"  placeholder="Mail"><br>
			Message:<textarea name="detail" class="input-field" id="detail" cols="30" rows="10" required placeholder="Message" ></textarea>
			<label for="detail"   name="message"  placeholder="Message" id="example2"></label><br>
			<br>
				<input type="submit" value="send" class="button-send" style="background: #dbdb00;">
		</form>
		<p  class="link-text" style="margin: 0;">
			<a href="WelcomeServlet" class="b">TOPへ</a>
		</p>
	</main>
	<%@ include file = "footer.jsp" %>
</body>
</html>