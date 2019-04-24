layui.use(['table','layer','form'],function(){
    var table=layui.table;
    var layer = layui.layer;
    var form = layui.form;
    var laypage = layui.laypage;
    var data;  //保存数据
    var jsondata;
    var $ = layui.jquery;
    var postData={
        object:"teacherInfo",
        pageNumber:1,
        pageSize:1,
        filterData:null

    };

    //发送ajax  列表查询ajax
    function send(postData){
        $.ajax({
            type: "POST",//请求的方式
            url: "/user/getdatas",//请求的接口
            data: postData,//参数（可传可不传递）
            dataType: "json",//数据类型
            async:false,
            success: function (res) {
                data=res.tabledatas;
                jsondata = res;
                //console.log(JSON.stringify(jsondata));
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                //失败之后执行（我不管，失败别找我i）
                alert("数据不存在");
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);


            }
        })
    }
    var
        // 表单需要的变量
        infoOptions = {
            elem: '#test',
            //limits: [10],
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            toolbar:true,
            //page: true,
            //limit: 1,//每页默认显示的数量
            cols: [[
                //{field: 'id', title: 'ID',width:20, fixed: 'left'}
                { type:'checkbox', width:'5%', fixed: 'left'}
                ,{field: 'teachid', title: '编号', width:'10%', sort: true, fixed: 'left'}
                ,{field: 'teachname', title: '姓名', width:'10%',edit:'text'}
                ,{field: 'teachsex', title: '性别', width:'10%'}
                ,{field: 'teachage', title: '年龄', width:'10%',edit:'text'}
                ,{field: 'mantry', title: '入职时间', width:'10%'}
                ,{field: 'iswork', title: '在职情况', width:'10%'}
                ,{field: 'phone', title: '联系方式', width:'10%'}
                ,{field: 'position', title: '职务', width:'10%'}
                ,{fixed: 'right',title: '操作', width:'15%', align:'center', toolbar: '#barDemo', hide : ishide}
            ]],
            data: [],
            loading:true
        };
    // -------------------------页面初始化--------------------------------
    // 表格初始化 ------------------
    function init (){
        // 列表请求
        send(postData);
        // 完成表格数据
        $.extend(infoOptions, {data: data});
        table.render(infoOptions);
        data=null;
    }
    //  分页--------------------
    function page() {
        laypage.render({
            elem: 'page',
            limits: [1, 2, 30, 40, 50],
            prev: "<<",
            next: ">>",
            theme: "#0099ff",
            layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'],
            groups: 2,
            curr: 1,
            limit: 1
            ,count: jsondata.countNum //数据总数，从服务端得到
            ,jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                //console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                //console.log(obj.limit); //得到每页显示的条数
                $.extend(postData, {pageNumber: obj.curr, pageSize: obj.limit});
                init();
                //首次不执行
                if (!first) {
                    //do something
                }
            }
        });
    }
    // 页面初始化---------------------------------
    init();
    page();


    //各种事件
    var active = {
        reload: function(){
            var filterData = $('#filterData').val();
            $.extend(postData,{filterData:filterData});
            init();
            page();
        },
        deLink:function () {
                          var checkStatus=table.checkStatus('test'),
                                  data=checkStatus.data,
                                  deList= new Array();
                          data.forEach(function(n){
                              deList.push(n.teachid);
                              });
                          //console.log(deList);
                         if(deList!=''){
                                  layer.confirm('确定删除所选项吗？',function (index) {
                                          $.ajax({
                                                 url: '/user/batchdel',
                                                 type:'post',
                                                  dataType:'json',
                                                 data:{arr:deList.toString(),object:"teacherInfo"},
                                                  success:function (data) {
                                                      if(data.code=='0'){
                                                          layer.msg('删除成功');
                                                          init();
                                                          page();
                                                          }else{
                                                              layer.msg('删除失败');
                                                          }
                                                  },
                                              error:function () {
                                                      layer.msg('系统错误');
                                                  }
                                          })
                                     })
                              }else{
                                 layer.tips('请选择需要删除的行',$('#filterData'),{
                                          tips:[3,'#5fb878']
                                  })
                             }
                    },
        add:function(){
            layer.open(
                {
                    type: 2,
                    title: '添加页面',
                    skin: 'layui-layer-molv',
                    shadeClose: false,
                    shade: 0.8,
                    area: ['380px','485px'],
                    resize:true,
                    content: "/user/edit/EditTeacherInfo",//跳转的页面
                    success: function (layero, index) {
                        // 获取子页面的iframe
                        var iframe = window['layui-layer-iframe' + index];

                    }

                });
        }
    };


    // 查询         ----------------------------------------
    //监听提交  
    $(document).on('click',"#search_btn", function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听批量删除
    $(document).on('click',"#batchDel", function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听添加
    $(document).on('click',"#add", function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //  操作  查看 编辑 删除-----------------------------------

    //监听工具条
    table.on('tool(test)', function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if (layEvent == 'edit')
        {
            //console.log(data);
            layer.open(
                {
                    type: 2,
                    title: '编辑页面',
                    skin: 'layui-layer-molv',
                    shadeClose: false,
                    shade: 0.8,
                    area: ['380px','485px'],
                    resize:true,
                    content: "/user/edit/EditTeacherInfo",//跳转的页面
                    success: function (layero, index) {
                        // 获取子页面的iframe
                        var iframe = window['layui-layer-iframe' + index];
                        // 向子页面的全局函数child传参
                        iframe.setData(data);

                    }

                });
            //注：在这里我不就做修改界面了  这里这只是一个弹出框  弹出你的修改页面  Content中你自定义自己的页面路径并传参数
        } else//删除数据
        {
            layer.confirm('真的删除行么', function(index){
                $.post("/user/deldata",{id:data.teachid,object:"teacherInfo" },
                function(msg){
                    if(msg.code==1){
                        //obj.del();//删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        layer.msg('删除成功！');
                        init();
                        page();
                    }else{
                        layer.msg('删除失败！');
                    }
                },"json");
        });
        }
    });

    //监听工具条 ----------------------------------------------- ENd-----------------------------------------------------------

    })

//end    