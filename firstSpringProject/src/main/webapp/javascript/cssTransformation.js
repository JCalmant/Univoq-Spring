var under = document.getElementById("underHeader");
var flag = document.getElementById("flag");
var header = document.body.children[0];
var scrollWait = document.getElementById("scrollWait");
var inputResearch = document.createElement("input");
var loupeButton=document.getElementById("loupe");
window.onscroll = function() {menuScroll();};
loupeButton.onclick=function(){
    under.replaceChild(inputResearch,loupeButton);
    inputResearch.className="underHeaderNoP";
};
document.onclick = function(e) {
    if ( e.target != inputResearch && under.lastElementChild!=loupeButton && e.target != loupeButton) {
        under.replaceChild(loupeButton,inputResearch);
    }
};
function menuScroll() {
    if (document.body.scrollTop > header.offsetHeight || document.documentElement.scrollTop > header.offsetHeight) {
        under.className="fixed";
        flag.className="fixedFlag";
        scrollWait.className="scrollWait";
    }
    else {
        under.className="";
        flag.className="";
        scrollWait.className="";
    }
}