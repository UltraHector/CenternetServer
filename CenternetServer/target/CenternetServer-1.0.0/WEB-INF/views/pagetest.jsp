<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Site Title</title>
<link href="c/style.css" rel="stylesheet" media="all" type="text/css" />
<script src="/s/jquery.min.js"></script>
<script src="/s/login.js"></script>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<%@include file="headerEmbedded.jsp"%>
			<%@include file="mainNavigationEmbedded.jsp"%>
			<div id="preview">
				<div id="previewBlock" style="background: red">
					<div id="previewBlockInside">
						<h3 style="background: green">你好</h3>
						<img src="/i/no_scan_result.PNG" width="165px"></img>
						<p>好好学习， 天天向上， 好好学习， 天天向上， 好好学习， 天天向上,好好学习， 天天向上， 好好学习， 天天向上，
							好好学习， 天天向上</p>
					</div>
				</div>
			</div>
			<%@include file="footerEmbedded.jsp"%>
		</div>
		<!-- /container -->
	</div>
	<!-- /wrapper -->
</body>
</html>
