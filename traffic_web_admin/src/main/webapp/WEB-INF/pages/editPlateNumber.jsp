<%@ page import="com.reverie.domain.Platenumber" %>
<%@ page import="com.reverie.utils.StringUtil" %><%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2021/04/09
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>/static/layui/css/layui.css">
    <script src="<%=basePath%>/static/layui/layui.js"></script>
    <style>
        .table_context{
            font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
            width:750px;
            /*border-collapse:collapse;*/

        }

        input[type="text"] {
            margin-left: 5px;
            width: 400px;
            height: 25px;
        }

    </style>


    <script>
        //去掉字串左边的空格
        function lTrim(str) {
            if (str.charAt(0) == " " || str.charAt(0) == "　") {
                str = str.slice(1);
                str = lTrim(str);
            }
            return str;
        }

        //去掉字串右边的空格
        function rTrim(str) {
            var iLength;
            iLength = str.length;
            if (str.charAt(iLength - 1) == " " || str.charAt(iLength - 1) == "　") {
                str = str.slice(0, iLength - 1);
                str = rTrim(str);
            }
            return str;
        }

        //去掉字串两边的空格
        function trim(str) {
            return lTrim(rTrim(str));
        }

        function modifyPlateNumber() {
            var plateNumber = document.getElementById("plateNumber").value;
            plateNumber = trim(plateNumber);
            if (plateNumber == "") {
                window.parent.alertmessage("请输入车牌号");
                return false;
            }
            var location = document.getElementById("location").value;
            location = trim(location);
            if (location == "") {
                window.parent.alertmessage("请输入车牌号");
                return false;
            }
            var statusop=document.getElementById("statusop");
            var index = statusop.selectedIndex;
            var status= statusop.options[index].value;
            status=trim(status);
            if(status==""){
                window.parent.alertmessage("请选择状态");
                return false;
            }

            ajaxRequest(plateNumber, location,status);
            //location.href="modifyTask.do?"+"taskId="+taskId+"&taskName="+taskName+"&taskDesc="+taskDesc+"&status="+status;
        }

        function ajaxRequest(plateNumber, location,status) {
            var index = parent.layer.getFrameIndex(window.name);
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
                        //处理响应内容
                        if(result){
                            window.parent.alertmessage("修改成功");
                            parent.layer.close(index);
                            window.parent.location.reload();
                        }else{
                            window.parent.alertmessage("修改失败");
                        }
                        //获取元素对象
                    }else if(ajax.status==404){
                        alert("请求资源不存在")
                    }else if(ajax.status==500){
                        alert("服务器繁忙")
                    }
                }
            }

            ajax.open("post", "editPlateNumber.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("plateNumber="+plateNumber+"&location="+location+"&status="+status);
        }

        function reset() {
            document.getElementById("academicName").value="";
        }
    </script>
</head>
<body>
    <% Platenumber platenumber= (Platenumber) request.getAttribute("PlateNumber");%>
    <table class="table_context" width="100%">
        <input id="plateNumber" name="plateNumber"  value="<%=platenumber.getPlateNumber()%>" type="hidden">
        <tr>
            <td width="10%" height="50" align="right">省份:<span style="color: red;">*</span></td>
            <td width="10%" height="50" align="left"><input id="province" name="province" type="text" value="<%=platenumber.getProvince()%>"></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">城市:<span style="color: red;">*</span></td>
            <td width="10%" height="50" align="left"><input id="city" name="city" type="text" value="<%=platenumber.getCity()%>"></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">所在地:<span style="color: red;">*</span></td>
            <td width="10%" height="50" align="left"><input id="location" name="location" type="text" value="<%=platenumber.getLocationName()%>"></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">使用状态:</td>
            <td width="10%" height="50" align="left"> <select id="statusop" name="statusop" lay-verify="" >
                <option value="<%=platenumber.getStatus()%>" disabled selected hidden><%=StringUtil.getStatusStr(platenumber.getStatus())%></option>
                <option value="0" >限制使用</option>
                <option value="1" >正常使用</option>
                <option value="2" >申请中</option>
            </select></td>
        </tr>
        <tr>
            <td height="50" colspan="2" align="center"><button class="layui-btn" onclick="modifyPlateNumber()" >保存数据</button><button class="layui-btn layui-btn-danger" onclick="reset()">取消编辑</button></td>
        </tr>
    </table>
</body>
</html>
