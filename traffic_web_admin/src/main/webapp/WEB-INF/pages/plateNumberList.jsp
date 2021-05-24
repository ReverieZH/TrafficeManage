<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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
                     area : ['800px' , '400px'],
                    content: url //这里content是一个普通的String
                });
            })
        }

        function changeStatus(plateNumber,Status) {
            ajaxRequest(plateNumber,Status);
        }

        function ajaxRequest( plateNumber,status) {
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

            ajax.open("post", "/plateNumber/changeStatus.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("plateNumber="+plateNumber+"&status="+status);
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

        function deletajax( plateNumber ,obj) {
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

            ajax.open("post", "/plateNumber/delete.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("plateNumber="+plateNumber);
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
    </script>

</head>
<body style=" overflow-x:hidden;"  class="inner-container">
<div style="color: #666;">

    <table id="plateNumber_table"  lay-filter="headtoolbar"></table>

    <script type="text/html" id="toolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
<%--            <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>--%>
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
                    url:"/plateNumber/datamain.do",  //数据接口
                    cols:[[
                        {field:'num',type:"numbers"},
                        {field:'check',type:"checkbox"},
                        {field:'plateNumber',title:'车牌号',sort:true,width:120},
                        {field:'issueDate',title:'发行日期',width:100},
                        {field:'locationName',title:'所在地',width:100},
                        {field:'plateHead',title:'号牌头',width:100},
                        {field:'status',title:'状态',sort:true,width:100,templet:function(d){
                                if(d.status=='1')
                                    return "正常使用";
                                else if(d.status=='0')
                                    return "<span  style='color:red'>限制使用</span>";
                                else if(d.status=='2')
                                    return "<span  style='color:green'>申请中</span>";}},
                        {field:"操作",toolbar:"#bar",fixed:"right"}           //设置表头工具栏
                    ]],
                    page:true,    //开启分页
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
                            case "add":
                                  getiframe('/plateNumber/getaddPlateNumber.do');
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
                                   getiframe('/plateNumber/geteditPlateNumber.do?plateNumber='+tr.plateNumber);
                                   break;
                        case "forbid":
                                   changeStatus(tr.plateNumber,0);
                                   break;
                        case "del":
                                  layer.confirm("您确认要删除吗?",{offset:'100px'},function (index) {
                                        deletajax(tr.plateNumber,obj);
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