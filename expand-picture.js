expand();

function expand() {
	var h1 = document.getElementById("alldropdowns").clientHeight;
	var h2 = document.getElementById("logo").clientHeight;
	document.getElementById("logo").style.paddingBottom = h1 - h2 + "px";
}