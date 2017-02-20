$(function(){
	var twoTopicBackLog={
			id:$("#exaTwoTopicLog"),
			url: "../../../log/twoTopicBackLog",
			search:[{"name" : "userId","value" : encodeURI($("#userId").val())}],
			mData:[
	           {"mData" : "twoTopicBackId","class": "center sorting"},
	           {"mData" : "createTime","class": "center sorting"},
	           {"mData" : "content","class": "center sorting"},
	           {"mData" : "firstTopicId","class": "center sorting"},
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
    			window.util.bindType($(twoTopicBackLog.searchKey),window.validate.click,function(event){
    				window.search=[{"name" : "userId","value" : encodeURI($("#userId").val())}];
    				window.mx.initData(twoTopicBackLog);
    			});
	         }
	       ]
	};
	//虚拟挂载搜索
	window.search=twoTopicBackLog.search;
	//外部事件的挂载
	window.externalEvents=twoTopicBackLog.externalEvents;
	//初始化
	window.mx.init(twoTopicBackLog);
})