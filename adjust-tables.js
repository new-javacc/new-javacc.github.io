tables();

function tables() {
	var tables = document.getElementsByClassName("categories");
	for (i = 0; i < tables.length; i++) {
		tables[i].style.maxHeight = tables[i].clientHeight + "px";
		console.log(tables[i].clientHeight);
	}
}