layui.use(['form','layer','laydate'], function(){
    var form = layui.form(),
     layer = parent.layer === undefined ? layui.layer : parent.layer,
        laydate = layui.laydate,
        $ = layui.jquery;

    $.post(
        "/user/stuforSelect",
        //data.field,
        function(data,status){
            if("error"==status){
                layer.msg("操作失败！");
                return;
            }
            //console.log(JSON.stringify(data));
            var studentBaseList = data.studentBaseList,
                classInfoList = data.classInfoList,
                teacherInfoList = data.teacherInfoList,
                courseInfoList = data.courseInfoList;
            var $html = "";
            $.each(studentBaseList, function (index, item) {
                $html += "<option  value='" + item.stuid + "'>" + item.stuname + "</option>";
            });
            $("select[name='studentBase.stuid']").append($html);
            $html = "";
            $.each(classInfoList, function (index, item) {
                $html += "<option  value='" + item.classid + "'>" + item.classname + "</option>";
            });
            $("select[name='classInfo.classid']").append($html);
            $html = "";
            $.each(teacherInfoList, function (index, item) {
                $html += "<option  value='" + item.teachid + "'>" + item.teachname + "</option>";
            });
            $("select[name='teacherInfo.teachid']").append($html);
            $html = "";
            $.each(courseInfoList, function (index, item) {
                $html += "<option  value='" + item.coursename + "'>" + item.coursename + "</option>";
            });
            $("select[name='subject']").append($html);
            //append后必须从新渲染
            form.render('select');
        },
        "json");

    form.on("submit(register)",function(data){
        var postWay = $("#postWay").val();
        var url = "/addEdit/studentScore?postWay="+postWay;
        //console.log(JSON.stringify(data.field));
        $.post(
            url,
            data.field,
            function(data,status){
                if("error"==status){
                    layer.msg("操作失败！",{
                        icon: 5,
                        time: 5000 //2秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                layer.msg("操作成功！",{
                    icon: 6,
                    time: 5000 //2秒关闭（如果不配置，默认是3秒）
                });
                parent.layer.close(index); //再执行关闭
                window.parent.location.reload();
            },
            "text"
        );
        return false;
    })
});