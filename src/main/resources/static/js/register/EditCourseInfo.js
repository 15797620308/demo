layui.use(['form','layer','laydate'], function(){
    var form = layui.form,
     layer = parent.layer === undefined ? layui.layer : parent.layer,
        laydate = layui.laydate,
        $ = layui.jquery;
    form.verify({
        username: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
            if(null==value||""==value){
                return '用户名不能为空';
            }
        }

        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        ,pass: [
            /^[a-zA-Z0-9]{6,12}$/
            ,'密码必须6到12位，且由字母和数字任意组成'
        ]
        ,account: [
            /^[a-zA-Z0-9]{6,12}$/
            ,'账号必须6到12位，且由字母和数字任意组成'
        ]
        ,role: [
            /^[\u4e00-\u9fa5]+$/
            ,'必须选择角色'
        ]
        ,code:[
            /^[0-9]+$/
            ,'编号必须为数字'
        ]
    });

    laydate.render({
        elem: '#grade'
        ,type: 'year'
        , max: 'nowTime'
    });

    form.on("submit(register)",function(data){
        var postWay = $("#postWay").val();
        var url = "/addEdit/courseInfo?postWay="+postWay;
        //console.log(JSON.stringify(data.field));
        $.post(
            url,
            data.field,
            function(data,status){
                if("error"==status){
                    layer.msg("操作失败！");
                    return;
                }
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
                layer.msg("操作成功！");
                window.parent.location.reload();
            },
            "text"
        );
        return false;
    })
});