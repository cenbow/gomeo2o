//站点分类属性确认页面-第三方属性自定义管理
//属性类型
  var propertyType = [{'id':'1','name':'关键属性'},{'id':'2','name':'普通属性'}];
  //控件类型
  var inputType = [{'id':'4','name':'可编辑下拉框'},{'id':'1','name':'下拉框'}];
  //值类型
  var valueType = [{'id':'1','name':'文本'},{'id':'2','name':'布尔'},{'id':'3','name':'整型'},{'id':'4','name':'浮点'},{'id':'5','name':'日期'}];
//弹出第三方属性自定义添加层
  var tabIndex = 1;
  function propertyDefined(tabIndex){
	  tabIndex = tabIndex;
	//判断是否选择分类
	var selectedSiteCate = $("#siteCategoryTab"+tabIndex).val(); 
	if(selectedSiteCate!="qxz" && selectedSiteCate!="siteCategorty"){
	  	//一、数据赋值（站点、分类、商品编号）
	  	$("#site_pid").val($("td:contains('商品编号')").next().html());
	  	$("#site_name").val($("td:contains('站点名称')").next().html());
	  	$("#site_cateId").val(selectedSiteCate.split(">")[0]);
	  	$("#site_cateName").val($("#siteCategoryTab"+tabIndex).find("option:selected").text());
	  	var siteId = $("#siteId").val();
	  	//二、弹出框展示
	  	 $("#third_pro_window").window('open');
	  	 //定位弹出窗口的位置
	  	 $("#third_pro_window").panel("move",{top:window.parent.document.documentElement.scrollTop || window.parent.pageYOffset || window.parent.document.body.scrollTop});
	  	 $('#dg_0').datagrid({
	  		  url:'/siteCategory/sprolist?cateId='+selectedSiteCate.split(">")[0]+'&siteId='+siteId,
              view: detailview,
              detailFormatter:function(index,row){
                return '<div class="ddv" style="padding:5px 0"></div>';
              },
              onExpandRow: function(index,row){
              var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
              ddv.panel({
               height:210,
               border:false,
               cache:true,
               href:'/siteCategory/spvaluelist?propertyId='+row.id,
               onLoad:function(){
                 $('#dg_0').datagrid('fixDetailRowHeight',index);
               }
              });
                $('#dg_0').datagrid('fixDetailRowHeight',index);
              }
         });
	  	$('#dg_0').datagrid('hideColumn', "id"); //隐藏id列
	}else{
		showMsg("请选择站点分类～");
	}
  }
  //行编辑
  function onClickRow(index,row,dgId){
	  if(row.isDefine==1){
		  $('#dg_'+dgId).datagrid('selectRow', index).datagrid('beginEdit', index);
	  }
	}
  function hideSubGrid(){
	  var rows = $('#dg_0').datagrid('getRows');
	  for(var m=0;m<rows.length;m++){
		  $('#dg_0').datagrid('collapseRow',m);
	  }
  }
  //追加行
  function append(dgId) {
      var row = $('#dg_'+dgId).datagrid('getSelected');
	  //隐藏sub,否则追加出现异常（判断是否存在编辑的非dg==0）,展开的子subgraid
	  if(dgId==0){
		  //判断是否存在属性值未保存
		  var pvEditingCount = 0;
		  $("table[id^='dg_'][id!='dg_0']").each(function(){
			var dg = $(this).attr("id");
			var rows = $("#"+dg).datagrid('getRows'); 
			for ( var i = 0; i < rows.length; i++) {
				$("#"+dg).datagrid('endEdit', i);
			}
			pvEditingCount+=$("#"+dg).datagrid('getChanges').length;
			if(pvEditingCount>0){
				return false; //==break	
			}
			});
		  if(pvEditingCount>0){
			  var re = window.confirm("存在未保存的属性值，是否继续操作?");
			  if(re){
				  hideSubGrid();
				  $(".ddv").empty();
			  }else{
				  return;
			  }
		  }else{
			  hideSubGrid();
			  $(".ddv").empty();
		  }
	  }
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
	      var comboboxLabel=["attrType","valueType","isDelete"];
	      var currentEditor = null;
	      for(var i=0;i<comboboxLabel.length;i++){
	        currentEditor = $('#dg_'+dgId).datagrid('getEditor', {index:index,field:comboboxLabel[i]});
	           if(currentEditor){
	             if(comboboxLabel[i]=="attrType"){
	               $(currentEditor.target).combobox("select","1"); //第一项进行选中
	             }else if(comboboxLabel[i]=="isDelete"){
	               $(currentEditor.target).attr("checked",true);
	             }else{
	               $(currentEditor.target).combobox("select","1"); //第一项进行选中
	             }
	           }
	      }
      }else{
    	  var currentEditor = $('#dg_'+dgId).datagrid('getEditor', {index:index,field:"isDelete"}); //默认可用（属性值）
    	  $(currentEditor.target).attr("checked",true);
      }
	  var expander = $('#dg_'+dgId).datagrid('getExpander', index);
	  //expander.removeClass('datagrid-row-expand').addClass("datagrid-row-collapse"); 
	  expander.removeClass('datagrid-row-expand');
    }
  //取消行
  function cancelrow(dgId){
     var rows = $('#dg_'+dgId).datagrid('getSelections'); //对编辑有作用
     if(rows.length>0){
    	 $.messager.confirm('确认对话框', '是否要取消所选行？', function(r){
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
    		         //loadParser();
    			}
    		});
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
			for(var i=0;i<combin.length;i++){
				index = $('#dg_'+dgId).datagrid('getRowIndex', combin[i]);
				if (!$dg.datagrid('validateRow', index)){
					checkState =false;
				}else{
					//验证属性值是否重复 
					if(dgId>0){ //属性值添加
						repeatCount = 0;
						var addName = combin[i].attrValName;
						for ( var j = 0; j < rows.length; j++) {
							if(addName==rows[j].attrValName){
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
	        		  json.pname = combin[i].pname;
	        		  json.attrType = combin[i].attrType;//控件类型
	        		  json.isDelete = combin[i].isDelete; //是否可用
	        		  json.isNeed = combin[i].isNeed;//是否必填 
	        		  jsonArray.push(json2str(json));
	        	  }
        	  }else{//属性值批量修改
	        	  for(var i=0;i<combin.length;i++){ //编辑数据
	        		  var json = {};
	        		  if(combin[i].id!=undefined){
		        		  json.id = combin[i].id;
	        	  	  }
	        		  json.attrValName = combin[i].attrValName;
					  json.isDelete = combin[i].isDelete;
					  json.attrId = dgId;
					  jsonArray.push(json2str(json));
	        	  }
        	  }
        	 if(dgId==0){
	        	  //追加到主页面上（属性、属性值）
	        	  $.post("/siteCategory/spupdate",{'jsons':'['+jsonArray.join(",")+']','thirdCateId':$('#site_cateId').val(),'siteId':$("#siteId").val()},function(data){
	        	  },'jsonp');
        	  }else{
        		//追加到主页面上（属性、属性值）
	        	  $.post("/siteCategory/spvupdate",{'jsons':'['+jsonArray.join(",")+']','pId':dgId},function(data){
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
		  if(data.proId=="0"){
			  //reload
			  $('#dg_0').datagrid('reload');
		  }else{
			  $('#dg_'+data.proId).datagrid({
				  url:'/siteCategory/spvaluejson',
				  queryParams: {
					  propertyId:data.proId
				  }
			  });
		  }
	  }else{
		  showMsg(data.msg);
	  }
	}
	//第三方属性、属性值自定义添加确认
	function confirmPro(){
		var editingCount = 0;
		//---判断是属性值是否存在未保存的数据----
		$("table[id^='dg_']").each(function(){
			var dg = $(this).attr("id");
			var rows = $("#"+dg).datagrid('getRows'); 
			for ( var i = 0; i < rows.length; i++) {
				$("#"+dg).datagrid('endEdit', i);
			}
			editingCount+=$("#"+dg).datagrid('getChanges').length;
			if(editingCount>0){
				return false; //==break	
			}
		});
		var isContinue = true;
		//属性未保存的;
		if(editingCount>0){
			var result = confirm("有未保存的记录，是否继续操作？");
			if(!result){
				isContinue = false;
			}
		}
		if(isContinue){
			var top = window.parent.document.documentElement.scrollTop || window.parent.pageYOffset || window.parent.document.body.scrollTop;
			$("#infobox").css("top",top);
			$(".black").show();
			showOrClose(true);
			queryFullpath('Tab'+tabIndex);
			$("#third_pro_window").window('close');
		}
	}