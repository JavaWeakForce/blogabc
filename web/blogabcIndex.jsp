<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>_blogabc_首页</title>
		<link href="css/blog.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
<!--
.STYLE1 {
	color: #5C6321;
	font-weight: bold;
}
-->
        </style>
</head>

	<body class="marsCss1">
		<div id="container">
			<div id="header"><img src="image/blogabc_logo.jpg" alt="blogabc" width="145" height="60"></div>
			<%@ include file="/include/left.jsp"%>
			<div id="mainContent">
		      <p>.</p>
		      <table width="240" border="0" cellspacing="0" cellpadding="0">
		      <c:forEach items="${topUsersList}" var="user">
　　					${user.getName()}_____________	${user.getPoint()}      		      
		      </c:forEach>
                <tr>
                  <td width="20">1</td>
                  <td width="120">userName</td>
                  <td width="100"><span class="STYLE1">point</span></td>
                </tr>
              </table>
		      <p>&nbsp;</p>
		      <p>&nbsp;</p>
		      <p>&nbsp;</p>
		      <p>&nbsp;</p>
		      <p>&nbsp;</p>
		      <p>&nbsp;</p>
		      <p>&nbsp;</p>
		      <p>&nbsp; </p>
			</div>
	    <br class="clearfloat" />
			<div id="footer"><p align="right">
			<a href="http://blogabc.googlecode.com/"><img src="image/part.jpg" width="26" height="27" />&copy;blogabc</a>
			</p></div>
		</div>
	</body>
</html>
