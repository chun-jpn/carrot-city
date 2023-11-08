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
	<title>CHRISTMAS TOWN</title>
</head>
<body>
	<header class="header">
	    <div class="logo">
	      <a href="index.html"><img src="image/ロゴ.svg" alt="CHRISTMAS TOWN"></a>
	    </div>
	    <div class="header-right">
		    <form action="ItemSearchServlet" class="search-form">
			    <label>
			        <input type="text" placeholder="商品名">
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
	 
<!-- TOP -->

	<div class="top">
		 <div class="grid">
			  <div class="grid_item" id="gi1"><img src="image/010643_01.jpg"></div>
			  <div class="grid_item" id="gi2"><img src="image/010626_01.jpg"></div>
			  <div class="grid_item" id="gi3"><img src="image/010751_01.jpg"></div>
			  <div class="grid_item" id="gi4"><img src="image/010714_01.jpg"></div>
			  <div class="grid_item" id="gi5"><img src="image/010625_ct.jpg"></div>
		</div>
		<div class="scrolldown4"><span>Scroll</span></div>
		<div class="logo-top"><img src="image/ロゴ.svg" alt="Christmas Town"></div>
		<div class="logo-top-sp"><img src="image/ロゴ_sp.svg" alt="Christmas Town"></div>
	</div>
	
<main>
	<div class="maincopy">
		<h1>CHRISTMAS TOWNは<br>クリスマスグッズが<br class="sp_br">一年中買えるお店です</h1>
		<p>毎年欧米のトレンドを反映した<br class="sp_br">おしゃれなクリスマスグッズを、<br>
			世界中のブランドやメーカーから直輸入しています。<br><br>
			ヨーロッパならではの、クラシカルで高級感のある<br class="sp_br">クリスマスオーナメントやオブジェ、<br>
			米国ならではのスタイリッシュなクリスマスツリーや<br class="sp_br">独創的なデコレーションアイテム。<br>
			北欧風のナチュラルテイストのクリスマス雑貨から、<br>
			ファミリーで楽しめるかわいいグッズまで取り揃えています。</p>
	</div>
<!-- ランキング -->	
	<div class="ranking">
		<h2><span>Ranking</span></h2>
		<p class="ranking-sub">ランキング</p>
		
		<ul class="ranking-list">
		  <li class="rank1">
		  	<div class="zoom"><a href="#"><span class="mask"><img src="image/010625_ct.jpg"></span></a></div>
		  	<div class="maru" id="maru1"> <span>1</span></div>
		  	<div class="rank-name">ベアー＆ホースオーナメント</div>
		  	<div class="rank-price"><span>\1,045</span>（税込）</div>
		  </li>
		  <li>
		  	<div class="zoom"><a href="#"><span class="mask"><img src="image/010625_ct.jpg"></span></a></div>
		  	<div class="maru" id="maru2"> <span>2</span></div>
		  	<div class="rank-name">ベアー＆ホースオーナメント</div>
		  	<div class="rank-price"><span>\1,045</span>（税込）</div>
		  </li>
		  <li>
		  	<div class="zoom"><a href="#"><span class="mask"><img src="image/010625_ct.jpg"></span></a></div>
		  	<div class="maru" id="maru1"> <span>3</span></div>
		  	<div class="rank-name">ベアー＆ホースオーナメント</div>
		  	<div class="rank-price"><span>\1,045</span>（税込）</div>
		  </li>
		  <li>
		  	<div class="zoom"><a href="#"><span class="mask"><img src="image/010625_ct.jpg"></span></a></div>
		  	<div class="maru" id="maru2"> <span>4</span></div>
		  	<div class="rank-name">ベアー＆ホースオーナメント</div>
		  	<div class="rank-price"><span>\1,045</span>（税込）</div>
		  </li>
		  <li>
		  	<div class="zoom"><a href="#"><span class="mask"><img src="image/010625_ct.jpg"></span></a></div>
		  	<div class="maru" id="maru1"> <span>5</span></div>
		  	<div class="rank-name">ベアー＆ホースオーナメント</div>
		  	<div class="rank-price"><span>\1,045</span>（税込）</div>
		  </li>
		</ul>
	</div>
	
<!-- おすすめ -->
	<h2><span>Recommend</span></h2>
	<p class="recommend-sub">おすすめ</p>
	<ul class="recommend">
	  	 <li id="re-grid1">
		  	<div class="recommend-item" ><a href="#"><img src="image/010625_ct.jpg"></a>
			  	<div class="item-info">
				  	<div class="item-name">ベアー＆ホースオーナメント</div>
				  	<div class="item-price">\1,045[税込]</div>
			  	</div>
		  	</div>
		  </li>
		  <li id="re-grid2">
		  	<div class="recommend-item"><a href="#"><img src="image/010625_ct.jpg"></a>
			  	<div class="item-info">
				  	<div class="item-name">ベアー＆ホースオーナメント</div>
				  	<div class="item-price">\1,045[税込]</div>
			  	</div>
		  	</div>
		  </li>
		  <li id="re-grid3">
		  	<div class="recommend-item"><a href="#"><img src="image/010625_ct.jpg"></a>
			  	<div class="item-info">
				  	<div class="item-name">ベアー＆ホースオーナメント</div>
				  	<div class="item-price">\1,045[税込]</div>
			  	</div>
		  	</div>
		  </li>
		  <li id="re-grid4">
		  	<div class="recommend-item"><a href="#"><img src="image/010625_ct.jpg"></a>
			  	<div class="item-info">
				  	<div class="item-name">ベアー＆ホースオーナメント</div>
				  	<div class="item-price">\1,045[税込]</div>
			  	</div>
		  	</div>
		  </li>  
	</ul>
	<!-- カテゴリ -->
	<h2><span>Category</span></h2>
	<p class="category-sub">カテゴリ</p>
	<div class="category">
		<ul>
			<a href="ItemSearchServlet?category=ツリー"><li id="cate1"><img
				src="image/tree.svg">
					<div class="category-text">
						<div class="category-item">ツリー</div>
						<p>Tree</p>
					</div></li> <a href="ItemSearchServlet?category=オーナメント"><li id="cate2"><img
						src="image/ornament.svg">
					<div class="category-text">
						<div class="category-item">オーナメント</div>
						<p>Ornament</p>
					</div></li> <a href="ItemSearchServlet?category=オブジェ"><li id="cate1"><img
						src="image/object.svg">
					<div class="category-text">
						<div class="category-item">オブジェ</div>
						<p>Object</p>
					</div></li> <a href="ItemSearchServlet?category=リース"><li id="cate2"><img
						src="image/wreath.svg">
					<div class="category-text">
						<div class="category-item">リース</div>
						<p>Wreath</p>
					</div></li> <a href="ItemSearchServlet?category=オルゴール"><li id="cate1"><img
						src="image/musicbox.svg">
					<div class="category-text">
						<div class="category-item">オルゴール</div>
						<p>Music box</p>
					</div></li> <a href="ItemSearchServlet?category=リボン"><li id="cate2"><img
						src="image/ribbon.svg">
					<div class="category-text">
						<div class="category-item">リボン</div>
						<p>Ribbon</p>
					</div></li> <a href="ItemSearchServlet?category=カード"><li id="cate1"><img
						src="image/card.svg">
					<div class="category-text">
						<div class="category-item">カード</div>
						<p>Card</p>
					</div></li> <a href="ItemSearchServlet?category=アドベントカレンダー"><li id="cate2"><img 
						src="image/calendar.svg">
					<div class="category-text">
						<div class="category-item">アドベント<br class="sp_br">カレンダー</div>
						<p>Advent calendar</p>
					</div></li> <a href="ItemSearchServlet?category=ガーランド"><li id="cate1"><img 
						src="image/garland.svg">
					<div class="category-text">
						<div class="category-item">ガーランド</div>
						<p>Garland</p>
					</div></li>
			</ul>
	</div>
	
</main>	
<!--フッター-->
    <footer>
	    <img src="image/town.svg">
	        <div class="info">
	           <a href="index.html"><span>CHRISTMAS TOWN</span></a>
	            <ul class="nav-footer"> 
	               <li><a href="MypageServlet">マイページ</a></li>
	               <li><a href="ContactServlet">お問い合わせ</a></li>
	             </ul>
	          
	            <p>&copy;CHRISTMAS TOWN</p>
	        </div>        
    </footer>
    
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="css/js.js"></script>

</body>
</html>