layui.use(['form','layer','laydate'], function(){
    var form = layui.form,
     layer = parent.layer === undefined ? layui.layer : parent.layer,
        laydate = layui.laydate,
        $ = layui.jquery;

    /*laydate.render({
        elem: '#start'
        ,type: 'datetime'
        //, max: 'nowTime'
    });
    laydate.render({
        elem: '#grade'
        ,type: 'year'
        , max: 'nowTime'
    });

    laydate.render({
        elem: '#end'
        //,type: 'datetime'
        //, max: 'nowTime'
    });*/


    form.on("submit(register)",function(data){
        var postWay = $("#postWay").val();
        var url = "/addEdit/selectCourse?postWay="+postWay;
        //console.log(JSON.stringify(data.field));
        $.post(
            url,
            data.field,
            function(data,status){
                if("error"==status){
                    layer.msg("操作失败！",{
                        icon: 2,
                        time: 5000 //2秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭
                layer.msg("操作成功！",{
                    icon: 1,
                    time: 5000 //2秒关闭（如果不配置，默认是3秒）
                });
                window.parent.location.reload();
            },
            "text"
        );
        return false;
    })
});