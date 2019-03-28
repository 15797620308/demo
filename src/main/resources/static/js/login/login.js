layui.config({
	base : "js/"
}).use(['form','layer'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){
        var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
		var msg = $("#msg").html();
		if(""==msg){
            layer.msg("验证码不通过！",{
                icon: 2,
                time: 5000 //2秒关闭（如果不配置，默认是3秒）
            });
			return false;
		}
		var url = "/user/login";
		$.post(
			url,
            data.field,
            function(data){
                layer.close(index);
                if(data=="false"){
                    layer.msg("账号或密码错误！",{
                        icon: 2,
                        time: 5000 //2秒关闭（如果不配置，默认是3秒）
                    });
                    window.location.href = "/user/test/login";
                	return;
				}
                layer.msg("验证成功！",{
                    icon: 1,
                    time: 5000 //2秒关闭（如果不配置，默认是3秒）
                });
				window.location.href = "/user/test/index";
            },
            "text"
		);
		return false;
	})
})
