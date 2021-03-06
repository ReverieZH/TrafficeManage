<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path ;
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <title > 用户登录</title>
    <link rel="stylesheet" href="/static/css/font-awesome.css" />
    <link rel="stylesheet" href="/static/css/font-awesome.min.css" />
    <link rel="stylesheet" href="/static/css/sweetalert.css" />
    <link rel="stylesheet" href="/static/css/LoginCss.css" />
    <script type="text/javascript" src="/static/js/sweetalert-dev.js" ></script>
    <script type="text/javascript" src="/static/js/Login.js" ></script>
    <script src="/static/layui/layui.js"></script>
    <style>
        #imgdiv {
            border-width:0px;
            position:absolute;
            left:110px;
            top:115px;
            width:376px;
            height:75px;
            font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑';
            font-style:normal;
            color:#FFFFFF;
            text-align:left;
            line-height:32px;

        }
        #logo {
            border-width:0px;
            position:absolute;
            left:0px;
            top:0px;
            width:75px;
            height:75px;
        }

        #word {
            border-width:0px;
            position:absolute;
            left:100px;
            top:0px;
            width:372px;
            word-wrap:break-word;
        }

        #copyright_img {
            border-width:0px;
            position:absolute;
            left:0px;
            top:0px;
            width:1141px;
            height:101px;
        }
        #copyright {
            border-width:0px;
            position:absolute;
            left:0px;
            top:0px;
            width:1140px;
            height:100px;
            font-family:'微软雅黑';
            font-weight:400;
            font-style:normal;
            font-size:12px;
            color:#666666;
            line-height:24px;
        }
        #copyright_text {
            border-width:0px;
            position:absolute;
            left:2px;
            top:26px;
            width:1136px;
            word-wrap:break-word;
        }

        #bottom {
            position:absolute;
            left:0px;
            top:663px;
        }
        #bottom_state0 {
            position:relative;
            left:0px;
            top:0px;
            width:1140px;
            height:100px;
            background-image:none;
        }
        #bottom_state0_content {
            border-width:0px;
            position:absolute;
            left:0px;
            top:0px;
            width:1px;
            height:1px;
        }
        p{
            margin:0 0;
            line-height:5px;
        }
    </style>
</head>
<body style="background-color:#1F8AFF;">
<div  id="main" style="height:500px;width:auto;">
    <div id="imgdiv" class="ax_default image" >
        <img id="logo" class="img" src="static/img/u1167.svg"/>
        <div id="word" >
            <p style="font-size:26px;"><span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑';font-weight:700;"> 交通在线管理系统</span></p>
            <!--            <p style="font-size:20px;"><span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑';font-weight:700;">&nbsp;&nbsp;Epidemicwar Stystem</span></p>-->
        </div>
    </div>
    <div id="Login_box" style="float:right;">
        <h1>用户登录</h1>
        <div class="form">
            <form action="/login" method="post">
                <c:if test="${param.error==true }">
                    <label style="color: red" >账号或密码错误,请重新输入</label>
                </c:if>
            <div class="item" >
                <i class="fa fa-user-circle" aria-hidden="true"></i>
                <input id="login_username" name="username" type="text" placeholder="请输入用户名称"/>
            </div>
            <div class="item">
                <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                <input id="login_password" name="password" type="password" placeholder="请输入用户密码"/>
            </div>
            <div style="margin-top: 30px;">
                <input  class="login_button" type="submit" value="登录" >
            </div>
            </form>
        </div>
    </div>
</div>
<div id="bottom" class="ax_default" data-label="底部版权" style="background-color: #FFFFFF;height:100px;width:100%;">
    <div id="copyright" class="ax_default _默认样式">
        <img id="copyright_img" class="img " src="static/img/u1030.png"/>
        <div id="copyright_text" class="text " style="text-align: center;">
            <p><span>Copyright © </span><a id="u2803" class="link" title="点击打开https://reveriezh.github.io"><span>reveriezh</span></a><span>, All Rights Reserved.</span></p><p><span></span></p>
        </div>
    </div>
</div>
</body>
</html>
