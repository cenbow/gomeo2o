$(function() {
	window.util.bindType($("#submitButt"), window.validate.click, function(
			event) {
		window.params = {
			account : $('#account').val(),
			password : $('#password').val(),
		}
		window.util.post('login', {
			check : JSON.stringify(window.params)
		}, function(res) {
			if(res.success){
				location.href="business/index.html" 
			}else{
				$(".login-error-msg").html(res.data);
				return;
			}
		});
	});
	window.util.bindType($("#password"), window.validate.keypress, function(
			event) {
		if(event.keyCode == "13")    
        {
			window.params = {
					account : $('#account').val(),
					password : $('#password').val(),
				}
				window.util.post('login', {
					check : JSON.stringify(window.params)
				}, function(res) {
					if(res.success){
						location.href="business/index.html" 
					}else{
						$(".login-error-msg").html(res.data);
						return;
					}
				});
        }
	});
})