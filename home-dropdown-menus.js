var current_open = 0;
var heights = new Array();
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */

window.onload = function() {
  for (i = 0; i < document.getElementsByClassName("dropdown").length; i++) {
    document.getElementById("myDropdown" + (i + 1)).style.display = "block";
    heights[i] = document.getElementById("myDropdown" + (i + 1)).offsetHeight;
    document.getElementById("myDropdown" + (i + 1)).style.display = "none";
  }
  i = 0;
  console.log("Loaded heights");
}

function myFunction(n) {
  var theheight = heights[n - 1];
  var buttons = document.getElementsByClassName("dropdown");
  var numButtons = buttons.length;
  for (i = 0; i < numButtons; i++) {
    if (i == n - 1) continue;
    // if (buttons[i].offsetHeight == 0) continue;
    // document.getElementById("myDropdown" + (i + 1)).style.height = "0px";
  }
  console.log("toggled button " + n + " with height " + theheight);
  $('myDropdown' + n).animate({height: theheight + "px"}, 500, function() {
    document.getElementById("myDropdown" + n).style.display = "block";
  });
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn') && !event.target.matches('.drpdntext')) {
    if (current_open == 0) return;
    if (document.getElementById("myDropdown" + current_open).classList.contains("show")) myFunction(current_open);
  }
};