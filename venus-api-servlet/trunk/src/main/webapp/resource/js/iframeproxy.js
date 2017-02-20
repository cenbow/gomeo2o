$(function() {
var hashurl =  window.location.hash;
var targetid = "frameWin"
if(hashurl!=""){
	targetid= hashurl.split("#")[1];
}
var proxy = $('<iframe id="proxy_iframe"  height="0" width="0" src="" style="display:none"></iframe>');
proxy.appendTo("body");
var target_width =  Math.max(document.body.scrollWidth,document.body.clientWidth);
var target_height =  Math.max(document.body.scrollHeight,document.body.clientHeight);
proxy.attr("src",bspUrl+"bsp/proxy#"+target_width+"|"+target_height+"|"+targetid);
});
var iframHeight = 0;
function resetIframeHeight(){
	var hashurl =  window.location.hash;
	var targetid = "frameWin"
	if(hashurl!=""){
		targetid= hashurl.split("#")[1];
	}
	$("#proxy_iframe").remove();
	var proxy = $('<iframe id="proxy_iframe"  height="0" width="0" src="" style="display:none"></iframe>');
	proxy.appendTo("body");
	var target_width =  Math.max(document.body.scrollWidth,document.body.clientWidth);
	var target_height =  Math.max(document.body.scrollHeight,document.body.clientHeight);
	//iframHeight = target_height;
	proxy.attr("src",bspUrl+"bsp/proxy#"+target_width+"|"+target_height+"|"+targetid);
}