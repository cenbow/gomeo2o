$(function(){
	
	var groupLog={
			id:$("#exaGroupLog"),
			url: "../../../log/editGroupLog",
			search:[{"name" : "userId","value" : encodeURI($("#userId").val())},{"name" : "dbtable","value" : "groupLog"}],
			mData:[
	           {"mData" : "id","class": "center sorting"},
	           {"mData" : "createTime","class": "center sorting"},
	           {"mData" : "groupName","class": "center sorting"},
	           {"mData" : "groupIcon","class": "center sorting", render:function (data, type, row) {
	                  return "<img class='img-circle nav-user-img-xiala center-block imgtip' height='30' width='30' data-img='"+data+"' src='"+data+"'/>";  
	           }},
	           {"mData" : "introduction","class": "center sorting"},
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
    			window.util.bindType($(groupLog.searchKey),window.validate.click,function(event){
    				window.search=[{"name" : "userId","value" : encodeURI($("#userId").val())},{"name" : "dbtable","value" : "groupLog"}];
    				window.mx.initData(groupLog);
    			});
	         }
	       ]
	};
	//虚拟挂载搜索
	window.search=groupLog.search;
	//外部事件的挂载
	window.externalEvents=groupLog.externalEvents;
	//初始化
	window.mx.init(groupLog);
})