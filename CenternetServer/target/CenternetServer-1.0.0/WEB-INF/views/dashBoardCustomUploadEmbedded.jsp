<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="portalPacket">
	<div id="customUploadPortalPacketForm">
		<form action="/editPortalPacketForm" method="POST"
			enctype="multipart/form-data" onsubmit="return customUploadInputValidation();">
			<input type="file">
			
		</form>
	</div>
	<c:choose>
		<c:when test="empty ${portalPacket}">
			<%@include file="dashBoardNullPreviewEmbedded.jsp"%>
		</c:when>
		<c:otherwise>
			<%@include file="dashBoardPreviewEmbedded.jsp"%>
		</c:otherwise>
	</c:choose>
</div>