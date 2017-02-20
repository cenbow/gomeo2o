//商品编辑页面-快速添加属性
   var inputType = [{'id':'1','name':'文本框'},{'id':'2','name':'可编辑下拉框'},{'id':'3','name':'复选框'},{'id':'4','name':'下拉框'}];
	   //值类型
	   var valueType = [{'id':'1','name':'文本'},{'id':'2','name':'布尔'},{'id':'3','name':'整型'},{'id':'4','name':'浮点'},{'id':'5','name':'日期'}];
		//判断是否选择分类
		 function addProperty(dg){
			//判断是否选择分类
			var cateId = $("#s_cateId").combo("getValue");
			var cateName = $("#s_cateId").combo("getText");
			var categoryName = cateName.substring(cateName.lastIndexOf('/')+1);
			if(cateId!="all" && cateId!="0"){
			  	//一、数据赋值（分类、分类名称）
			  	$("#site_cateId_"+dg).val(cateId);
			  	$("#site_cateName_"+dg).val(cateName);
			  	//二、弹出框展示
			  	 $("#third_pro_window_"+dg).window('open');
			  	 //定位弹出窗口的位置
			  	 $("#third_pro_window_"+dg).panel("move",{top:window.parent.document.documentElement.scrollTop || window.parent.pageYOffset || window.parent.document.body.scrollTop});
			  	 if(dg==0){
				  	 $('#dg_0').datagrid({
				  		  url:'/property/list?',
			  			  queryParams: {
			                cateId:cateId,
			                cateName:categoryName,
			                pageSize:500,
			                type:2
			             }
			         });
			  	 }else{
			  		var rows = $('#dg_'+dg).datagrid('getRows');
			  		for(var i = rows.length - 1; i >= 0; i--){
						var index = $('#dg_'+dg).datagrid('getRowIndex', rows[i]);
				  		$('#dg_'+dg).datagrid('deleteRow', index); //删除
					}
			  		$('#s_pro').combotree({
			  		    url:'/property/proseltree?cateId='+cateId,
			  		  	panelHeight:'auto',
			  		    onLoadSuccess:function(data){
			  		    	var trees = $('#s_pro').combotree('tree').tree("getRoots");
			  		    	for(var i=0;i<trees.length;i++){
			  		    		if(trees[i].text!='--请选择--' && trees[i].text.indexOf('关键')==-1){
			  		    		}else{
			  		    			$('#s_pro').combotree('tree').tree("remove",trees[i].target);
			  		    		}
			  		    	}
			  		    },onSelect:function(node){
			  		    	if(node.text!='--请选择--' && node.text.indexOf('继承')==-1){
				  		    	$('#dg_1').datagrid({   
				                     url:'/pvalue/list?',
				                     queryParams: {
				                      cateId:cateId,
				                      propertyId:node.id,
				                      cateName:categoryName,
				                      pageSize:500
				                   },
				                    onLoadSuccess:function(data){
				                      //根据所选语言销毁多余语言数据
				                      loadParser();
				                      resetIframeHeight();
				                    }
				                });
			  		    	}
			  		    }
			  		  });
			  	 }
			  	$('#dg_'+dg).datagrid('hideColumn', "id"); //隐藏id列
			}else{
				showMsg("请选择分类属性模板～");
			}
		  }
		//行编辑
		  function onClickRow(index,row,dgId){
			  if((row.transstatus==0 || row.transstatus==null)&& !row.isExtend){
				  $('#dg_'+dgId).datagrid('selectRow', index).datagrid('beginEdit', index);
			  }
			}
		 //追加行
		  function append(dgId) {
			  if(dgId==1){ //属性值
				  var propertyId = $("#s_pro").combotree("getValue");
			  	  var propertyText = $("#s_pro").combotree("getText");
			  	  if(propertyId==null || propertyId==""){
			  		  showMsg("请选择所属属性");
					return;			  		  
			  	  }else{
				  		if(propertyText.indexOf('继承')!=-1){
				  			showMsg("继承属性不可添加属性值，请到属性预设值去添加");
				  			return;
				  		}
			  	  }
			  }
		      var row = $('#dg_'+dgId).datagrid('getSelected');
		      var index = 0;
		      if (row){
		      	index = $('#dg_'+dgId).datagrid('getRowIndex', row);
		      }
		      $('#dg_'+dgId).datagrid('insertRow', {
		        index: index,
		        row:{
		          status:'P'
		        }
		      });
		      $('#dg_'+dgId).datagrid('selectRow',index);
		      $('#dg_'+dgId).datagrid('beginEdit',index);
		      if(dgId==0){
		    	  //状态默认选中第一项（combobox）
		          var comboboxLabel=["type","inputType","valueType","isEnnable"];
		          var currentEditor = null;
		          for(var i=0;i<comboboxLabel.length;i++){
		            currentEditor = $('#dg_'+dgId).datagrid('getEditor', {index:index,field:comboboxLabel[i]});
		               if(currentEditor){
		                 if(comboboxLabel[i]=="type"){
		                   $(currentEditor.target).combobox("select","2"); //第一项进行选中
		                 }else if(comboboxLabel[i]=="isEnnable"){
		                   $(currentEditor.target).attr("checked",true);
		                 }else{
		                   $(currentEditor.target).combobox("select","1"); //第一项进行选中
		                 }
		               }
		          }
		          //排序号默认为1
		          currentEditor = $('#dg_'+dgId).datagrid('getEditor', {index:index,field:'cno'});
		          $(currentEditor.target).numberbox('setValue', 1);
		      }else{
		    	  var currentEditor = $('#dg_'+dgId).datagrid('getEditor', {index:index,field:"isEnnable"}); //默认可用（属性值）
		    	  $(currentEditor.target).attr("checked",true);
		    	  //排序号默认为1
		          currentEditor = $('#dg_'+dgId).datagrid('getEditor', {index:index,field:'cno'});
		          $(currentEditor.target).numberbox('setValue', 1);
		      }
		    }
		//取消行
		  function cancelrow(dgId){
		     var rows = $('#dg_'+dgId).datagrid('getSelections'); //对编辑有作用
		     if(rows.length>0){
		    	 var r = window.confirm("是否要取消所选行？");
	    			if (r){
	    				$('#dg_'+dgId).datagrid('resize');
	    		         for(var i=0;i<rows.length;i++){
		    		   	      //判断Id是否存在
		    		   	      var currentIndex =  $('#dg_'+dgId).datagrid('getRowIndex',rows[i]);
		    		   	      $('#dg_'+dgId).datagrid('collapseRow',currentIndex);
		    		   	      var obj = $('#dg_'+dgId).datagrid('getRows')[currentIndex]; 
		    		   	      if(parseInt(obj["id"])>0){
		    		   	        $('#dg_'+dgId).datagrid('cancelEdit', currentIndex); //取消编辑
		    		   	        $('#dg_'+dgId).datagrid('unselectRow', currentIndex);
		    		   	      }else{
		    		   	        $('#dg_'+dgId).datagrid('deleteRow', currentIndex); //删除
		    		   	      }
	    		         }
	    			}
		     	}
		    }
		//保存数据
			function accept(dgId) {
				var $dg =$('#dg_'+dgId);
				// 关闭所有行，并且验证数据（否则inserted,updated不启作用）
				var rows = $dg.datagrid('getRows');
				for ( var i = 0; i < rows.length; i++) {
					$dg.datagrid('endEdit', i);
				}
				if ($dg.datagrid('getChanges').length) {
					var inserted = $dg.datagrid('getChanges', "inserted");//新增行
					var updated = $dg.datagrid('getChanges', "updated"); //编辑行
					//循环验证行数据
					var index = 0;
					var checkState = true;
					var repeat = false;//是否存在重复的属性名称、属性值名称
					var repeatValue = "[";
					var combin = updated.concat(inserted);//合并对象
					var repeatCount = 0;
					var repeatId = new Array();
					var cateId = $("#s_cateId").combo("getValue");
					for(var i=0;i<combin.length;i++){
						index = $('#dg_'+dgId).datagrid('getRowIndex', combin[i]);
						if (!$dg.datagrid('validateRow', index)){
							checkState =false;
						}else{
							//验证属性值是否重复 
							if(dgId>0){ //属性值添加
								repeatCount = 0;
								var addName = combin[i].cnname;
								for ( var j = 0; j < rows.length; j++) {
									if(addName==rows[j].cnname){
										repeatCount++;
										repeatId.push(j);
									}
								}
								if(repeatCount>1){
									repeatValue+=addName+",";
									repeat = true;
								}
							}
						}
		            }
				  if(repeat){
					  showMsg(repeatValue+"]"+"，属性值重复～");
					  for(var k=0;k<repeatId.length;k++){
							var rowIndex = repeatId[k];
							$dg.datagrid('beginEdit',rowIndex );
						}
					  return;
				  }
		          if(!checkState){
		        	  showMsg("数据校验有误~");
		          }else{
		        	  var jsonArray = new Array();
		        	  if(dgId==0){ //属性批量添加
			        	  for(var i=0;i<combin.length;i++){ //编辑数据
				        	  var json = {};
			        	  	  if(combin[i].id!=undefined){
				        		  json.id = combin[i].id;
			        	  	  }
			        	  	json.cateId = cateId; //所属分类
			        	  	json.cnname = combin[i].cnname; //名称
			                json.cno = combin[i].cno;  //排序号
			                json.type = 2; //属性类型(普通)
			                json.inputType = combin[i].inputType; //控件类型
			                json.valueType = combin[i].valueType; //值类型
			                json.isNotNull = 2; //非必填
			                json.isSearch = combin[i].isSearch; //搜索属性
			                json.isEnnable  = combin[i].isEnnable;  //状态
			        		jsonArray.push(json2str(json));
			        	  }
		        	  }else{//属性值批量修改
		        		  var propertyId = $("#s_pro").combotree("getValue");
			        	  for(var i=0;i<combin.length;i++){ //编辑数据
			        		  var json = {};
			        		  if(combin[i].id!=undefined){
				        		  json.id = combin[i].id;
			        	  	  }
			        		  json.propertyId = propertyId ;//所属属性
			                  json.cateId = cateId;   //所属分类
			        		  json.cnname = combin[i].cnname; //属性值名称
			                  json.pvalue = combin[i].pvalue; //属性值
			                  json.cno = combin[i].cno;  //排序号
			                  json.isEnnable  = combin[i].isEnnable;  //状态
							  jsonArray.push(json2str(json));
			        	  }
		        	  }
		        	 if(dgId==0){
			        	  //追加到主页面上（属性、属性值）
			        	  $.post("/property/updatebatch",{'jsons':'['+jsonArray.join(",")+']'},function(data){
			        	  },'jsonp');
		        	  }else{
		        		//追加到主页面上（属性、属性值）
			        	  $.post("/pvalue/updatebatch",{'jsons':'['+jsonArray.join(",")+']'},function(data){
			        	  },'jsonp'); 
		        	  } 
		          }
		      }else{
		    	  //alert("无任何修改");
		      }
		  }
			function json2str(obj)
			{
			  var S = [];
			  for(var i in obj){
			  obj[i] = typeof obj[i] == 'string'?'"'+obj[i]+'"':(typeof obj[i] == 'object'?json2str(obj[i]):obj[i]);
			  S.push(i+':'+obj[i]);
			  }
			    return '{'+S.join(',')+'}';
			}
			
			function jsonpCallbackp(data){
			  if(data.result=="success"){
				 showMsg("保存成功");
				  $('#dg_'+data.proId).datagrid('reload');
			  }else{
				  showMsg(data.msg);
			  }
			}
	   function isTrans(value,row,index){
		   	if(value==0){
		   		return "未翻译";
		   	}else{
				return "已翻译";
		   	}
	   }
	   function confirmPro(dg){
		   $("#third_pro_window_"+dg).window('close');
		}
	   function confirmTip(dg){
		   var dgId = dg;
			var editingCount = 0;
			//---判断是属性值是否存在未保存的数据----
			var dg = "dg_"+dg;
			var rows = $("#"+dg).datagrid('getRows'); 
			for ( var i = 0; i < rows.length; i++) {
				$("#"+dg).datagrid('endEdit', i);
			}
			editingCount+=$("#"+dg).datagrid('getChanges').length;
			var isContinue = true;
			//属性未保存的;
			if(editingCount>0){
				var result = confirm("有未保存的记录，是否继续操作？");
				if(!result){
					isContinue = false;
				}
			}
			if(isContinue){
				//reload普通属性
				loadOridnaryPro();
			} 
			return isContinue;
	   }
	  