var user_name_status = false;
var user_email_status = false;
var user_password_status = false;
var user_repassword_status = false;
var user_veriCode_status = false;
$(document)
		.ready(
				function() {
					// 检测会员用户名
					var user_name = document.getElementsByName('user_name')[0];
					var user_name_message = document
							.getElementById('user_name_message');
					user_name_status = false;
					var user_name_reg = /^[A-Za-z0-9\u4E00-\u9FA5]*$/; // 用正则表达式/[\u4E00-\u9FA5]/表示中文
					user_name.onmouseover = function() {
						user_name.className = 'ipt ipt_focus';
					};
					user_name.onmouseout = function() {
						user_name.className = 'ipt ipt_nomal';
					};
					user_name.onblur = function() {
						var user_name_size = check_code_size(user_name.value);
						if (user_name.value == '') {
							user_name.className = 'ipt ipt_focus'
							user_name_message.style.color = 'red';
							user_name_message.innerHTML = '* 请填写用户名';
							user_name_status = false;
						} else if (user_name_size < 4 || user_name_size > 14) {
							user_name.className = 'ipt ipt_error';
							user_name.onmouseout = 'ipt ipt_error';
							user_name_message.style.color = 'red';
							user_name_message.innerHTML = '* 填写的用户名格式不正确';
							user_name_status = false;
						} else if (!user_name_reg.test(user_name.value)) {
							user_name.className = 'ipt ipt_error';
							user_name.onmouseout = 'ipt ipt_error';
							user_name_message.style.color = 'red';
							user_name_message.innerHTML = '*含有系统禁用的特殊字符';
							user_name_status = false;
						} else {
							user_name.className = 'ipt ipt_nomal';
							user_name_message.style.color = 'green';
							user_name_message.innerHTML = '恭喜，您的用户名可用';
							user_name_status = true;
						}
					};

					// 检测邮箱
					var user_email = document.getElementsByName('user_email')[0];
					var user_email_message = document
							.getElementById('user_email_message');
					user_email_status = false;
					var user_email_reg = /^[0-9a-zA-Z_\-\.]+@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)*$/;
					user_email.onmouseover = function() {
						user_email.className = 'ipt ipt_focus';
					};
					user_email.onmouseout = function() {
						user_email.className = 'ipt ipt_nomal'
					};
					user_email.onblur = function() {

						if (user_email.value == '') {
							user_email.className = 'ipt ipt_focus';
							user_email_message.style.color = 'red';
							user_email_message.innerHTML = '* 请填写Email帐号';
							user_email_status = false;
						} else if (!user_email.value.match(user_email_reg)) {
							user_email.className = 'ipt ipt_error';
							user_email.onmouseout = 'ipt ipt_error';
							user_email_message.style.color = 'red';
							user_email_message.innerHTML = '* 填写的Email帐号格式不正确';
							user_email_status = false;
						} else {
							user_email_message.innerHTML = '';
							ajax_check(user_email, 'email');
						}
					};

					// 检测密码
					var user_password = document
							.getElementsByName('user_password')[0];
					var user_password_message = document
							.getElementById('user_password_message');
					user_password_status = false;
					user_password.onmouseover = function() {
						user_password.className = 'ipt ipt_focus'
					};
					user_password.onmouseout = function() {
						user_password.className = 'ipt ipt_nomal'
					};
					user_password.onblur = function() {
						if (user_password.value == '') {
							user_password.className = 'ipt ipt_focus';
							user_password_message.style.color = 'red';
							user_password_message.innerHTML = '* 请填写密码';
							user_password_status = false;
						} else if (user_password.value.length < 6
								|| user_password.value.length > 16) {
							user_password.className = 'ipt ipt_error';
							user_password.onmouseout = 'ipt ipt_error';
							user_password_message.style.color = 'red';
							user_password_message.innerHTML = '* 填写的密码格式不正确';
							user_password_status = false;
						} else {
							user_password.className = 'ipt ipt_nomal';
							user_password_message.style.color = 'green';
							user_password_message.innerHTML = '密码格式正确';
							user_password_status = true;
						}
					};

					// 检测确认密码
					var user_repassword = document
							.getElementsByName('user_repassword')[0];
					var user_repassword_message = document
							.getElementById('user_repassword_message');
					user_repassword_status = false;
					user_repassword.onmouseover = function() {
						user_repassword.className = 'ipt ipt_focus'
					};
					user_repassword.onmouseout = function() {
						user_repassword.className = 'ipt ipt_nomal'
					};
					user_repassword.onblur = function() {
						if (user_repassword.value == '') {
							user_repassword.className = 'ipt ipt_focus'
							user_repassword_message.style.color = 'red';
							user_repassword_message.innerHTML = '* 请填写确认密码';
							user_repassword_status = false;
						} else if (user_repassword.value != user_password.value) {
							user_repassword.className = 'ipt ipt_error'
							user_repassword.onmouseout = 'ipt ipt_error';
							user_repassword_message.style.color = 'red';
							user_repassword_message.innerHTML = '* 两次填写的密码不一致';
							user_repassword_status = false;
						} else if (user_repassword.value.length < 6
								|| user_repassword.value.length > 16) {
							user_repassword.className = 'ipt ipt_error'
							user_repassword.onmouseout = 'ipt ipt_error';
							user_repassword_message.style.color = 'red';
							user_repassword_message.innerHTML = '* 填写的密码格式不正确';
							user_repassword_status = false;
						} else {
							user_repassword.className = 'ipt ipt_nomal'
							user_repassword_message.style.color = 'green';
							user_repassword_message.innerHTML = '确认密码格式正确';
							user_repassword_status = true;
						}
					};

					// 检测验证码
					var veriCode = document.getElementsByName('veriCode')[0];
					var veriCode_message = document
							.getElementById('user_veriCode_message');
					veriCode.onmouseover = function() {
						veriCode.className = 'ipt ipt_focus'
					};
					veriCode.onmouseout = function() {
						veriCode.className = 'ipt ipt_nomal'
					};
					veriCode.onblur = function() {
						if (veriCode.value == '') {
							veriCode.className = 'ipt ipt_focus'
							veriCode_message.style.color = 'red';
							veriCode_message.innerHTML = '* 请填写验证码';
							user_veriCode_status = false;
						} else {
							if (user_veriCode_status == false) {
								ajax_check(veriCode, 'veriCode');
							}
						}
					};
				});

function checkForm() {
	user_name.onblur();
	user_email.onblur();
	user_password.onblur();
	user_repassword.onblur();
	veriCode.onblur();
	if (user_name_status && user_email_status && user_password_status
			&& user_repassword_status && user_veriCode_status) {
		return true;
	} else {
		return false;
	}
}

// 计算字符字节数
function check_code_size(string_data) {
	var chars = 0; // 字节数变量
	for ( var i = 0; i < string_data.length; i++) {
		var charinit = string_data.charCodeAt(i);
		if ((charinit >= 0x0001 && charinit <= 0x007e)
				|| (0xff60 <= charinit && charinit <= 0xff9f)) {
			chars++; // 单字节加1
		} else {
			chars += 2; // 双字节加2
		}
	}
	return chars;
}

function getVerCode() {
	$("#captchaImage").attr("src", "/register/captcha");
}

function ajax_check(variable, type) {
	
	var data;
	switch (type) {
	case 'email':
		data = "email=" + variable.value;
		$.ajax({
			url : "/register/validateEmail",
			type : "GET",
			cache : false,
			data : data,
			async : false,
			success : function(message) {
				if (message == 'exist') {
					user_email_message.style.color = 'red';
					user_email_message.innerHTML = "该email地址已存在，请重新输入";
					user_email_status = false;
				} else {
					user_email_message.style.color = 'green';
					user_email_message.innerHTML = "邮箱可用";
					user_email_status = true;
				}
			}
		});
		break;
	case 'veriCode':
		var veriCode = document.getElementsByName('veriCode')[0];
		var veriCode_message = document.getElementById('user_veriCode_message');
		data = "veriCode=" + variable.value;
		$.ajax({
			url : "/register/validateCaptcha",
			type : "GET",
			cache : false,
			data : data,
			async : false,
			success : function(message) {
				if (message == 'pass') {
					veriCode.className = 'ipt ipt_focus';
					veriCode_message.style.color = 'green';
					veriCode_message.innerHTML = '验证码填写正确';
					user_veriCode_status = true;
				} else if (message == 'unpass') {
					veriCode.className = 'ipt ipt_focus'
					veriCode_message.style.color = 'red';
					veriCode_message.innerHTML = '您输入的验证码错误';
					getVerCode();
					user_veriCode_status = false;
				}
			}
		});
		break;
	}
}