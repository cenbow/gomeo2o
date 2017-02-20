$(function(){
	var topicBackLog={
			id:$("#exaTopicLog"),
			url: "../../../log/topicBackLog",
			search:[{"name" : "userId","value" : encodeURI($("#userId").val())}],
			mData:[
	           {"mData" : "topicBackId","class": "center sorting"},
	           {"sWidth" : "80px","mData" : "createTime","class": "center sorting"},
	           {"mData" : "content","class": "center sorting"},
	           {"mData" : "pics","class": "center sorting", render:function (data, type, row) {
	        	   var img = "<div>";
	        	   if(data!=null&&data!=""){
	        		   $.each(data.split(','),function(i,n){
	        			   img+="<img class='img-circle nav-user-img-xiala center-block imgtip' height='30' width='30' style='float:left;margin-left:2px' data-img='"+n+"' src='"+n+"'/>";
	        		   });
	        	   }
	        	   return img+"</div>";  
	           }},
	           {"mData" : "topicName","class": "center sorting"},
	           {"mData" : "createOperator", "class": "center sorting"},
	           {"mData" : "auditState", "class": "center sorting ", render:function (data, type, row) {
	                if(data===1){
	                	return "未审核";
	                }else if(data===2){
	                	return "审核通过";
	                }else if(data===3){
	                	return "审核未通过";
	                }  
	           }},
	           {"mData" : "auditTime", "class": "center sorting"},
	           {"mData" : "auditUser", "class": "center sorting"},
	           {"mData" : "auditUserState", "class": "center sorting", render:function (data, type, row) {
	                if(data===1){
	                	return "未审核";
	                }else if(data===2){
	                	return "审核通过";
	                }else if(data===3){
	                	return "审核未通过";
	                }  
	           }}
	       	],
	       searchKey:'#search',
	       externalEvents:[
	         //执行顶部事件
	         function(){
	    	   //再次加载数据
    			window.util.bindType($(topicBackLog.searchKey),window.validate.click,function(event){
    				window.search=[{"name" : "userId","value" : encodeURI($("#userId").val())}];
    				window.mx.initData(topicBackLog);
    			});
	         }
	       ]
	};
	//虚拟挂载搜索
	window.search=topicBackLog.search;
	//外部事件的挂载
	window.externalEvents=topicBackLog.externalEvents;
	//初始化
	window.mx.init(topicBackLog);
})