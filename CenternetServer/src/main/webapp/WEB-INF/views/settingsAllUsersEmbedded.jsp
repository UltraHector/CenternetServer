<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="usersDiv">
	<table>
		<thead>
			<tr>
				<th>用户名</th>
				<th>口令</th>
				<th>登录次数</th>
				<th>上次登录时间</th>
				<th>管理</th>
			</tr>
		</thead>
		<tbody>
			<!-- TEST CODE -->
			<tr>
				<td>何健文</td>
				<td>ultrasafe</td>
				<td>16次</td>
				<td>2012-09-10 09:00</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>Hector Ren</td>
				<td>ultrahector</td>
				<td>19次</td>
				<td>2012-09-10 08:00</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>Adam Lin</td>
				<td>ultrahector</td>
				<td>17次</td>
				<td>2012-09-10 09:00</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<!-- END OF TEST CODE -->
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${ccu.password}</td>
					<td>次數</td>
					<td>上次登錄時間</td>
					<!-- TODO More field -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>