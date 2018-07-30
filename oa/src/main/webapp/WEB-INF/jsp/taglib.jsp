<!-- 引入所有标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fkjava" uri="/pager-tags"%>
<!-- 定义项目路径 ,用ctx变量，不用每个页面上都写${pageContext.request.contextPath }-->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>