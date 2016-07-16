var down = new Array();

window.onload = function() {
	for (i = 0; i < document.getElementsByClassName("feat-info").length; i++) {
		down[i] = false;
	}
}

function toggleDiv(n) {
	down[n - 1] = !down[n - 1];
	var elems = document.getElementsByClassName("feat-info");
	var elem = elems[n - 1];
	$(elem).animate({height: "toggle"}, 500);
	if (down[n - 1]) document.getElementsByClassName("arrow")[n - 1].innerHTML = "&#9660;";
	else document.getElementsByClassName("arrow")[n - 1].innerHTML = "&#9654;";
}