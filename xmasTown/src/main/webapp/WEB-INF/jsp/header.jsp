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

	<title>共通ヘッダー</title>
</head>
<body>
	<header class="header">
	    <div class="logo">
	      <a href="WelcomeServlet"><img src="image/ロゴ.svg" alt="CHRISTMAS TOWN"></a>
	    </div>
	    <div class="header-right">
		    <form action="<%= request.getContextPath() %>/ItemSearchServlet3" method="get" class="search-form">
			    <label>
			        <input type="text" name="item_name" placeholder="商品名">
			    </label>
			    <button type="submit" aria-label="検索"></button>
			</form>
			<nav class="nav"> 
		      <ul> 
		        <li id="login"><a href="LoginServlet">ログイン</a></li>
		        <li id="mypage"><a href="MypageServlet"><img src="image/mypage.svg" alt="マイページ" width="25px"></a></li>
		        <li id="cart"><a href="CartServlet"><img src="image/cart.svg" alt="カート" width="30px"></a></li>
		        <li id="mail"><a href="ContactServlet"><img src="image/mail.svg" alt="お問い合わせ" width="30px"></a></li>
		      </ul>
		    </nav>
	    </div>  
	 </header>
	<main>
	
	</main>

</body>
</html>