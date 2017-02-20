/**
 * 使用flash插件来实现复制内容到剪贴板中
 */
function init(btnid, containerid,text,name) {
        	var clip = null;
        	ZeroClipboard.setMoviePath("js/zclip/ZeroClipboard.swf");
        	clip = new ZeroClipboard.Client();
        	clip.setHandCursor(true);
        	clip.setCSSEffects(true);
        	clip.addEventListener('mouseDown', function (client) {
        	    clip.setText(text);
        	});
        	clip.addEventListener('complete', function (client, text) {
        		showMsg("已将当前列表页中的"+name+"批量复制到【剪贴板】中!");                
        	});
        	clip.glue(btnid, containerid);
        	
        	/*$("#"+btnid).attr("onmouseover","");*/
        } 

//判断是否安装flash插件
function isFlash(){
	var isIE = !-[1,];
    if(isIE){
    	try{
    		var swf1 = new ActiveXObject('ShockwaveFlash.ShockwaveFlash');
    		if(swf1 == undefined){
    			return false;
    		}else{
    			return true;
    		}   
   		}catch(e){
   			alert("出错了……");
   			return false;
   		}
    }else{
    	try{
    		var swf2 = navigator.plugins['Shockwave Flash'];
    		if(swf2 == undefined){
    			return false;
    		}else{
    			return true;
    		}
    	}catch(e){
    		alert("出错了……");
    		return false;
    	}
    }
}