
//根据情况显示与隐藏“搜索”框中的提示信息
function showSearch(obj){
	var text=$(obj).val();
	if(text=="手机号/邮箱/用户名"){
		$(obj).val("");
		$(obj).removeAttr("style");
	}else if(text==""){
		$(obj).val("手机号/邮箱/用户名");
		$(obj).attr("style","color:#a8a8a8");
	}
}