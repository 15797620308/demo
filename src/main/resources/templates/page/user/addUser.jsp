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
<style type="text/css">
	.layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
	@media(max-width:1240px){
		.layui-form-item .layui-inline{ width:100%; float:none; }
	}
</style>
<title>会员添加--CRM后台管理系统</title>
</head>
<body class="childrenBody">
	<form action="" method="post" class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">登录名</label>
			<div class="layui-input-block">
				<input name="" type="text" class="layui-input userName" lay-verify="required" placeholder="请输入登录名">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input name="" type="text" class="layui-input userEmail" lay-verify="email" placeholder="请输入邮箱">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block userSex">
			      	<input type="radio" name="sex" value="男" title="男" checked>
			      	<input type="radio" name="sex" value="女" title="女">
			      	<input type="radio" name="sex" value="保密" title="保密">
			    </div>
		    </div>
		    <div class="layui-inline">
			    <label class="layui-form-label">会员等级</label>
				<div class="layui-input-block">
					<select name="userGrade" class="userGrade" lay-filter="userGrade">
						<option value="0">注册会员</option>
						<option value="1">中级会员</option>
				        <option value="2">高级会员</option>
				        <option value="3">超级会员</option>
				    </select>
				</div>
		    </div>
		    <div class="layui-inline">
			    <label class="layui-form-label">会员状态</label>
				<div class="layui-input-block">
					<select name="userStatus" class="userStatus" lay-filter="userStatus">
						<option value="0">正常使用</option>
						<option value="1">限制用户</option>
				    </select>
				</div>
		    </div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站点描述</label>
			<div class="layui-input-block">
				<textarea name="" placeholder="请输入站点描述" class="layui-textarea linksDesc"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="submit" value="立即提交" class="layui-btn" />
				<input type="reset" value=重置 class="layui-btn layui-btn-primary" />
				<!-- <button class="layui-btn" lay-submit="" lay-filter="addUser">立即提交</button> -->
				<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="addUser.js"></script>
</body>
</html>