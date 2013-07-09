<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>控制面板</title>
<link href="c/style.css" rel="stylesheet" media="all" type="text/css" />
<script src="/s/jquery.min.js"></script>
<script type="text/javascript" src="jscolor/jscolor.js"></script>
<script type="text/javascript" src="/s/dashboard.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="container">
			<%@include file="headerEmbedded.jsp"%>
			<%@include file="mainNavigationEmbedded.jsp"%>
			<div id="main">
				<div class="sectionOneColumnDiv">
					<div class="sectionOneColumnTitleDiv">
						<div id="simpleConfigureTitleDiv" class="switchDivLink"
							style="background: white; border-color: white">
							<a href="#"
								onclick="switchSettingDiv('simpleConfigureTitleDiv'); return false;"
								style="text-decoration: none">简单配置</a>
						</div>
						<div id="detailEditTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchSettingDiv('detailEditTitleDiv'); return false;"
								style="text-decoration: none">精细调整</a>
						</div>
						<div id="customUploadTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchSettingDiv('customUploadTitleDiv'); return false;"
								style="text-decoration: none">自定义上传</a>
						</div>
						<div id="editHelpTitleDiv" class="switchDivLink">
							<a href="#"
								onclick="switchSettingDiv('editHelpTitleDiv'); return false;"
								style="text-decoration: none">编辑帮助</a>
						</div>
					</div>
					<div id="simpleConfigureContentDiv">
						<%@include file="dashBoardSimpleConfigureEmbedded.jsp"%>
					</div>
					<div id="detailEditContentDiv" style="display: none;">
						<%@include file="dashboardDetailEditEmbedded.jsp"%>
					</div>
					<div id="customUploadContentDiv" style="display: none;">
						<%@include file="dashBoardCustomUploadEmbedded.jsp"%>
					</div>
					<div id="editHelpContentDiv" style="display: none;">
						<%@include file="dashBoardEditHelpEmbedded.jsp"%>
					</div>
				</div>
				<br /> <br /> <br /> <br />
			</div>

			<%@include file="footerEmbedded.jsp"%>
		</div>
	</div>
</body>
</html>