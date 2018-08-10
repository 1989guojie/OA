<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<title>办公管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
	<meta name="Keywords" content="keyword1,keyword2,keyword3"/>
	<meta name="Description" content="网页信息的描述" />
	<meta name="Author" content="gdcct.gov.cn" />
	<meta name="Copyright" content="All Rights Reserved." />
	<link href="${ctx }/fkjava.ico" rel="shortcut icon" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="${ctx}/css/common/global.css"/>
	
	<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-timer.js"></script>
	
	<script type="text/javascript">
		$(function () {
			// 现实当前系统时间
			$("#time").timeRun();
			
			// 获取父页面的tstMain
			var tst = $("#tstMain", parent.document);
			
			
			$("#ShowNav").toggle(
				function(){ // 点击第一次
					$("#headtitle").hide(10);
					tst.attr("rows", "12,*");
					$("#nav_title").attr("title", "显示菜单栏");
					$(this).attr("src", "${ctx}/images/system/top_xs.gif");
				},
				function(){  // 点击次二次
					$("#headtitle").fadeIn(1000);
					tst.attr("rows", "82,*");
					$("#nav_title").attr("title", "隐藏菜单栏");
					$(this).attr("src", "${ctx}/images/system/top_yc.gif");
				}
			);
		})
		

	</script>
	
  </head>

 <body class="headbody">
	<div class="headtitle" id="headtitle">
    	<div class="headlogo"><img src="${ctx}/images/system/logo.gif" />
    	</div>
        <div class="headmenutop">
        	
        	<a class="headtopout" title="退出系统" href="javascript:void(0);" onclick="exit();">安全退出</a>
        	<a class="headtopout" title="密码修改" href="javascript:void(0);" onclick="password();">密码修改</a>
			<div class="titlexx">
				<span style="font-size:14px;">${admin_session_user.name}</span>&nbsp;您好，欢迎使用本系统&nbsp;&nbsp;
				<span id="time" style="color:#fff;"></span>
				
			</div>
        </div>
    </div>
    <div class="yctopdiv">
      	<a href="javascript:void(0);" class="t_link" title="隐藏菜单栏" id="nav_title">
		<img src="${ctx}/images/system/top_yc.gif" id="ShowNav"/><!--隐藏时反显示的图片<img src="images/top_xs.gif" />--></a>
    </div>
  </body>
</html>