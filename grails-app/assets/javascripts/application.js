// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require skel
//= require main
//= require util
//= require soundmanager2
//= require page-player
//= require analytics
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}


soundManager.setup({
	  url: '../../swf/',
	  html5PollingInterval: 50
	});

	// demo only..
	function setTheme(sTheme) {
	  var o = document.getElementsByTagName('ul')[0];
	  o.className = 'playlist'+(sTheme?' '+sTheme:'');
	  return false;
	}
