window.onload = function() {
	var elements = document.getElementsByClassName("bottomhalf")[0].getElementsByTagName("a");
	for (var i = 0; i < elements.length; i++) {
		console.log(elements[i].href === "");
		if (elements[i].href === "") {
			elements[i].style.color = "red";
		}
		else {
			elements[i].style.color = "#267f00";
			elements[i].style.transition = "color 0.5s";
		}
	}
}