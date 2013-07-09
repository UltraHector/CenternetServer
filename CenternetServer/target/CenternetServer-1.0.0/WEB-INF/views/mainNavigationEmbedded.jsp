<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="nav">
	<ul>
		<li><a href="/">主页</a></li>
		<li><a href="/dashboard">控制面板</a>
		  <ul>
		   <li><a href="/getAllCcu">CCU</a></li>
		   <li><a href="/">PortalPacket</a></li>
		  </ul>
		</li>
		<li><a href="/statistics">数据统计</a></li>
		<li><a href="/settings">系统设置</a></li>
		<li><a href="/support">技术支持</a></li>
		<li><a href="/register">用户注册</a></li>
		<li><a href="/pagetest">测试</a></li>
	</ul>
</div>
<!-- /navbar -->