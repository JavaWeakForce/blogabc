<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
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
#apDiv1 {
	position:absolute;
	width:602px;
	height:265px;
	z-index:1;
	left: 280px;
	top: 80px;
}

#apDiv4 {
	position:absolute;
	width:602px;
	height:265px;
	z-index:1;
	left: 280px;
	top: 360px;
}

#apDiv2 {
	position:absolute;
	left:280px;
	top:650px;
	width:255px;
	height:320px;
	z-index:2;
}
#apDiv3 {
	position:absolute;
	left:550px;
	top:650px;
	width:255px;
	height:320px;
	z-index:3;
}
-->
        </style>
</head>

	<body class="marsCss1">
    <div id="container">
    <div id="header">
				<img src="image/blogabc_logo.jpg" alt="blogabc" width="145"
					height="60">
			</div>
			<%@ include file="/include/left.jsp"%>
            
<div id="mainContent">
        <div id="apDiv1">
          <table width="600" height="267" border="1" cellpadding="0" cellspacing="0" bordercolor="#0066CC">
            <tr>
              <td height="37">专题</td>
            </tr>
            <tr>
              <td valign="top">专题内容：</td>
            </tr>
          </table>
        </div>
  
  <div id="apDiv4">
            <table width="600" height="267" border="1" cellpadding="0" cellspacing="0" bordercolor="#0066CC">
            <tr>
              <td height="37">最新博文</td>
            </tr>
            <tr>
              <td valign="top">
              ×××××××××××××××××××
			</td>
            </tr>
          </table>
  </div>
  <div id="apDiv2">
                热文榜
<table width="240" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFF99">
					<c:forEach items="${topUsersList}" var="user" varStatus="status">
						<tr>
							<td width="20">
								<c:out value="${status.index+1}" />
							</td>
							<td width="120">
								<a href="<%=basePath%>/user/user.do?id=${user.id}">
								<c:out value="${user.firstName}· ${user.lastName}"/>
								</a>
							</td>
							<td width="100">
								<span class="STYLE1"><c:out value="${user.point}" />
								</span>
							</td>
						</tr>
					</c:forEach>
  		  </table>
        </div>
  <div id="apDiv3">
        		红人榜
<table width="240" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFCCFF">
			  <c:forEach items="${topUsersList}" var="user" varStatus="status">
						<tr>
							<td width="20">
								<c:out value="${status.index+1}" />
							</td>
							<td width="120">
								<a href="<%=basePath%>/user/user.do?id=${user.id}">
								<c:out value="${user.firstName}· ${user.lastName}"/>
								</a>
							</td>
							<td width="100">
								<span class="STYLE1"><c:out value="${user.point}" />
								</span>
							</td>
						</tr>
					</c:forEach>
		  		</table>
    </div>
    

			
		
				
			  <p>&nbsp;					
			  </p>
				
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			  <p>&nbsp;
					
			  </p>
				<p>&nbsp;
					
				</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
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
			<div id="footer">
				<p align="right">
					<a href="http://blogabc.googlecode.com/"><img
							src="image/part.jpg" width="26" height="27" />&copy;blogabc</a>
				</p>
			</div>
		</div>
	</body>
</html>
