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
<title>消息回复--CRM后台管理系统</title>
</head>
<body class="childrenBody">
	<form class="layui-form">
		<div class="replay_edit">
			<textarea class="layui-textarea" id="msgReply"></textarea>
			<a class="layui-btn send_msg">发送</a>
		</div>
		<table class="layui-table msg_box" lay-skin="line">
			<colgroup>
				<col width="50%">
				<col width="30%">
				<col>
			</colgroup>
			<tbody class="msgReplyHtml"></tbody>
		</table>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="../../../static/js/message/message.js"></script>
</body>
</html>