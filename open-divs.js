function toggleDiv(n) {
	var elems = document.getElementsByClassName("feat-info");
	var elem = elems[n - 1];
	$(elem).animate({height: "toggle"}, 500);
}