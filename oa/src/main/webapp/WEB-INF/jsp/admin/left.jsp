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
    <link rel="stylesheet" type="text/css" href="${ctx}/js/dtree/dtree.css"/>
    
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-timer.js"></script>
	<script type="text/javascript" src="${ctx}/js/dtree/dtree.js"></script>
	
	<style type="text/css">
		html,body{ height:100%;}
		a{color:#6a6f71; text-decoration:none;}
	</style>	
	
	<script type="text/javascript">
		$(function () {
			
			// 获取父页面的tstMain
			var fst = $("#fstMain", parent.document);
			
			
			$("#ShowNav").toggle(
				function(){ // 点击第一次
					$("#shumenu").hide(10);
					fst.attr("cols", "16,*");
					$("#nav_title").attr("title", "显示菜单栏");
					$(this).attr("src", "${ctx}/images/system/left_xs.gif");
				},
				function(){  // 点击次二次
					$("#shumenu").fadeIn(1000);
					fst.attr("cols", "148,*");
					$("#nav_title").attr("title", "隐藏菜单栏");
					$(this).attr("src", "${ctx}/images/system/left_yc.gif");
				}
			);
		})
		

	</script>
	
  </head>
 <body class="leftmenubody">
 	<div class="topdivyc">
    	<a href="javascript:void(0);" class="a_link" title="隐藏菜单栏" id="nav_title"><img src="${ctx}/images/system/left_yc.gif" id= "ShowNav"/><!--隐藏时反显示的图片<img src="images/left_xs.gif" />--></a>
    </div>
    <div class="bodytextmenu" id="shumenu">
	    <div class="shumenu" >
	    		<script type="text/javascript">
	    			// 创建树对象
	    			var d = new dTree("d", "${ctx}/js/dtree/");
	    			// 添加树对象
	    			d.add(1, -1, "办公管理系统");
	    			d.add(2, 1, "系统管理");
	    			d.add(4, 2, "用户管理", "javascript:parent.mainframe.addTab('tab_2', '用户管理', 'http://www.hao123.com')", "用户管理");
	    			d.add(5, 2, "角色管理", "javascript:parent.mainframe.addTab('tab_3', '角色管理', 'http://www.hao123.com')", "角色管理");
	    			d.add(6, 2, "操作管理", "javascript:parent.mainframe.addTab('tab_4', '操作管理', 'http://www.hao123.com')", "操作管理");
	    			d.add(7, 2, "流程管理", "javascript:parent.mainframe.addTab('tab_5', '流程管理', 'http://www.hao123.com')", "流程管理");
	    			
	    			d.add(3, 1, "假期管理");
	    			d.add(8, 3, "假期类型");
	    			d.add(9, 3, "假期明细");
	    			d.add(10, 3, "假期请假");
	    			d.add(11, 3, "假期审批");
	    			
	    			document.write(d);
	    			
	    			// 展开所有页面
	    			d.openAll();
	    		</script>
	    </div>
    </div>
  </body>
</html>
