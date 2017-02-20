$(function(){
	var pathName = window.location.pathname;
	pathName = pathName.split('/')[1];
	if(pathName=="business"){
		pathName="";
	}else{
		pathName="/"+pathName;
	}
	
	window.util.get(''+pathName+'/auditinfo',function(msg) {
		if(msg.code==0){
			window.validate['userId'] = eval(msg).data.id;
			window.validate['name'] = eval(msg).data.account;
			$('#bs-example-navbar-collapse-1').empty().append('<ul class="nav navbar-nav"><li><a href="javaScript:;" style="height: 50px"><span class="pull-left nav-username">欢迎您 : '+window.validate['name']+'</span></a></li><li><a class="dropdown-toggle" data-toggle="dropdown" id="logout" href="javaScript:;" style="height: 50px">注销</a></li></ul>');
			window.util.bindType($("#logout"), window.validate.click, function(event) {
				window.util.get(''+pathName+'/logout',function(res) {
					if(res.success){
						if(pathName==""){
							location.href="/"; 
						}else{
							location.href=pathName; 
						}
					}else{
						alert(res.data);
						return;
					}
				});
			});
		}else{
			alert(msg.message);
			if(pathName==""){
				location.href="/"; 
			}else{
				location.href=pathName; 
			}
		}
	});
	
	(function(obj) {
		var ul="";
		var ddd="";
		var pathname=[];
		$.each(obj.children,function(i,n){
			ddd="";
			pathname=[];
			traverse(n, 0,ddd);
			ul+='<li class="nav-left-dropdown">';
	            ul+='<a href="javaScript:;">'+n.name+'</a>';
	            	var array = $.inArray(window.location.pathname+window.location.search,pathname);
	                var innerClassName = array >=0 ? "nav-left-dropdown-ul" : "";
	                var className = array >=0 ? "block" : "hide";
	            	ul+='<ul class="nav-left-dropdown-menu '+ innerClassName +'" style="display:'+className+';">';
	            		ul+= ddd;
	            	ul+='</ul>';
	        ul+='</li>';
		});
		function traverse(node, i,ul) {
		    var children = node.children;
		    if (children != null) {
		        ul+='<li><a href="'+children[i].href+'">'+children[i].name+'</a></li>';
		        pathname.push(children[i].href);
		        if ((~~i+1) == children.length){  
		            traverse(children[i], 0,ul);
		        }else{  
		            traverse(node, i + 1,ul);  
		        }
		    }else{
		    	ddd=ul;
		    }
		}
		$('.nav-list').find('ul').append(ul);
	})({  
	    name : 'root',  
	    children : [ {  
	        name : '圈子审核',  
	        children : [ {  
	            name : '未审核',
	            href : ''+pathName+'/business/group/group.html?type='+window.validate.notAudited+''
	        },{  
	            name : '审核已通过',
	            href : ''+pathName+'/business/group/group.html?type='+window.validate.egis+''
	        },{  
	            name : '审核未通过',
	            href : ''+pathName+'/business/group/group.html?type='+window.validate.auditDoesNotPass+''
	        }]
	    },{  
	        name : '修改圈子审核',  
	        children : [ {  
	            name : '未审核',
	            href : ''+pathName+'/business/editGroup/editGroup.html?type='+window.validate.notAudited+''
	        },{  
	            name : '审核已通过',
	            href : ''+pathName+'/business/editGroup/editGroup.html?type='+window.validate.egis+''
	        },{  
	            name : '审核未通过',
	            href : ''+pathName+'/business/editGroup/editGroup.html?type='+window.validate.auditDoesNotPass+''
	        }]
	    },{  
	        name : '话题审核',  
	        children : [ {  
	            name : '未审核',
	            href : ''+pathName+'/business/topic/topic.html?type='+window.validate.notAudited+''
	        },{  
	            name : '审核已通过',
	            href : ''+pathName+'/business/topic/topic.html?type='+window.validate.egis+''
	        },{  
	            name : '审核未通过',
	            href : ''+pathName+'/business/topic/topic.html?type='+window.validate.auditDoesNotPass+''
	        }]
	    },{  
	        name : '回复审核', 
	        children : [ {  
	            name : '未审核',
	            href : ''+pathName+'/business/topic/back/topicBack.html?type='+window.validate.notAudited+''
	        },{  
	            name : '审核已通过',
	            href : ''+pathName+'/business/topic/back/topicBack.html?type='+window.validate.egis+''
	        },{  
	            name : '审核未通过',
	            href : ''+pathName+'/business/topic/back/topicBack.html?type='+window.validate.auditDoesNotPass+''
	        }]
	    },{  
	        name : '二级回复审核', 
	        children : [ {  
	            name : '未审核',
	            href : ''+pathName+'/business/tworeply/twoTopicBack.html?type='+window.validate.notAudited+''
	        },{  
	            name : '审核已通过',
	            href : ''+pathName+'/business/tworeply/twoTopicBack.html?type='+window.validate.egis+''
	        },{  
	            name : '审核未通过',
	            href : ''+pathName+'/business/tworeply/twoTopicBack.html?type='+window.validate.auditDoesNotPass+''
	        }]
	    },{  
	        name : '操作日志',  
	        children : [ {  
	            name : '圈子审核',
	            href : ''+pathName+'/business/log/group/groupLog.html'
	        },{  
	            name : '修改圈子审核',
	            href : ''+pathName+'/business/log/editGroupLog/editGroupLog.html'
	        },{  
	            name : '话题审核',
	            href : ''+pathName+'/business/log/topic/topicLog.html'
	        },{  
	            name : '回复审核',
	            href : ''+pathName+'/business/log/topicBack/topicBackLog.html'
	        },{  
	            name : '二级回复审核',
	            href : ''+pathName+'/business/log/twoTopicBack/twoTopicBackLog.html'
	        }]
	    },{
	    	name : '账号权限管理',  
		    children : [ {  
		         name : '账号管理',
		         href : ''+pathName+'/business/user/user.html'
	        }]
	    }] 
	}); 
	//drop
	eval(function(p,a,c,k,e,r){e=function(c){return c.toString(a)};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('$(8(){$(".i").5();$(".3-4-5>a").j(8(){k($(0).6("d")!=1&&$(0).6("d")!=n){$(0).9("3-4-5-a");$0=$(0);$(0).c("7").h(e,8(){$0.9("3-4-f-g");$0.9("3-4-5-7")});$(0).6("d","1")}l{$(0).b("3-4-5-a");$(0).b("3-4-f-g");$(0).c("7").b("3-4-5-7").m(e);$(0).6("d","2")}})});',24,24,'this|||nav|left|dropdown|attr|ul|function|removeClass||addClass|next||300|bottrom|border|slideUp|dropdownMenu|click|if|else|slideDown|undefined'.split('|'),0,{}))
});