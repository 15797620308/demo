<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
<link rel="stylesheet" href="../../css/news.css" media="all" />
<title>用户管理--CRM后台管理系统</title>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a href="../user/addUser.jsp" class="layui-btn linksAdd_btn" style="background-color:#5FB878">添加用户</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
		<div class="layui-inline">
			
		</div>
	</blockquote>
	<div class="layui-form links_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="30%">
				<col>
				<col>
				<col>
				<col>
				<col>
				<col width="13%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th style="text-align:left;">序号</th>
					<th>用户名</th>
					<th>角色</th>
					<th>操作</th>
				</tr> 
		    </thead>
		    <tbody>
		    	<tr>
		    	<td><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></td>
		    	<td>1</td>
		    	<td>周俊峰</td>
		    	<td>管理员</td>
		    	<td>
		    	<a href="" class="layui-btn layui-btn-mini links_edit"><i class="iconfont icon-edit"></i> 编辑</a>
				<a href="" class="layui-btn layui-btn-danger layui-btn-mini links_del" ><i class="layui-icon">&#xe640;</i> 删除</a>
			    </td>
		    	</tr>
		    </tbody>
		</table>
	</div>
	<!-- <div id="page"></div> -->
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="user.js"></script>
</body>
</html>