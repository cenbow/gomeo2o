$(function(){
	if(window.util.query("type")==1){
		document.title = '未审核 - 话题回复';
	}else if(window.util.query("type")==2){
		document.title = '审核已通过 - 话题回复';
	}else if(window.util.query("type")==3){
		document.title = '审核未通过 - 话题回复';
	}
	var className = window.util.query("type") ==1 ? "" : "hide";
	
	var classNameHodsy = window.util.query("type") ==1 ? "hide" : "";
	
	var classNameNotThroughReason = window.util.query("type") ==3 ? "" : "hide";
	
	if(window.util.query("type")==1){
		$('#batchaudit').removeClass('hide');
		$('#Batchauditnot').removeClass('hide');
	}
	
	var topicBack={
			id:$("#exaTopicBack"),
			url: "../../../topicBack/findTopicBack",
			search:[{"name" : "topicBackContent","value" : encodeURI($("#topicBackContent").val())},{"name" : "type","value" : window.util.query("type")}],
			mData:[{"mData" : "id","sWidth" : "3%","class": "center sorting","bSearchable": false,"bStorable": false,render:function(data, type, row) {
					return '<input type="checkbox" id="checkbox" title="" value="'+data+'" name="check" />';
	        	  }},
	           {"mData" : "id","class": "center sorting"},
	           {"sWidth" : "80px","mData" : "createTime","class": "center sorting"},
	           {"sWidth" : "50px","mData" : "content","class": "center sorting"},
	           {"mData" : "pics","sWidth" : "15%","class": "center sorting",render:function (data, type, row) {
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
	           {"mData" : "auditUser", "class": "center sorting "+classNameHodsy+"",render:function(data, type, row){
	        	   	return row.auditUser+" "+row.auditTime;
	           }},
	           {"sWidth" : "90px","mData" : "notThroughReason", "class": "center sorting "+classNameNotThroughReason+""},
	           {"sWidth" : "157px","class": "center sorting "+className+" ","bSearchable": false,"bStorable": false, render:function (data, type, row) {
	                  return "<button type=\"button\" class=\"btn btn-success btn-sm\" data-id='"+row.id+"'>审核通过</button> <button type=\"button\" class=\"btn btn-danger btn-sm\" data-toggle=\"modal\" data-target=\"#myModal\" data-id='"+row.id+"'>审核不通过</button> ";  
	            }
	           }
	       	],
	       searchKey:'#search',
	       //外部挂载事件
	       externalEvents:[function(){
	   			//执行顶部事件
	   			window.util.bindType($(topicBack.searchKey),window.validate.click,function(event){
	   				window.search=[{"name" : "topicBackContent","value" : encodeURI($("#topicBackContent").val())},{"name" : "type","value" : window.util.query("type")}];
	   				//再次加载数据
	   				window.mx.initData(topicBack);
	   			});
	   	   },function(){
  			//批量审核通过
  			window.util.bindType($('#batchaudit'),window.validate.click,function(event){
	    		   window.params={
	    		      check:window.check,
	    		      egis:true,
	    		      singleton:false,
	    		      state:window.validate.egis,
	    		      auditUser:window.validate['name'],
	    		      auditUserId:window.validate['userId']
		    	   }
	    		   if(window.check.length>0){
	    			   window.util.post('../../../topicBack/egis',{check: JSON.stringify(window.params)},function(msg){
	    				   if(!msg.success){
	    					   alert(msg.message);
	    				   }else{
	    					  window.search=[{"name" : "topicBackContent","value" : encodeURI($("#topicBackContent").val())},{"name" : "type","value" : window.util.query("type")}];
	    	    			  window.mx.initData(topicBack);
	    				   }
	    			   });
	    		   }else{
	    			   alert("请选择回复话题");
	    		   }
  			});
   	 },function(){
   	   //审核通过
   	   window.util.bindType($(topicBack.id).find('button.btn-success'),window.validate.click,function(event){
   		   window.params={
   		      check:$(this).data('id'),
   		      egis:true,
   		      singleton:true,
   		      state:window.validate.egis,
   		      auditUser:window.validate['name'],   //审核人
   		      auditUserId:window.validate['userId']
	    	   }
   		   if($(this).data('id')!=undefined){
   			   window.util.post('../../../topicBack/egis',{check: JSON.stringify(window.params)},function(msg){
   				   if(!msg.success){
   					   alert(msg.message);
   				   }else{
   					   window.search=[{"name" : "topicBackContent","value" : encodeURI($("#topicBackContent").val())},{"name" : "type","value" : window.util.query("type")}];
   	    			   window.mx.initData(topicBack);
   				   }
   			   });
   		   }
   	   });
   	 },function(){
   		    //审核不通过和批量审核不通过
   		 	window.dangerSingleton=false;
   		 	window.dangerSingletonId="";
   		 	window.util.bindType($(topicBack.id).find('button.btn-danger'),window.validate.click,function(event){
   		 		window.dangerSingleton=true;
   		 		window.dangerSingletonId=$(this).data('id');
   		 	});
   		 
   		 	window.util.bindType($('#optionsRadios'),'keyup',function(){
   		 		$('#alertGroup').text($('#optionsRadios').val().length);
   		 	});
   		 	
   		 	$('#optionsRadios').val("");
   			//批量审核不通过
   			window.util.bindType($('#modal_qd'),window.validate.click,function(event){
   			   var radioValue="";
   			   $('.modal-body').find('input[type="radio"]').each(function(){
   				   if($(this).is(':checked')){
   					   radioValue=$(this).val();
   				   }
   			   });
   			   if(radioValue==""){
   				   alert("请选择不通过原因");
   				   return false;
   			   }else if(radioValue=="其它"&&$('#optionsRadios').val()==""){
   				   alert("请输入内容");
   				   return false;
   			   }
			   if($('#optionsRadios').val().length>15&&radioValue=="其它"){
				   alert("内容长度小于等于15");
				   return false;
			   }else if($('#optionsRadios').val().length<2&&radioValue=="其它"){
				   alert("内容最少输入2个字符");
				   return false;
			   }
   			   
	    		   window.params={
	    		      check:window.check,
	    		      egis:true,
	    		      singleton:true,
	    		      state:window.validate.auditDoesNotPass,
	    		      auditUser:window.validate['name'],
	    		      cuntent:$('#optionsRadios').val(),
	    		      radioValue:radioValue,
	    		      auditUserId:window.validate['userId']
		    	   }
	    		   
	    		   if(!window.dangerSingleton){
	    			   window.params['check']=window.check;
	    			   if(window.check.length==0){
	    				   alert("请先选择圈子");
	    				   return false;
	    			   }
	    			   window.params['singleton']=false;
	    		   }else{
	    			   window.params['check']=window.dangerSingletonId;
	    			   if(window.dangerSingletonId==''||window.dangerSingletonId==undefined){
		    			   alert("系统异常...");
		    			   return false;
		    		   }
	    		   }
   			   window.util.post('../../../topicBack/egis',{check: JSON.stringify(window.params)},function(msg){
   				   if(!msg.success){
   					   alert(msg.message);
   				   }else{
   					   window.search=[{"name" : "topicBackContent","value" : encodeURI($("#topicBackContent").val())},{"name" : "type","value" : window.util.query("type")}];
   	    			   window.mx.initData(topicBack);
   				   }
   			   });
   			});
    	 }]
	};
	//虚拟挂载搜索
	window.search=topicBack.search;
	//外部事件的挂载
	window.externalEvents=topicBack.externalEvents;
	//初始化
	window.mx.init(topicBack);
})