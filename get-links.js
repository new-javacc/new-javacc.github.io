document.onload = loadLinks();

function loadLinks() {
	var pdfFilesDirectory = './grammars/';

	// get auto-generated page 
	$.ajax({url: pdfFilesDirectory}).then(function(html) {
	    // create temporary DOM element
	    var document = $(html);

	    // find all links ending with .pdf 
	    document.find('a[href$=.jj]').each(function() {
	        var pdfName = $(this).text();
	        var pdfUrl = $(this).attr('href');
	        console.log(pdfUrl);
	        // do what you want here 
	    })
	});
}