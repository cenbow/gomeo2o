var treeIds = [];
var index = 0;
function treeQuery(q,e){
		var temp=this;
		if(q==""){
			$(temp).combotree("setValue","");
			$(temp).combotree("setText","");
			$(temp).combotree("reload");
		}else{
			var urlStr='/category/cateseltree?isEnnable=1';
			$.ajax({
             type: "post",
             url: urlStr,
             data: "infoName=" + q,
             success: function (data) {
             		if(data!=""){
                 		data = eval('('+data+')');
                 		searchTreeValues = data; //保存到全局页面（用于模糊查询匹配）
                         $(temp).combotree("loadData",data);
             		}
             		$(temp).combotree("setText",q);
             	}
         	});	
		}
	}
	
	function treeNodeClick(node){
		if(node!=null){
			treeIds =new Array();
			treeIds.push(node.id);
			node = $('#cateTree').combotree('tree').tree('getParent', node.target);  //父级
	   		   if(node && node.id !=0){
	    		   while(node && node.id!=0){
	    			   treeIds.push(node.id);
	    			   node = $('#cateTree').combotree('tree').tree('getParent', node.target); //父级以上
	    		   }
	   		   }
	   		   if(treeIds.length>0){
	   			   showtrees(treeIds.length);
	   		   }
		}
		$("#cateTree").next().children(":text").unbind("onblur");
	}
	
	function treeLoadSuccess(node,data){
		if(node!=null&&data==""){
			$(this).tree('update', {
				target: node.target,
				leaf: true,
				iconCls:"tree-file",
				state:"open"
			});
			treeNodeParser(node);
		}
	}
	
	function treeNodeBeforeExpand(node){
		if(node!=null&&!node.leaf){
   			var urlStr='/category/cateseltree?pid='+node.id+'&level='+node.dept+'&isEnnable=1';
       		$(this).tree("options").url= urlStr;
   		}
	}
	
	// 重新渲染tree
	function treeNodeParser(node){
		$.parser.parse(node.parent());
	}
	
	//统计树模糊查询匹配数量
	function countTreeName(searchTreeValues,inputText){
		var count = 0;
		childrenCount = 0;
		for(var i=0;i<searchTreeValues.length;i++){
			if(searchTreeValues[i].text==inputText){ 
				$("#s_cateId").combotree('setValue', searchTreeValues[i].id);
				treeId = searchTreeValues[i].id;
				count++;
			}
			if(searchTreeValues[i].children.length>0){
				countChildrenTreeName(searchTreeValues[i].children,inputText);
				count =count +childrenCount;
			}
		}
		return count;
	}
	function countChildrenTreeName(children,inputText){
		for(var j=0;j<children.length;j++){
			if(children[j].text==inputText){
				treeId = children[j].id;
				childrenCount++;
			}
			if(children[j].children.length>0){
				countChildrenTreeName(children[j].children,inputText);
			}
		}
	}