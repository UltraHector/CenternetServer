<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>中网</title>
<link href="/c/style.css" rel="stylesheet" media="all" type="text/css" />
<script src="/s/jquery.min.js"></script>
<script src="/s/login.js"></script>
<link rel="stylesheet" href="c/chartStyle.css" type="text/css">
<script src="s/amcharts.js" type="text/javascript"></script>
</head>

<body>
	<div id="wrapper">
		<div id="container">
			<%@include file="headerEmbedded.jsp"%>
			<%@include file="mainNavigationEmbedded.jsp"%>
			<div id="main">
				<div class="twoColumnContent">
					<div class="rightColumn">
						<%@include file="indexAlertAndNoticeEmbedded.jsp"%>
						<br /> <br />
					</div>
					<div class="leftColumn">
						<%@include file="indexStatisticsVisitEmbedded.jsp"%>
					</div>
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
