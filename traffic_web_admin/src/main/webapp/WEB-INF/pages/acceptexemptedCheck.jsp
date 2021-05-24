<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.reverie.domain.Platenumber" %>
<%@ page import="com.reverie.domain.Drivinglicence" %>
<%@ page import="com.reverie.utils.StringUtil" %>
<%@ page import="com.reverie.domain.Applyexemptedcheck" %><%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2021/04/09
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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
        h2{
            font-size: 12px;
        }

    </style>


    <script>
        function open(url) {
            var img="<img src='"+url+"'/>"
            layer.open({
                type:1,
                area:['50%','55%'],
                content:img
            })
        }

        function accept(status) {
            var acNumber = document.getElementById("acNumber").value;
            ajaxRequest(acNumber,status)
        }
        function ajaxRequest(acNumber,status) {
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
                            window.parent.alertmessage("添加成功");
                            parent.layer.close(index);
                            parent.location.reload();
                        }else{
                            window.parent.alertmessage("添加失败");
                        }
                        //获取元素对象
                    }else if(ajax.status==404){
                        alert("请求资源不存在")
                    }else if(ajax.status==500){
                        alert("服务器繁忙")
                    }
                }
            }

            ajax.open("post", "/exemptCheck/accerpt.do");
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("acNumber="+acNumber+"&status="+status);

        }
    </script>
</head>
<body>
    <% Applyexemptedcheck applyexemptedcheck= (Applyexemptedcheck) request.getAttribute("applyexemptedcheck");%>
    <table class="table_context" width="100%">
        <input id="acNumber" name="acNumber"  value="<%=applyexemptedcheck.getAcNumber()%>" type="hidden">
        <tr>
            <td width="40%" height="50" align="right">车牌号:<span style="color: red;">*</span></td>
            <td width="60%" height="50" align="left"><h2><%=applyexemptedcheck.getPlateNumber()%></h2></td>
        </tr>
        <tr>
            <td width="40%" height="50" align="right">强险照片:<span style="color: red;">*</span></td>
            <td width="60%" height="50" align="left"><img src="<%=applyexemptedcheck.getInsurancePhoto()%>" onclick="open(<%=applyexemptedcheck.getInsurancePhoto()%>)" width="90%"></td>
        </tr>
        <tr>
            <td width="40%" height="50" align="right">车船税照片:<span style="color: red;">*</span></td>
            <td width="60%" height="50" align="left"><img src="<%=applyexemptedcheck.getTaxPhoto()%>"  width="90%"</td>
        </tr>
        <tr>
            <td width="40%" height="50" align="right">有效期截止日期:<span style="color: red;">*</span></td>
            <td width="60%" height="50" align="left"><h2><%=applyexemptedcheck.getEndDate()%></h2></td>
        </tr>
        <tr>
            <td width="40%" height="50" align="right">是否需要纸质凭证:</td>
            <td width="60%" height="50" align="left">
                <%  if(applyexemptedcheck.getIsNeedPaper()=="0"){
                %> <h2>是</h2>
                <% }else {%>
                <h2>否</h2>
                <% }%>
            </td>
        </tr>
        <c:choose>
            <c:when test="${applyexemptedcheck.accessMethod == '0'}">
                <tr>
                    <td width="10%" height="50" align="right">获取方式:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2>委托邮政寄递</h2></td>
                </tr>
                <tr>
                    <td width="10%" height="50" align="right">地址:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2><%=applyexemptedcheck.getAddress()%></h2></td>
                </tr>
                <tr>
                    <td width="10%" height="50" align="right">地区:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2><%=applyexemptedcheck.getArea()%></h2></td>
                </tr>
                <tr>
                    <td width="10%" height="50" align="right">接收人:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2><%=applyexemptedcheck.getReceiverName()%></h2></td>
                </tr>
                <tr>
                    <td width="10%" height="50" align="right">接收人电话:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2><%=applyexemptedcheck.getPhoneNumber()%></h2></td>
                </tr>
                <tr>
                    <td width="10%" height="50" align="right">邮编:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2><%=applyexemptedcheck.getPostCode()%></h2></td>
                </tr>
            </c:when>
            <c:when test="${applyexemptedcheck.accessMethod=='1'}">
                <tr>
                    <td width="10%" height="50" align="right">获取方式:<span style="color: red;">*</span></td>
                    <td width="10%" height="50" align="left"><h2>前往窗口自取</h2></td>
                </tr>
            </c:when>
        </c:choose>
        <tr>
            <td height="50" colspan="2" align="center"><button class="layui-btn" onclick="accept(1)" >给予受理</button><button class="layui-btn layui-btn-danger" onclick="accept(0)">不给予受理</button></td>
        </tr>
    </table>
</body>
</html>
