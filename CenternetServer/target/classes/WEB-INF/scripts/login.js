function login() {
	if ($("#username").val().length == 0) {
		document.getElementById('msg').innerHTML = "用户名不能为空";
	} else if ($("#userpwd").val().length == 0) {
		document.getElementById('msg').innerHTML = "密码不能为空";
	} else {
		var data = $("#login_form").serialize();
		$.ajax({
			url : "/login",
			type : "POST",
			cache : false,
			data : data,
			async : false,
			success : function(message) {
				// 如果验证成功，转到用户主界面
				if (message == null || message == undefined || (!message)) {
					window.open('/dashboard', '_self', false)
				}
				// 如果验证失败，在登录界面显示出错信息
				else {
					document.getElementById('msg').innerHTML = message;
				}
			}
		});
	}
}
