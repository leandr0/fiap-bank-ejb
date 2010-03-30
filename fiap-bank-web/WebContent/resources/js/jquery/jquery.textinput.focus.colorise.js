// Colorise all text/password input boxes on a page
// License: http://www.gnu.org/licenses/gpl.txt
// Homepage: http://blog.leenix.co.uk/2009/07/jquery-onfocusonblur-text-box-color.html

var gotFocusColor = '#FCFFC5'; // background color when input is selected
var lostFocusColor = '#FFFFFF'; // background color to return to when focus is lost

j(document).ready(function(){
	colorizeInput();
});


function colorizeInput(){
	
	j('input:[type=text], input:[type=password]').focus(function () {
		this.style.background=gotFocusColor;
	});
	
	j('input:[type=text], input:[type=password]').blur(function () {
		this.style.background=lostFocusColor;
	});		
}

