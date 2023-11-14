/**
 * 
 */
  
//loginOKのアニメーション
const CLASSNAME = "-visible";
const TIMEOUT = 400;
const $target = $(".bg");


setInterval(() => {
  $target.addClass(CLASSNAME);

  setTimeout(() => {
    $target.clearInterval(CLASSNAME);
  }, TIMEOUT);
}, TIMEOUT*3);

