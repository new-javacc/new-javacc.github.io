var showing = false;

function showTutorials() {
	$('#tutorial-buttons').animate({height: "toggle"}, 500);
	showing = !showing;
	if (showing) {
		document.getElementsByClassName("thebutton")[7].innerHTML = "&#9660; Tutorials";
	}
	else {
		document.getElementsByClassName("thebutton")[7].innerHTML = "&#9654; Tutorials";
	}
}
