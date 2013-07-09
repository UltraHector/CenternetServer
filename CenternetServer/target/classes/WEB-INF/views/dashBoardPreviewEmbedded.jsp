<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="preview">
	<div id="previewBlock">
		<div id="previewBlockInside">
			<h3 id="PreVeiwHeader"
				style="background:#${portalPacket.portalPacketHead.portalPacketTitleColor};
			font-family:${portalPacket.portalPacketHead.portalPacketTitleFontStyle};">
				${portalPacket.portalPacketHead.portalPacketTitle}</h3>
			<img id="previewImage" src="/getPortalImage/${portalPacket.id}" />
			<video id="previewVideo" width="160" height="120" controls poster=i/bodybaackground.jpeg>
			</video>
			<div id="description">${portalPacket.portalPacketBody.portalPacketContent}</div>
			<div id="footerdescription">${portalPacket.portalPacketBody.portalPacketFooter}</div>
		</div>
	</div>
</div>