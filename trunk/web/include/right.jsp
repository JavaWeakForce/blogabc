<%@ page contentType="text/html; charset=utf-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1;
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		  <div id="mainContent">
			<h1 align="right">${user}的博客</h1>
                  <div id="sidebar2">
                  <p><a href="<%=basePath1%>/blog/blog.do?id=${userId}">${user}的博文</a></p>
                  <p><a href="<%=basePath1%>/classify/classify.do?id=${userId}">${user}的分类</a></p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
                  <p>&nbsp;</p>
            </div>