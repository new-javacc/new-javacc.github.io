// taken from http://stackoverflow.com/questions/325273/make-iframe-to-fit-100-of-containers-remaining-height
var buffer = 20; //scroll bar buffer
var iframe = document.getElementById('notes');
resizeIframe();

function pageY(elem) {
    return elem.offsetParent ? (elem.offsetTop + pageY(elem.offsetParent)) : elem.offsetTop;
}

function resizeIframe() {
    var height = document.documentElement.clientHeight;
    height -= pageY(document.getElementById('notes'))+ buffer ;
    height = (height < 0) ? 0 : height;
    document.getElementById('notes').style.height = height + 'px';
}

window.onresize = resizeIframe;