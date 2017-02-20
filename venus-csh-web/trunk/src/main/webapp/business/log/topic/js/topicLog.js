$(function(){
	var topicLog={
			id:$("#exaTopicLog"),
			url: "../../../log/topicLog",
			search:[{"name" : "userId","value" : encodeURI($("#userId").val())}],
			mData:[
	           {"mData" : "topicId","class": "center sorting"},
	           {"mData" : "createTime","class": "center sorting"},
	           {"mData" : "topicName","class": "center sorting"},
	           {"mData" : "content","class": "center sorting"},
	           {"mData" : "topicPic","class": "center sorting", render:function (data, type, row) {
	        	   var img = "<div>";
	        	   if(data!=null&&data!=""){
	        		   $.each(data.split(','),function(i,n){
	        			   img+="<img class='img-circle nav-user-img-xiala center-block imgtip' height='30' width='30' style='float:left;margin-left:2px' data-img='"+n+"' src='"+n+"'/>";
	        		   });
	        	   }
	        	   return img+"</div>";  
	           }},
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
    			window.util.bindType($(topicLog.searchKey),window.validate.click,function(event){
    				window.search=[{"name" : "userId","value" : encodeURI($("#userId").val())}];
    				window.mx.initData(topicLog);
    			});
	         }
	       ]
	};
	//虚拟挂载搜索
	window.search=topicLog.search;
	//外部事件的挂载
	window.externalEvents=topicLog.externalEvents;
	//初始化
	window.mx.init(topicLog);
})