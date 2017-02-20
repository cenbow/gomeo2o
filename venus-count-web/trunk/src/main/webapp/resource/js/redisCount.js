/**
 * 统计redis数公共JS
 * 
 * 
 * 
 * 
 * 勿动
 */
$(function(){
	var pathname = window.document.location.pathname;
	$('a[href=#modal]').each(function(){
		 var that = $(this);
		 var disabled = true;
		 var params={
			check:that.data('check')
		 };
	     customopen($(this),false,false,'.close',function(){
	    	 $.ajax({
	    		type:'post',
	    		dataType:"json",
	    		url:'check',
	    		timeout : 3000,
	    		data: $.param(params),
	    		cache:false,
	    	    beforeSend:function(){},
	    		success:function(msg){
	    			if(msg.flag>0){
	    				disabled=false;
	    			}
	    		},
	    		complete:function(){},
	    	    error:function(){
	    	    	alert("系统异常");
	    	    }
	    	 });
	     },function(){
	    	var params="";
	    	$('#modal .bs-example-form').data('action',that.data('url'));
	    	$('#modal #interface').val(that.data('url'));
	    	$('#modal .title').text(that.text());
	    	$('#modal #params').show();
	    	$('#modal .progress-striped').addClass('paddingTop');
	    	$('#modal #params').empty();
	    	$('#modal #leadResult').empty();
	    	$('#modal #leadLoad').empty();
	    	if(!!that.data('explain')){
	    		var toParmas=that.data('explain').split(';');
	    		$.each(toParmas,function(i,n){
		    		$('#modal #leadLoad').append("<span class=\"lead\" style=\"font-size: 18px;\">"+n+"</span><br>");
		    	});
	    	}
	    	if(!!that.data('parmas')){
	    		var toParmas=that.data('parmas').split('&');
		    	$.each(toParmas,function(i,n){
		    		params="";
		    		params="<div class=\"input-group\" style=\"margin-bottom: 7px;\" ><span class=\"input-group-addon\">"+n.split('=')[0]+"</span><input type=\"text\" class=\"form-control\" data-params=\""+n.split('=')[0]+"\" value=\""+n.split('=')[1]+"\"  placeholder=\"请适时填写\"></div>";
		    		$('#modal #params').append(params);
		    	});
	    	}else{
	    		$('#modal #params').hide();
	    		$('#modal .progress-striped').removeClass('paddingTop');
	    	}
	    	if(disabled){
	    		$('#execute').show();
	    		$('#preventExecute').hide();
	    	}else{
	    		$('#execute').hide();
	    		$('#preventExecute').show();
	    	}
	    	
	    	$('#execute').unbind('click').bind('click',function(){
	    		params={};
	    		var flag=false;
	    		if(!!that.data('parmas')){
	    			$('#params').find('input').each(function(){
	    				if($(this).val()){
	    					params[''+$(this).data('params')+'']=$(this).val();		
	    				}else{
	    					flag=true;
	    				}
	    			});
	    		}
	    		if(flag){
	    			$('#leadResult').text("参数不全,请填写");
	    		}else{
	    			$('#execute').hide();
		    		$('#preventExecute').show();
		    		$.ajax({
			    		type:'post',
			    		url:''+that.data('url')+'',
			    		timeout : 3000,
			    		data: $.param(params),
			    		cache:false,
			    	    beforeSend:function(){},
			    		success:function(msg){
			    			$('#leadResult').text(msg);
			    			$('#execute').show();
				    		$('#preventExecute').hide();
			    		},
			    		complete:function(XMLHttpRequest,status){
			    			if(status=='timeout'){
			    				$('#leadResult').text("请求超时");
			    			}
			    		},
			    	    error:function(XMLHttpRequest,status){
			    	    	$('#leadResult').text("系统异常");
			    	    }
			    	 });
	    		}
	    	});
	     },function(){
	    	
	     });
	 });
});