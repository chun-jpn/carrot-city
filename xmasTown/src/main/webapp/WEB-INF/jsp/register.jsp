<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style_formframe.css">
        <link rel="stylesheet" type="text/css" href="css/style_mypage.css">
        <title>CHRISTMAS TOWN</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
            <main>
                <div class="login-container">
                    <h1 class="change_h1">新規登録</h1>
                    <%--※ログイン時メールアドレスとパスワード必要<br> ※全ての項目を入力してください<br>
                        (一度登録したメールアドレスは再度登録不可) --%>
                        <form action="RegisterServlet" method="post">
                            <div class="left">
                                <p>
                                    <label class="required" for="name"><b>名前 &nbsp;</b></label><input type="text"
                                        class="input-field" id="name" placeholder="山田太郎">
                                </p>
                                <p>
                                    <label class="required" for="address"><b>住所 &nbsp;</b></label><br>
                                    <input type="text" class="input-field" id="address"
                                        placeholder="岐阜県各務原市テクノプラザ1丁目1番地">
                                </p>
                                <p>
                                    <label class="required" for="phone-number"><b>電話番号
                                            &nbsp;</b></label><br>
                                    <%--全角 /半角チェックを行うのであればinput-hintを表示 --%>
                                        <%--<span id="user-phone-number-hint" class="input-hint">※半角で入力してください</span>
                                            --%>
                                            <input type="tel" class="input-field" id="phone-number"
                                                placeholder="080xxxxxxxx">
                                </p>
                                <p>
                                    <label class="required" for="email"><b>メールアドレス &nbsp;</b></label>
                                    <br> <input type="email" class="input-field" id="email"
                                        placeholder="sample@example.com"><br> <span id="user-email-hint"
                                        class="input-hint">※登録済のメールアドレスは使用不可</span>
                                </p>
                                <p>
                                    <label class="required" for="password"><b>パスワード &nbsp;</b></label>
                                    <%--パスワード入力チェックを行うのであればinput-hintを表示 --%>
                                        <%--<br><span id="user-password-hint" class="input-hint">※半角英数8文字以上</span> --%>
                                            <input type="password" class="input-field" id="password"
                                                placeholder="abcd1234">
                                </p>
                                <input type="submit" name="success" value="決定" id="button_solid017">
                                <br>
                                <c:if test="${not empty requestScope.error}">
                                    <p style="color: red">${requestScope.error}</p>
                                </c:if>
                            </div>
                        </form>
                        <p class="link-text" style="margin: 0;">
                            <a href="WelcomeServlet"  class="b">戻る</a>
                        </p>
                </div>
            </main>
            <%@ include file="footer.jsp" %>
    </body>
    </html>