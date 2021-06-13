<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>/static/layui/css/layui.css">
    <script src="<%=basePath%>/static/layui/layui.js"></script>

    <style>
        /*.table_context{
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            width:1050px;
            border-collapse:collapse;
        }

        .table_context td,.table_context th{
            font-size:1em;
            padding:3px 7px 2px 7px;
        }
        .table_context th{
            font-size:10px;
            text-align:center;
            padding-top:5px;
            padding-bottom:4px;
            background-color:#ccc;
            color:#ffffff;
        }
        .table_context td{
            border-bottom: solid #ccc 1px;
        }*/
        input[type="checkbox"] {
            width: 15px;
            height: 15px;
            display: inline-block;
            text-align: center;
            vertical-align: middle;
            line-height: 18px;
            margin-right: 10px;
            position: relative;
        }

        input[type="checkbox"]::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            background: #fff;
            width: 100%;
            height: 100%;
            border: 1px solid #d9d9d9;
        }

        input[type="checkbox"]:checked::before {
            content: "\2713";
            background-color: #fff;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            border: 1px solid #7D7D7D;
            color: #7D7D7D;
            font-size: 20px;
            font-weight: bold;
        }

    </style>

   <%-- <style>
        .inner-container {
            position: absolute; left: 0;
            overflow-x: hidden;
            overflow-y: scroll;
        }
        /* for Chrome 只针对谷歌浏览器*/
        .inner-container::-webkit-scrollbar {
            display: none;
        }
    </style>--%>
    <script>
        function getiframe(url){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.open({
                    offset:'100px',
                    type: 2,
                    maxmin: true,
                    shadeClose: true, //点击遮罩关闭层
                    area : ['800px' , '500px'],
                    content: url //这里content是一个普通的String
                });
            })
        }

        function changeStatus(jobnumber,Status) {
            ajaxRequest(jobnumber,Status);
        }

        function ajaxRequest( jobnumber,status) {
            var ajax;
            if(window.XMLHttpRequest){//火狐
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie
                ajax=new ActiveXObject("Msxml2.XMLHTTP");
            }
            //复写onreadystatechange函数
            ajax.onreadystatechange=function(){
                //判断Ajax状态码
                if(ajax.readyState==4){
                    //判断响应状态吗
                    if(ajax.status==200){
                        //获取响应内容
                        var result=eval(ajax.responseText);
                        //alert(result);
                        //处理响应内容
                        if(result){
                            window.location.reload();
                            //alert("正确");
                        }else{
                            alert("修改失败");
                        }
                        //获取元素对象
                    }else if(ajax.status==404){
                        alert("请求资源不存在")
                    }else if(ajax.status==500){
                        alert("服务器繁忙")
                    }
                }
            }

            ajax.open("post", "/operator/changeStatus.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("jobnumber="+jobnumber+"&vaild="+status);
        }


        function changepagesize() {
            var pageisze=document.getElementById("pageisze");
            var index=pageisze.selectedIndex;
            var limit = pageisze.options[index].value; // 选中值
            location.href="main.do?limit="+limit;
        }


        function deleleAcademic(){
            var checkbox = document.getElementsByName('academicId');
            var url="";
            for (var i = 0; i < checkbox.length; i++) {
                if (checkbox[i].checked) {
                    url+="academicId="+checkbox[i].value+"&";
                }
            }
            url=url.substring(0,url.length-1);
            deleteajaxRequest(url);
        }
        function deleteajaxRequest(url) {
            var ajax;
            if(window.XMLHttpRequest){//火狐
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie
                ajax=new ActiveXObject("Msxml2.XMLHTTP");
            }
            //复写onreadystatechange函数
            ajax.onreadystatechange=function(){
                //判断Ajax状态码
                if(ajax.readyState==4){
                    //判断响应状态吗
                    if(ajax.status==200){
                        //获取响应内容
                        var result=eval(ajax.responseText);
                        //alert(result);
                        //处理响应内容
                        if(result){
                            window.location.reload();
                            alertmessage("删除成功");
                            //alert("正确");
                        }else{
                            alertmessage("删除失败");
                        }
                        //获取元素对象
                    }else if(ajax.status==404){
                        alert("请求资源不存在")
                    }else if(ajax.status==500){
                        alert("服务器繁忙")
                    }
                }
            }

            ajax.open("get", "/plateNumber/delete.do?"+url);
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send();
        }

        function deleteOnePlateNumber(academicId){
            deletajax(academicId);
        }

        function deletajax( jobnumber ,obj) {
            var ajax;
            if(window.XMLHttpRequest){//火狐
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie
                ajax=new ActiveXObject("Msxml2.XMLHTTP");
            }
            //复写onreadystatechange函数
            ajax.onreadystatechange=function(){
                //判断Ajax状态码
                if(ajax.readyState==4){
                    //判断响应状态吗
                    if(ajax.status==200){
                        //获取响应内容
                        var result=eval(ajax.responseText);
                        //alert(result);
                        //处理响应内容
                        if(result){
                            // window.location.reload();
                            alert("删除成功");
                            obj.del();
                        }else{
                            alert("删除失败");
                        }
                        //获取元素对象
                    }else if(ajax.status==404){
                        alert("请求资源不存在")
                    }else if(ajax.status==500){
                        alert("服务器繁忙")
                    }
                }
            }

            ajax.open("post", "/operator/delete.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("jobnumber="+jobnumber);
        }

        function alertmessage(inform){
            layui.use('layer', function() {
                var layer = layui.layer;
                layer.msg(inform);
            });
        }

        function checkAll() {
            var checkALl=document.getElementById("check_all_box");
            var checkbox = document.getElementsByName('academicId');
            if(checkALl.checked) {
                for (var i = 0; i < checkbox.length; i++) {
                    if (!checkbox[i].checked) {
                        checkbox[i].checked = true;
                    }
                }
            }else{
                for (var i = 0; i < checkbox.length; i++) {
                    if (checkbox[i].checked) {
                        checkbox[i].checked = false;
                    }
                }
            }
        }

        function search() {
            var searchById=document.getElementById("searchById").value;
            layui.use("table",function () {
                var table = layui.table;

                table.render({
                    elem: "#plateNumber_table",                 //容器id
                    url: "/syslog/userlog.do?jobnumber="+searchById,  //数据接口
                    cols: [[
                        {field: 'num', type: "numbers"},
                        {field: 'visitTime', title: '访问时间', sort: true, width: 120},
                        {field: 'jobnumber', title: '工号', width: 200},
                        {field: 'ip', title: 'ip地址', width: 100},
                        {field: 'url', title: 'url地址', width: 200},
                        {field: 'executionTime', title: '执行时间', width: 100},
                        {field: 'method', title: '执行方法', width: 600},
                        // {field:"操作",toolbar:"#bar",fixed:"right",width:300}           //设置表头工具栏
                    ]],
                    page: true,    //开启分页
                    limits: [3, 5, 10],  //一页选择显示3,5或10条数据
                    limit: 10,  //一页显示10条数据
                    parseData: function (res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                        var result;
                        console.log(this);
                        console.log(JSON.stringify(res));
                        if (this.page.curr) {
                            result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                        } else {
                            result = res.data.slice(0, this.limit);
                        }
                        return {
                            "code": res.code, //解析接口状态
                            "msg": res.msg, //解析提示文本
                            "count": res.count, //解析数据长度
                            "data": result //解析数据列表
                        };
                    },
                    //设置表格工具栏
                    toolbar: "#toolbar"
                });
            }
            )
        }
    </script>

</head>
<body style=" overflow-x:hidden;"  class="inner-container">
<div style="color: #666;">

    <table id="plateNumber_table"  lay-filter="headtoolbar"></table>

    <script type="text/html" id="toolbar">
        <div>
            <div class="layui-btn-container" style="float: left">
                <button class="layui-btn layui-btn-sm" lay-event="findAll">全部</button>
            </div>
            <div style="float: left">
                <input type="text" id="searchById" name="searchById" placeholder="输入工号查找"  class="layui-input" onchange="search()" style="width: 150px;height: 30px" >
            </div>
        </div>
    </script>

    <script type="text/html" id="bar">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="forbid">禁用</a>
    </script>

    <script type="text/javascript">
        layui.use("table",function () {
                var table=layui.table;

                table.render({
                    elem:"#plateNumber_table",                 //容器id
                    url:"/syslog/datamain.do",  //数据接口
                    cols:[[
                        {field:'num',type:"numbers"},
                        {field:'visitTime',title:'访问时间',sort:true,width:120},
                        {field:'jobnumber',title:'工号',width:200},
                        {field:'ip',title:'ip地址',width:100},
                        {field:'url',title:'url地址',width:200},
                        {field:'executionTime',title:'执行时间',width:100},
                        {field:'method',title:'执行方法',width:600},
                        // {field:"操作",toolbar:"#bar",fixed:"right",width:300}           //设置表头工具栏
                    ]],
                    page:true,    //开启分页
                    limits: [3,5,10],  //一页选择显示3,5或10条数据
                    limit: 10,  //一页显示10条数据
                    parseData: function(res){ //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                            var result;
                            console.log(this);
                            console.log(JSON.stringify(res));
                            if(this.page.curr){
                                result = res.data.slice(this.limit*(this.page.curr-1),this.limit*this.page.curr);
                            }
                            else{
                                result=res.data.slice(0,this.limit);
                            }
                            return {
                                "code": res.code, //解析接口状态
                                "msg": res.msg, //解析提示文本
                                "count": res.count, //解析数据长度
                                "data": result //解析数据列表
                            };
                    },
                    //设置表格工具栏
                    toolbar:"#toolbar"
                });

                //头监听事件
                table.on('toolbar(headtoolbar)',function(obj){
                        //obj.config对象中可以获取ｉｄ属性值
                    　　//获取当前表格被选中记录对象，返回数据
                        var checkStatus=table.checkStatus(obj.config.id);
                        var eventName=obj.event;
                        switch (eventName) {
                            case "findAll":
                                layui.use("table",function () {
                                    var table = layui.table;
                                    table.render({
                                        elem: "#plateNumber_table",                 //容器id
                                        url: "/syslog/datamain.do",  //数据接口
                                        cols: [[
                                            {field: 'num', type: "numbers"},
                                            {field: 'visitTime', title: '访问时间', sort: true, width: 120},
                                            {field: 'jobnumber', title: '工号', width: 200},
                                            {field: 'ip', title: 'ip地址', width: 100},
                                            {field: 'url', title: 'url地址', width: 200},
                                            {field: 'executionTime', title: '执行时间', width: 100},
                                            {field: 'method', title: '执行方法', width: 600},
                                            // {field:"操作",toolbar:"#bar",fixed:"right",width:300}           //设置表头工具栏
                                        ]],
                                        page: true,    //开启分页
                                        limits: [3, 5, 10],  //一页选择显示3,5或10条数据
                                        limit: 10,  //一页显示10条数据
                                        parseData: function (res) { //将原始数据解析成 table 组件所规定的数据，res为从url中get到的数据
                                            var result;
                                            console.log(this);
                                            console.log(JSON.stringify(res));
                                            if (this.page.curr) {
                                                result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                                            } else {
                                                result = res.data.slice(0, this.limit);
                                            }
                                            return {
                                                "code": res.code, //解析接口状态
                                                "msg": res.msg, //解析提示文本
                                                "count": res.count, //解析数据长度
                                                "data": result //解析数据列表
                                            };
                                        },
                                        //设置表格工具栏
                                        toolbar: "#toolbar"
                                    });
                                });
                                  break;
                            case "delete":
                                    var arr=checkStatus.data;
                                    var url="";
                                    for(j=0;j<arr.length;j++){
                                        url+="plateNumber="+arr[j].plateNumber+"&";
                                    }
                                   url=url.substring(0,url.length-1);

                                   deleteajaxRequest(url);
                                   break;
                        }
                });

               //监听行工具栏事件
               table.on('tool(headtoolbar)',function (obj) {
                    //得到当前操作行的相关信息
                   var tr=obj.data;
                   //console.log(tr);
                   var eventName=obj.event;

                   switch (eventName) {
                       case "edit":
                                   getiframe('/operator/geteditOperator.do?jobnumber='+tr.jobnumber);
                                   break;
                        case "forbid":
                                   changeStatus(tr.jobnumber,0);
                                   break;
                        case "del":
                                  layer.confirm("您确认要删除吗?",function (index) {
                                        deletajax(tr.jobnumber,obj);
                                        layer.close(index);
                                  });
                                   break;
                   }
               });
        });
    </script>
</div>
</body>
</html>