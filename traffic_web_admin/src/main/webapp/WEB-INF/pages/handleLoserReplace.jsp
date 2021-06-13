<%@ page import="com.reverie.domain.Platenumber" %>
<%@ page import="com.reverie.domain.Drivinglicence" %>
<%@ page import="com.reverie.utils.StringUtil" %>
<%@ page import="com.reverie.domain.Checkreservation" %>
<%@ page import="com.reverie.utils.Date2StringUtils" %>
<%@ page import="com.reverie.domain.Losereplace" %><%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2021/04/09
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path ;
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

        function handle(status) {
            var loseReplaceNumber = document.getElementById("loseReplaceNumber").value;
            ajaxRequest(loseReplaceNumber,status);
            //location.href="modifyTask.do?"+"taskId="+taskId+"&taskName="+taskName+"&taskDesc="+taskDesc+"&status="+status;
        }

        function ajaxRequest(loseReplaceNumber,status) {
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

            ajax.open("post", "/change/loseHandle.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("loseReplaceNumber="+loseReplaceNumber+"&status="+status);
        }

        function reset() {
            document.getElementById("academicName").value="";
        }
    </script>
</head>
<body>
    <% Losereplace losereplace= (Losereplace) request.getAttribute("losereplace");%>
    <table class="table_context" width="100%">
        <input id="loseReplaceNumber" name="loseReplaceNumber"  value="<%=losereplace.getLoseReplaceNumber()%>" type="hidden">
        <tr>
            <td width="10%" height="50" align="right">驾驶证编号:</td>
            <td width="10%" height="50" align="left"><%=losereplace.getDlNumber()%></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">领取方式:</td>
            <td width="10%" height="50" align="left"><%=losereplace.getAccessMethod()%></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">收件人姓名:</td>
            <td width="10%" height="50" align="left"><%=losereplace.getReceiverName()%></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">收件地址:</td>
            <td width="10%" height="50" align="left"><%=losereplace.getAddress()%></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">联系电话:</td>
            <td width="10%" height="50" align="left"><%=losereplace.getPhoneNumber()%></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">邮编:</td>
            <td width="10%" height="50" align="left"><%=losereplace.getPostCode()%></td>
        </tr>
        <tr>
            <td width="10%" height="50" align="right">申请日期:</td>
            <td width="10%" height="50" align="left"><%=Date2StringUtils.dateString(losereplace.getApplyDate())%></td>
        </tr>
        <tr>
            <td height="50" colspan="2" align="center"><button class="layui-btn" onclick="handle('1')" >受理</button><button class="layui-btn layui-btn-danger" onclick="handle('0')">不予受理</button></td>
        </tr>
    </table>
</body>
</html>
