<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sectionOneColumnDiv">
	<div class="sectionOneColumnTitleDiv">
		<h3
			style="padding-left: 15px; float: left; padding-top: 5px; color: white;">CCU管理</h3>
		<h5 style="padding-left: 10px; float: left; padding-top: 7px; color: white;">共6个CCU</h5>
		<button
			style="float: right; margin-right: 30px; margin-top: 2px;">添加CCU</button>
	</div>
	<table>
		<thead>
			<tr>
				<th>名称</th>
				<th>地址</th>
				<th>口令</th>
				<th>状态</th>
				<th>控制</th>
			</tr>
		</thead>
		<tbody>
			<!-- TEST CODE -->
			<tr>
				<td>图书馆CCU</td>
				<td>暨南大学科技路图书馆</td>
				<td>library</td>
				<td>在线</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>礼堂CCU</td>
				<td>广州市文汇路336</td>
				<td>peach</td>
				<td>分离</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>购物天堂CCU</td>
				<td>暨南大学体育系</td>
				<td>fddasfjio</td>
				<td>分离</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>图书馆CCU</td>
				<td>暨南大学科技路图书馆</td>
				<td>library</td>
				<td>在线</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>礼堂CCU</td>
				<td>广州市文汇路336</td>
				<td>peach</td>
				<td>在线</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<tr>
				<td>购物天堂CCU</td>
				<td>暨南大学体育系</td>
				<td>library</td>
				<td>在线</td>
				<td style="text-align: center;"><img src="i/edit.png" alt="修改"
					title="修改" width="20" height="20"> &nbsp; <img
					src="i/remove.png" alt="删除" title="删除" width="20" height="20">
				</td>
			</tr>
			<!-- END OF TEST CODE -->
			<c:forEach items="${ccus}" var="ccu">
				<tr>
					<td>${ccu.unitName}</td>
					<td>${ccu.address}</td>
					<!-- TODO More field -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>