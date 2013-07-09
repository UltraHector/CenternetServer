<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="portalPacket">
	<div id="editPortalPacketForm">
		<form action="/editPortalPacketForm" method="POST"
			enctype="multipart/form-data" onsubmit="return inputValidation();">
			<table id="eidtFormTable">
				<tr>
					<td>输入标题 ：</td>
				</tr>
				<tr>
					<td><input type="text" size="30" id="portalPacketTitle"
						name="portalPacketTitle"></td>
					<td><select name="portalPacketTitleFontStyle"
						id="portalPacketTitleFontStyle">
							<option value="Georgia">Georgia</option>
							<option value="Times New Roman">Times New Roman</option>
							<option value="Sans-serif">Sans-serif</option>
					</select></td>
					<td><input id="font_color" class="color"
						name="portalPacketTitleColor" size="5" /></td>
				</tr>
				<tr>
					<td><br />*添加视觉</td>
				</tr>
				<tr>
					<td><input type="file" name="videoOrImageFileName"
						id="videoOrImageFileName"></td>
					<td><select name="videoOrImageType" id="videoOrImageType">
							<option value="image">图片文件</option>
							<option value="video">视频文件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select></td>
				</tr>
				<tr>
					<td><br />*添加听觉</td>
				</tr>
				<tr>
					<td><input type="file" name="audioFileName"></td>
					<td></td>
				</tr>
				<tr>
					<td><br />添加文字</td>
				</tr>
				<tr>
					<td colspan="3"><textarea style="resize: none;"
							id="portalPacketContent" name="portalPacketContent" rows="3"
							cols="41"></textarea>
				</tr>
				<tr>
					<td><br />添加页脚</td>
				</tr>
				<tr>
					<td colspan="3"><input type="text" size="50"
						id="portalPacketFooter" name="portalPacketFooter"></td>
				</tr>
				<tr>
					<td align="right"><br /> <input type="button" id="previewbtn"
						value="效果预览"></td>
					<td align="left"><br /> <input type="submit" value="确认更新"></td>
					<td></td>
				</tr>
			</table>
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