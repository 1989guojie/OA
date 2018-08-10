<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>办公管理系统-登录页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	<meta name="Keywords" content="keyword1,keyword2,keyword3"/>
	<meta name="Description" content="网页信息的描述" />
	<meta name="Author" content="gdcct.gov.cn" />
	<meta name="Copyright" content="All Rights Reserved." />
	<link href="${ctx }/fkjava.ico" rel="shortcut icon" type="image/x-icon" />
	<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>

	<script type="text/javascript">
		$(function(){
			// 看不清楚
			$("#img").on("click", function(){
				$("#vimg").attr("src", "${ctx}/verify.jspx?random="+ Math.random()); // 防止浏览器缓存
			});
			
			// 为验证码绑定onmouseover与onclick
			$("#vimg").mouseover(function(){
				$(this).css("cursor", "pointer");
			}).click(function(){
				$("#img").trigger("click");  // 触发click事件
			});
			
			
			// 为登录按钮添加绑定事件
			$("#loginBtn").click(function(){
				// 获取表单元素
				var userId = $("#userId");
				var password = $("#password");
				var vcode = $("#vcode");
				
				var msg = "";
				if ($.trim(userId.val()) == "") {
					msg = "用户名不能为空";
					userId.focus();  // 获得焦点
				} else if (!/^\w{5,20}$/.test($.trim(userId.val()))) {
					msg = "用户名格式不正确";
					userId.focus();
				} else if ($.trim(password.val()) == ""){
					msg = "密码不能为空";
					password.focus();
				} else if (!/^\w{6,20}$/.test($.trim(password.val()))) {
					msg = "密码格式不正确";
					password.focus();
				} else if ($.trim(vcode.val()) == "") {
					msg = "验证码不能为空";
					vcode.focus();
				} else if (!/^\w{4}$/.test($.trim(vcode.val()))) {
					msg = "验证码格式不正确";
					vcode.focus();
				}
				
				if (msg != "") {
					alert(msg);
				} else {
					
					// 获取表单中的元素
					var params = $("#loginForm").serialize();
				//	alert(params);
					$.ajax({
						url : "${ctx}/admin/loginAjax.jspx",
						type : "post",
						data : params, // 请求参数
						dataType : "json",
						async : true,
						success : function(data) {
							if (data.status == 0) {  // 返回json为0代表登录成功
								window.location = "${ctx}/admin/main.jspx";  // 登录成功跳转到主页
							} else {
								$("#img").trigger("click");  // 触发click事件换验证码
								alert(data.tip)
							}
						},
						error : function() {
							alert("加载失败");
						}
						
					});
				}
			});

			// 登录时点击回车跳转到主页面
			// 为document绑定onkeydown事件
			$(document).keydown(function(event) {
				if (event.keyCode == 13) {
					$("#loginBtn").trigger("click");  // 触发点击事件
				}
			});
		});
		
	</script>

	<style type="text/css">
		body{ 
			background-repeat: repeat; 
			background-positon: 100%, 100%; 
		} 
		li{
			margin-left:20px;
		}
	</style>
	

	
</head>
<body background="${ctx}/images/login/9.png">
	<div align="center" style="height:100%">
		<form  id="loginForm">
			<table border="0" cellpadding="0" cellspacing="0" style="margin-top:120px;">
				<tr>
					<td colspan="2" width="447" height="104" background="${ctx}/images/login/1_01.jpg"></td>
				</tr>
				<tr>
					<td width="92" height="200" background="${ctx}/images/login/1_02.gif">&nbsp;</td>
					<td width="355" height="200" background="${ctx}/images/login/1_03.gif">
						<table style="font-size:13px;margin:0 0 0 30px;" >
							<tr align="left">
								<td>用户名：</td>
								<td colspan="2">
									<input type="text" name="userId" size="13" id="userId"/>
								</td>
								
							</tr>
							<tr align="left">
								<td>密&nbsp;&nbsp;码：</td>
								<td>
									<input type="password" name="password" size="13" id="password"/>
								</td>
								<td>
									<a href="javascript:void(0)" id="findpwd" style="font-size:12px;color:white;">忘了密码?</a>
								</td>
							</tr>
						   <tr align="left">
								<td>验证码：</td>
								<td>
									<div style="float:left;">
										<input type="text" name="vcode" size="4" maxlength="4" id="vcode"/>
									</div>
									<div style="float:left;padding:0 0 0 5px;">
										<img src="${ctx}/verify.jspx" width="55" height="22" title="验证码" id="vimg"/>
									</div>
								</td>
								<td align="left">
									<a href="javascript:void(0);" id="img" style="font-size:12px;color:white;">看不清楚</a>
								</td>
						   </tr>
						   <tr align="left">
						   		<td>&nbsp;</td>
								<td colspan="2"><input type="radio" name="key" value="1" id="key"/>记住用户</td>
						   </tr>
						 
						  <tr align="center">
							<td colspan="3">
								<input type="button" value="登 录" width="67" height="22" id="loginBtn"/>&nbsp;
								<input type="reset" value="重 置"/>
							</td>
						  </tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="3" width="447" height="34" background="${ctx}/images/login/1_04.gif"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>