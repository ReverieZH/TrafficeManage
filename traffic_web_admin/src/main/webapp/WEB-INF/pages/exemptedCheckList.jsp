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
        /* for Chrome ????????????????????????*/
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
                    shadeClose: true, //?????????????????????
                    area : ['800px' , '500px'],
                    content: url //??????content??????????????????String
                });
            })
        }

        function changeStatus(vlnumber,Status) {
            ajaxRequest(vlnumber,Status);
        }

        function ajaxRequest( vlnumber,status) {
            var ajax;
            if(window.XMLHttpRequest){//??????
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie
                ajax=new ActiveXObject("Msxml2.XMLHTTP");
            }
            //??????onreadystatechange??????
            ajax.onreadystatechange=function(){
                //??????Ajax?????????
                if(ajax.readyState==4){
                    //?????????????????????
                    if(ajax.status==200){
                        //??????????????????
                        var result=eval(ajax.responseText);
                        //alert(result);
                        //??????????????????
                        if(result){
                            window.location.reload();
                            //alert("??????");
                        }else{
                            alert("????????????");
                        }
                        //??????????????????
                    }else if(ajax.status==404){
                        alert("?????????????????????")
                    }else if(ajax.status==500){
                        alert("???????????????")
                    }
                }
            }

            ajax.open("post", "/vehiclelicense/changeStatus.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("vlnumber="+vlnumber+"&status="+status);
        }


        function changepagesize() {
            var pageisze=document.getElementById("pageisze");
            var index=pageisze.selectedIndex;
            var limit = pageisze.options[index].value; // ?????????
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
            if(window.XMLHttpRequest){//??????
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie
                ajax=new ActiveXObject("Msxml2.XMLHTTP");
            }
            //??????onreadystatechange??????
            ajax.onreadystatechange=function(){
                //??????Ajax?????????
                if(ajax.readyState==4){
                    //?????????????????????
                    if(ajax.status==200){
                        //??????????????????
                        var result=eval(ajax.responseText);
                        //alert(result);
                        //??????????????????
                        if(result){
                            window.location.reload();
                            alertmessage("????????????");
                            //alert("??????");
                        }else{
                            alertmessage("????????????");
                        }
                        //??????????????????
                    }else if(ajax.status==404){
                        alert("?????????????????????")
                    }else if(ajax.status==500){
                        alert("???????????????")
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

        function deletajax( vlnumber ,obj) {
            var ajax;
            if(window.XMLHttpRequest){//??????
                ajax=new XMLHttpRequest();
            }else if(window.ActiveXObject){//ie
                ajax=new ActiveXObject("Msxml2.XMLHTTP");
            }
            //??????onreadystatechange??????
            ajax.onreadystatechange=function(){
                //??????Ajax?????????
                if(ajax.readyState==4){
                    //?????????????????????
                    if(ajax.status==200){
                        //??????????????????
                        var result=eval(ajax.responseText);
                        //alert(result);
                        //??????????????????
                        if(result){
                            // window.location.reload();
                            alert("????????????");
                            obj.del();
                        }else{
                            alert("????????????");
                        }
                        //??????????????????
                    }else if(ajax.status==404){
                        alert("?????????????????????")
                    }else if(ajax.status==500){
                        alert("???????????????")
                    }
                }
            }

            ajax.open("post", "/vehiclelicense/delete.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("vlnumber="+vlnumber);
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
        function search(url) {
            layui.use("table", function () {
                    var table = layui.table;
                    table.render({
                        elem: "#plateNumber_table",                 //??????id
                        url:url,  //????????????
                        cols:[[
                            {field:'num',type:"numbers"},
                            {field:'check',type:"checkbox"},
                            {field:'acNumber',title:'????????????',sort:true,width:120},
                            {field:'plateNumber',title:'?????????',sort:true,width:120},
                            {field:'insurancePhoto',title:'????????????',width:100, templet: function (d) {
                                    return "<img  src=\""+d.insurancePhoto+"\" >????????????</img>";
                                }},
                            {field:'taxPhoto',title:'???????????????',width:100, templet: function (d) {
                                    return "<img  src=\""+d.taxPhoto+"\" >???????????????</img>";
                                }},
                            {field:'endDate',title:'????????????',width:100},
                            {
                                field: 'isNeedPaper', title: '????????????????????????', sort: true, width: 100, templet: function (d) {
                                    if (d.isNeedPaper == '0')
                                        return "?????????";
                                    else if (d.isNeedPaper == '1')
                                        return "<span  style='color:green'>??????</span>";
                                }
                            },{field:'accessMethod',title:'????????????',sort:true,width:100,templet:function(d){
                                    if(d.accessMethod=='0')
                                        return "<span  style='color:green'>??????????????????</span>";
                                    else if(d.accessMethod=='1')
                                        return "??????????????????";
                                }},
                            {field:'address',title:'??????',width:100},
                            {field:'area',title:'??????',width:100},
                            {field:'receiverName',title:'???????????????',width:100},
                            {field:'phoneNumber',title:'????????????',width:100},
                            {field:'postCode',title:'????????????',width:100},
                            {field:'username',title:'?????????',width:100},
                            {field:'applyDate',title:'????????????',width:100},
                            {field:'status',title:'??????',sort:true,width:100,templet:function(d){
                                    if(d.status=='1')
                                        return "????????????";
                                    else if(d.status=='0')
                                        return "<span  style='color:red'>????????????</span>";
                                    else if(d.status=='2')
                                        return "<span  style='color:green'>?????????</span>";
                                    /*return  d.status == '1' ? "????????????":"<span  style='color:red'>????????????</span>"*/}},
                            {field:"??????",toolbar:"#bar",fixed:"right",width:300}           //?????????????????????
                        ]],
                        page: true,    //????????????
                        limits: [3, 5, 10],  //??????????????????3,5???10?????????
                        limit: 10,  //????????????10?????????
                        parseData: function (res) { //???????????????????????? table ???????????????????????????res??????url???get????????????
                            var result;
                            console.log(this);
                            console.log(JSON.stringify(res));
                            if (this.page.curr) {
                                result = res.data.slice(this.limit * (this.page.curr - 1), this.limit * this.page.curr);
                            } else {
                                result = res.data.slice(0, this.limit);
                            }
                            return {
                                "code": res.code, //??????????????????
                                "msg": res.msg, //??????????????????
                                "count": res.count, //??????????????????
                                "data": result //??????????????????
                            };
                        },
                        //?????????????????????
                        toolbar: "#toolbar"
                    });
                }
            )
        }

        function searchByAcNumber() {
            var searchByAcNumber=document.getElementById("searchByAcNumber").value;
            search("/exemptCheck/search.do?acNumber="+searchByAcNumber);
        }
        function searchByUser() {
            var searchByUser=document.getElementById("searchByUser").value;
            search("/exemptCheck/searchByUser.do?username="+searchByUser);
        }
        function  findAll() {
            search("/exemptCheck/datamain.do");
        }
        function selectApply() {
            search("/exemptCheck/selectdatamain.do?status=2")
        }

    </script>

</head>
<body style=" overflow-x:hidden;"  class="inner-container">
<div style="color: #666;">

    <table id="plateNumber_table"  lay-filter="headtoolbar"></table>

    <script type="text/html" id="toolbar">
        <div>
            <div class="layui-btn-container" style="float: left">
                <button class="layui-btn layui-btn-sm" lay-event="datamain">????????????</button>
                <button class="layui-btn layui-btn-sm" lay-event="selectApply">?????????</button>
            </div>
            <div style="float: left">
                <input type="text" id="searchByAcNumber" name="searchByAcNumber" placeholder="????????????????????????"  class="layui-input" onchange="searchByAcNumber()" style="width: 150px;height: 30px" >
            </div>
            <div style="float: left">
                <input type="text" id="searchByUser" name="searchByUser" placeholder="?????????????????????"  class="layui-input" onchange="searchByUser()" style="width: 150px;height: 30px" >
            </div>
        </div>
    </script>

    <script type="text/html" id="bar">
       <%-- <a class="layui-btn layui-btn-xs" lay-event="edit">??????</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">??????</a>
        <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="forbid">??????</a>--%>
        <a class="layui-btn layui-btn-norma layui-btn-xs" lay-event="accept">??????</a>
    </script>
    <script>
        function open(url) {
            var img="<img src='"+url+"'/>"
            layer.open({
                type:1,
                area:['50%','55%'],
                content:img
            })
        }
    </script>
    <script type="text/javascript">
        layui.use("table",function () {
                var table=layui.table;

                table.render({
                    elem:"#plateNumber_table",                 //??????id
                    url:"/exemptCheck/data.do",  //????????????
                    cols:[[
                        {field:'num',type:"numbers"},
                        {field:'check',type:"checkbox"},
                        {field:'acNumber',title:'????????????',sort:true,width:120},
                        {field:'plateNumber',title:'?????????',sort:true,width:120},
                        {field:'insurancePhoto',title:'????????????',width:100, templet: function (d) {
                                return "<img  src=\""+d.insurancePhoto+"\" >????????????</img>";
                        }},
                        {field:'taxPhoto',title:'???????????????',width:100, templet: function (d) {
                                return "<img  src=\""+d.taxPhoto+"\" >???????????????</img>";
                            }},
                        {field:'endDate',title:'????????????',width:100},
                        {
                            field: 'isNeedPaper', title: '????????????????????????', sort: true, width: 100, templet: function (d) {
                                if (d.isNeedPaper == '0')
                                    return "?????????";
                                else if (d.isNeedPaper == '1')
                                    return "<span  style='color:green'>??????</span>";
                            }
                        },{field:'accessMethod',title:'????????????',sort:true,width:100,templet:function(d){
                                 if(d.accessMethod=='0')
                                    return "<span  style='color:green'>??????????????????</span>";
                                else if(d.accessMethod=='1')
                                    return "??????????????????";
                        }},
                        {field:'address',title:'??????',width:100},
                        {field:'area',title:'??????',width:100},
                        {field:'receiverName',title:'???????????????',width:100},
                        {field:'phoneNumber',title:'????????????',width:100},
                        {field:'postCode',title:'????????????',width:100},
                        {field:'username',title:'?????????',width:100},
                        {field:'applyDate',title:'????????????',width:100},
                        {field:'status',title:'??????',sort:true,width:100,templet:function(d){
                                if(d.status=='1')
                                    return "????????????";
                                else if(d.status=='0')
                                    return "<span  style='color:red'>????????????</span>";
                                else if(d.status=='2')
                                    return "<span  style='color:green'>?????????</span>";
                                /*return  d.status == '1' ? "????????????":"<span  style='color:red'>????????????</span>"*/}},
                        {field:"??????",toolbar:"#bar",fixed:"right",width:300}           //?????????????????????
                    ]],
                    page:true,    //????????????
                    limits: [3,5,10],  //??????????????????3,5???10?????????
                    limit: 10,  //????????????10?????????
                    parseData: function(res){ //???????????????????????? table ???????????????????????????res??????url???get????????????
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
                            "code": res.code, //??????????????????
                            "msg": res.msg, //??????????????????
                            "count": res.count, //??????????????????
                            "data": result //??????????????????
                        };
                    },
                    //?????????????????????
                    toolbar:"#toolbar"
                });

                //???????????????
                table.on('toolbar(headtoolbar)',function(obj){
                        //obj.config????????????????????????????????????
                    ??????//??????????????????????????????????????????????????????
                        var checkStatus=table.checkStatus(obj.config.id);
                        var eventName=obj.event;
                        switch (eventName) {
                            case "datamain":
                                findAll();
                                  break;
                            case "selectApply":
                                   selectApply();
                                   break;
                        }
                });

               //????????????????????????
               table.on('tool(headtoolbar)',function (obj) {
                    //????????????????????????????????????
                   var tr=obj.data;
                   //console.log(tr);
                   var eventName=obj.event;

                   switch (eventName) {
                       case "accept":
                                   if(tr.status!=2){
                                       layer.open({
                                           type: 0,
                                           offset: '100px',
                                           content: '????????????????????????' //??????content??????????????????String
                                       });
                                   }else{
                                       getiframe('/exemptCheck/getinfo.do?acNumber='+tr.acNumber);
                                   }
                                   break;
                        case "forbid":
                                   changeStatus(tr.vlnumber,0);
                                   break;
                        case "del":
                                  layer.confirm("??????????????????????",function (index) {
                                        deletajax(tr.vlnumber,obj);
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
