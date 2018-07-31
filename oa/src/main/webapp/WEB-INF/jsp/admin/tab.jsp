<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	
	<link rel="stylesheet" type="text/css" href="${ctx}/js/tabpanel/TabPanel.css"/>
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/tabpanel/TabPanel.js"></script>
	
  	<style type="text/css">
		html, body {
		width : 100%;
		height : 100%;
		padding : 0;
		margin : 0;
		overflow : hidden;
	</style>
	
	<script type="text/javascript">
		$(function() {
			// 创建选项卡
			window.tabPanel = new TabPanel({
				renderTo : 'tab', //承载容器
				width : '100%', 
				height : '100%',
				active : 0, //激活哪个
				maxLength : 8,  //最大选项卡数量
				items : [{
					id : 'tab_1',
					title : '用户信息',
					html : 'user信息',
					closable : false
					}]
			});

		});
		
		// 添加标签页
		var addTab = function(id, title, url) {
		
			tabPanel.addTab({
				id : id,
				title : title,
				html : "<iframe width='100%' height='100%' src='" + url +"' frameborder = '0'></iframe>"
			
				});
		}
	</script>
</head>
<body>
<div id="tab"></div>
</body>
</html>