/**
 * 
 */
  
//loginOKのアニメーション
const CLASSNAME = "-visible";
const TIMEOUT = 350;
const $target = $(".bg");

for (let i =0; i < 1; i++)  {
setInterval(() => {
  $target.addClass(CLASSNAME);

  setTimeout(() => {
    $target.clearInterval(CLASSNAME);
  }, TIMEOUT);
}, TIMEOUT*2);
}
