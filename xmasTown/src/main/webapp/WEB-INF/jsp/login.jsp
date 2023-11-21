<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <link rel="stylesheet" href="css/style_formframe.css">
        <title>CHRISTMAS TOWN</title>

    </head>
    <body>
        <%@ include file="header.jsp" %>
            <main>
                <div class="login-container">
                    <h1 class="change_h1">ログイン</h1><br>
                    <form action="LoginServlet" method="post">
                        <label for="email"><b>メールアドレス &nbsp;</b><input type="email" class="input-field" id="email"
                                placeholder="sample@example.com"></label><br>
                        <label for="password"><b>パスワード &nbsp;</b> <%--パスワード入力チェックを行うのであればinput-hintを表示 --%>
                                <%--<span id="user-password-hint" class="input-hint">※半角英数8文字以上</span> --%>
                                    <input type="password" class="input-field" id="password"
                                        placeholder="abcd1234"></label><br> <br> <a class="b"><input type="submit"
                                id="login-button" value="ログイン"></a><br> <br>
                        <a href="RegisterServlet" class="buttonBasic" class="b">新規会員登録</a>
                    </form><br>
                    <p class="link-text" style="margin: 0;">
                        <a href="WelcomeServlet" class="b">TOPへ</a>
                    </p>
                </div>
            </main>
            <%@ include file="footer.jsp" %>
    </body>
    </html>