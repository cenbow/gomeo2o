//监听Iframe高度自适应
window.parent.onscroll=function(){
    if(window.parent != null){
  	 //[注：兼容模式]
  	 	 var target_height =  document.body.clientHeight;
  	 	 if(target_height>iframHeight){
  	 		iframHeight = target_height;
  	 		resetIframeHeight();
  	 	 }
    }
}