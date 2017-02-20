/*弹出提示框，在屏幕中央*/
function showMsg(msg) {
	msg = '<center>'+ msg +'</center>';
	$.messager.show({		
		title : '提示信息',
		msg : msg,
		showType : 'slide',
		timeout : 3000
	});
}

function showError(msg) {
	msg = '<center>'+ msg +'</center>';
	$.messager.show({		
		title : '错误信息',
		msg : msg,
		showType : 'slide',
		iconCls:'icon-no',
		timeout : 3000
	});
}

/* 处理在编辑状态下点击查询是否给予保存提示 */
//提示是否需要保存
function isContinue(){
	var rows=$('#dg').datagrid('getRows');
	var is_save=false;// 是否提示保存
	var edit_count=0;// 编辑中的
	var new_count=0;// 新增的
	var count=0;
	if(rows.length>0){
		for(var i=0;i<rows.length;i++){
   			if(rows[i].isNewRecord){
   				new_count++;
   			}else if(rows[i]['editing']){
   				edit_count++;
   			}
   		}
		count=new_count + edit_count;
	}
	if(count>0){
		is_save=true;
	}
	return is_save;
}