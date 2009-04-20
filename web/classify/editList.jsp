<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        
        <title>_blogabc_分类首页</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
	</head>

	<body class="marsCss1">
		<div id="container">
			<%@ include file="/include/head.jsp"%>
		  	<%@ include file="/include/left.jsp"%>
      		<%@ include file="/include/right.jsp"%>
      <div id="mainContent">
		<table align="left" border="1" cellpadding="0" cellspacing="0" bordercolor="#006699">
          <c:forEach items="${classifies}" var="classify" varStatus="status">
			<tr>
			  <td width="20"><c:out value="${status.index+1}" /></td>
                <td width="280"><c:out value="${classify.name}"/></td>
                <td width="40"><a href="<%=basePath%>/classify/doEditClassfiy.do?id=${classify.id}&&userId=${classify.userId}">编辑</a></td>
              <td width="40"><a href="<%=basePath%>/classify/removeClassfiy.do?id=${classify.id}&&userId=${classify.userId}">删除</a></td>
			</tr>
		  </c:forEach>
          <tr>
          <td colspan="4" align="right"><a href="<%=basePath%>/classify/createClassfiy.do?userId=${userId}">新建</a></td>						     	  </tr>
         </table>       
         </div>
         <br/>
			<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>
