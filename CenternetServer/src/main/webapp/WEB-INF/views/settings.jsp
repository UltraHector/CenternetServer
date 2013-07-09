<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>系统设置</title>
<link href="/c/style.css" rel="stylesheet" media="all" type="text/css" />
<script src="/s/jquery.min.js"></script>
<script src="/s/login.js"></script>
<link rel="stylesheet" href="c/chartStyle.css" type="text/css">
<link href="c/table.css" rel="stylesheet" media="all" type="text/css">
<script src="s/settings.js" type="text/javascript"></script>
</head>
<body>
	<div id="wrapper">
		<div id="container">
			<%@include file="headerEmbedded.jsp"%>
			<%@include file="mainNavigationEmbedded.jsp"%>
			<div id="main">
			  <div class="sectionOneColumnDiv">
				<div class="sectionOneColumnTitleDiv">
					<div id="allUsersDiv" class="switchDivLink" style="background:white;border-color:white">
					  <a href="#" onclick="switchSettingDiv('allUsersDiv'); return false;" style="text-decoration: none">用户管理</a>
					</div>
					<div id="allSystemConfigsDiv" class="switchDivLink">
					  <a href="#" onclick="switchSettingDiv('allSystemConfigsDiv'); return false;" style="text-decoration: none">系统配置</a>
					</div>
				</div>
				<%@include file="settingsAllUsersEmbedded.jsp"%>
				<%@include file="settingsSystemConfigsEmbedded.jsp"%>
			  </div>
			</div>
			<br /> <br /> <br /> <br />
			<!-- /columns-wrapper -->
			<%@include file="footerEmbedded.jsp"%>
		</div>
		<!-- /container -->
	</div>
	<!-- /wrapper -->

</body>
</html>
