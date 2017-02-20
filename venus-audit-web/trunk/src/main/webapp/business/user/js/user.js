$(function(){
	var topic={
			id:$("#exaGroup"),
			url: "../../user/findUser",
			search:[{"name" : "account","value" : encodeURI($("#account_s").val())}],
			mData:[{"mData" : "id","sWidth" : "3%","class": "center sorting","bSearchable": false,"bStorable": false,render:function(data, type, row) {
					return '<input type="checkbox" id="checkbox" title="" value="'+data+'" name="check" />';
	        	  }},
	           {"mData" : "id","class": "center sorting"},
	           {"mData" : "account","class": "center sorting"},
	           {"mData" : "createrName","class": "center sorting"},
	           {"mData" : "createTime","class": "center sorting"},
	           {"mData" : "status","class": "center sorting", render:function (data, type, row) {
	        	   if(data==1){
	        		   return "启用";  
	        	   }else{
	        		   return "冻结";  
	        	   }
	           }},
	           {"mData" : "status","sWidth" : "157px","class": "center sorting ","bSearchable": false,"bStorable": false, render:function (data, type, row) {
//	        	    var str = "<button type=\"button\" id=\"editButton\" data-toggle=\"modal\" data-target=\"#myModal\" class=\"btn btn-success btn-sm\" data-id='"+row.id+"'>编辑</button> ";
	        	   var str=""; 
	        	   if(data==1){
	        	    	str += "<button type=\"button\" id=\"frozenButton\" class=\"btn btn-danger btn-sm\"  data-id='"+row.id+"'>冻结</button>"; 
	        	    }else{
	        	    	str += "<button type=\"button\" id=\"enableButton\" class=\"btn btn-success btn-sm\" data-id='"+row.id+"'>启用</button>"; 
	        	    }
	                return str;
	            }
	           }
	       	],
	       searchKey:'#search',
	       //外部挂载事件
	       externalEvents:[function(){
				    	 //执行顶部事件
				   			window.util.bindType($(topic.searchKey),window.validate.click,function(event){
				   				window.search=[{"name" : "account","value" : encodeURI($("#account_s").val())}];
				   				//再次加载数据
				   				window.mx.initData(topic);
				   			});
	       				},function(){
	       					window.util.bindType($("#submitButt"), window.validate.click, function(
	                			event) {
	                		window.params = {
	                			account : $('#account').val(),
	                			password : $('#password').val(),
	                		}
	                		window.util.post('../../user/save', {
	                			check : JSON.stringify(window.params)
	                		}, function(res) {
	                			if(res.success){
	                				window.location.href="../../business/user/user.html" 
	                			}else{
	                				alert(res.data);
	                				return;
	                			}
	                		});
	                	})
	                },function(){
	     	    	   //冻结用户
	     	    	   window.util.bindType($(topic.id).find('button.btn-danger'),window.validate.click,function(event){
	     	    		   window.params={
	     	    		      check:$(this).data('id'),
	     	    		      status:0,
	     	    		      auditUserId:window.validate['userId']
	     		    	   }
	     	    		   if($(this).data('id')!=undefined){
	     	    			   window.util.post('../../user/updatestatus',{check: JSON.stringify(window.params)},function(msg){
	     	    				   if(!msg.success){
	     	    					   alert(msg.message);
	     	    				   }else{
	     	    					  window.location.href="../../business/user/user.html" 
	     	    				   }
	     	    			   });
	     	    		   }
	     	    	   });
	     	    	 },function(){
	     	    		 //冻结用户
	     	    	   window.util.bindType($(topic.id).find('button.btn-success'),window.validate.click,function(event){
	     	    		   window.params={
	     	    		      check:$(this).data('id'),
	     	    		      status:1,
	     	    		      auditUserId:window.validate['userId']
	     		    	   }
	     	    		   if($(this).data('id')!=undefined){
	     	    			   window.util.post('../../user/updatestatus',{check: JSON.stringify(window.params)},function(msg){
	     	    				   if(!msg.success){
	     	    					   alert(msg.message);
	     	    				   }else{
	     	    					  window.location.href="../../business/user/user.html" 
	     	    				   }
	     	    			   });
	     	    		   }
	     	    	   });
	     	    	 }
	       		]
	};
	//虚拟挂载搜索
	window.search=topic.search;
	//外部事件的挂载
	window.externalEvents=topic.externalEvents;
	//初始化
	window.mx.init(topic);
})