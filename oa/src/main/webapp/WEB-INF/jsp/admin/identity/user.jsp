<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/common/commons.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/css/common/pager.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
	
	<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			// 加载完成时关闭弹出框
			$("#divDialog").dialog("close");
			
			// 异步请求填充部门下拉列表
			$.getJSON("${ctx}/admin/identity/loadDeptAjax.jspx", function(data, status){
				// alert(status+"=="+data);
				// 获取用户当前选中的部门
				var deptId = "${user.dept.id}"
				// alert(deptId);
				if(status == "success") {
					$.each(data, function(){
						$("<option/>").val(this.id).text(this.name).attr("selected", this.id == deptId).appendTo("#deptSelect");
					});
				}
			});
			
			
		
			// 为tr绑定onmouseover和onmouseout事件,hover集成了两个事件
			$("tr[id^='tr_']").hover( // 匹配tr_开头的id,class选择器，所有的行
				// onmouseover 移入
				function() {
					$(this).css({"cursor":"pointer", "backgroundColor":"#FFFFBF"});
				},
				// onmouseout 移出
				function() {
					// 当前行checkbox选中就不还原颜色
					if (!$(this).find("input[id^='box_']").attr("checked")) {  // 选中的id $()把dom元素this转换成jq元素
						$(this).css("backgroundColor", "#FFFFFF");
					}
				}	
			);
			
			// 为全选绑定事件
			$("#checkAll").click(function() {
				$("input[id^='box_']").attr("checked", this.checked);  // 类选择器
				// 获取下面tr的所有checkbox
				$("input[id^='box_']").trigger(this.checked ? "mouseover" : "mouseout");
			});
			
			// 让全选选中
			// 获取下面tr的所有checkbox
			var boxs = $("input[id^='box_']");
			// 绑定点击事件
			boxs.click(function() {
				$("#checkAll").attr("checked", boxs.length == boxs.filter(":checked").length);  // 选中的box的长度和box的长度相等,filter过滤器
			});
			
			// 添加用户
			$("#addUser").click(function() {
				$("#divDialog").dialog({
					title : "添加用户", // 标题
					width : 540,
					height : 290,
					collapsible : true,
					maximizable : true,
					model : true,
					onClose : function() {
					// 	alert("sdd");
					}
				});
				
				// 现实iframe
				$("#dialogFrame").attr("src", "${ctx}/admin/identity/showAddUser.jspx").show(100);
			});
				
		});
		
	</script>
	
<title>办公管理系统-用户管理</title>
</head>
<body>
	<!-- 工具按钮区 -->
	<s:form action="selectUser.jspx" method="post" theme="simple" namespace="/admin/identity/">
		<table>
			<tr>
				<td><input type="button" value="添加" id="addUser" /></td>
				<td><input type="button" value="修改" /></td>
				<td><input type="button" value="删除" /></td>
				<td>状态:<s:select list="#{1 : '审核', 2 : '不通过', 3 : '冻结'}" /></td>
				<td><input type="button" value="审核" /></td>
				<td>姓名:<s:textfield name="user.name" size="12" /></td>
				<td>手机号码:<s:textfield name="user.phone" size="12" /></td>
				<td>部门:<select id="deptSelect" name="user.dept.id"><option value="0">==请选择部门==</option></select></td>
				<td><input type="submit" value="查询"/></td>
			</tr>
		</table>
	</s:form>
	
	<!-- 数据展示区 -->
	<!-- cellpadding行  cellspacing列-->
	<table width="100%" cellpadding="5px" cellspacing="1" style="background-image: url('${ctx}/images/system/t2.jpg');">
		<tr>
			<!-- 表头 -->
			<th><input type="checkbox" id="checkAll"/>全部</th> 
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>部门</th>
			<th>职位</th>
			<th>邮箱</th>
			<th>手机号码</th>
			<th>状态</th>
			<th>创建日期</th>
			<th>创建人</th>
			<th>审核日期</th>
			<th>审核人</th>
		</tr>
		
		<tbody style="background-color: #FFFFFF">
			<s:iterator value="users" status="stat">
				<tr id="tr_${stat.index}">
					<td><input type="checkbox" id="box_${stat.index}" />${stat.count}</td>
					<td><s:property value="userId" /></td>
					<td><s:property value="name" /></td>
					<td>${sex ==1 ? '男' : '女'}</td>
					<td><s:property value="dept.name" /></td>
					<td><s:property value="job.name" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="phone" /></td>
					<td>
						<s:if test="status == 0">
							<font color="red">新建</font>
						</s:if>
						<s:elseif test="status == 1">审核</s:elseif>
						<s:elseif test="status == 2">不通过</s:elseif>
						<s:else>冻结</s:else>
					</td>
					<td><s:date name="createDate" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td><s:property value="creater.name" /></td>
					<td><s:date name="checkDate" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td><s:property value="checker.name" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<!-- 分页标签 -->
	<fkjava:pager pageIndex="${pageModel.pageIndex }" 
				  pageSize="${pageModel.pageSize }" 
				  recordCount="${pageModel.recordCount }" 
				  submitUrl="${ctx}/admin/identity/selectUser.jspx?pageModel.pageIndex={0}&user.name=${user.name}&user.phone=${user.phone}&user.dept.id=${user.dept.id }" />

	<!-- 用div做弹出窗口 -->
	<div id="divDialog" class="easyui-dialog" style="overflow: hidden;" >
		<iframe id="dialogFrame" width="100%" height="100%" style="display: none;" ></iframe>
	</div>
</body>
</html>