<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>交通在线管理系统</title>
	<link rel="stylesheet" href="<%=basePath%>/static/layui/css/layui.css">
	<script src="<%=basePath%>/static/layui/layui.js"></script>
	<style>
		#left{
			width: 225px;
			height: 800px;
			background-color: #393D49;
		}
		#left .div{
			margin-left:20px ;
		}

		#logodiv{
			position:absolute;
			left:20px;
			width: 35px;
			height: 35px;
		}

		#logo {
			border-width:0px;
			left:0px;
			top:0px;
			width:35px;
			height:35px;
		}

		#word {
			border-width:0px;
			position:relative;
			left:40px;
			width:200px;
			word-wrap:break-word;
			color: #FFFFFF;
		}

		#right{
			position:absolute;
			margin-left: 20px;
			margin-top: 10px;
			left: 220px;
			top:70px;
			width: 1050px;
			height: 600px;
			border: solid #ccc 1px ;
			display: inline;
			box-shadow: 0px 2px 5px #888888;

			padding: 10px;
			overflow: hidden;
		}
		#right iframe{
			width: 1050px;
			height: 550px;

		}
		i{
			font-size: 23px;
			color: #FFFFFF;
			margin-right: 5px;
		}
	</style>

	<script>
		//一般直接写在一个js文件中
		var last_li;
		function getiframe(url){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.open({
					type: 2,
					title: '修改任务',
					maxmin: true,
					shadeClose: true, //点击遮罩关闭层
					area : ['800px' , '520px'],
					content: url //这里content是一个普通的String
				});
			})
		}
		//注意：导航 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function(){
			var element = layui.element;

			//…
		});

		function start() {
			var inframe=document.getElementById("inframe");
			inframe.src="task/main.do";
		}

		function changInframe(url) {
			var inframe=document.getElementById("inframe");
			inframe.src=url;
			var li=document.getElementById("plateNumber_id");
			li.className+= 'layui-this';

		}
	</script>
</head>
<body >
<%String rid= String.valueOf(request.getSession().getAttribute("rid"));%>
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">
			<div id="logodiv" >
			<img id="logo" class="img" src="<%=basePath%>/static/img/u1167.svg"/>
		   </div>
			<div id="word"  >
				<p style="font-size:18px;"><span style="font-family:'微软雅黑 Bold', '微软雅黑 Regular', '微软雅黑';font-weight:700;"> 交通在线管理系统</span></p>
			</div>
		</div>
		<!-- 头部区域（可配合layui 已有的水平导航） -->
		<ul class="layui-nav layui-layout-left">
			<%  if(rid.equals("1")||rid.equals("2"))  {%>
			<li class="layui-nav-item layui-this"><a href="">数据管理</a></li>
			<li class="layui-nav-item"><a href="/manage/service.do">业务管理</a></li>
			<% } else{%>
			<li class="layui-nav-item"><a href="/manage/service.do">业务管理</a></li>
			<%}%>
			<%--<li class="layui-nav-item"><a href="">nav 3</a></li>
			<li class="layui-nav-item">
				<a href="javascript:;">nav groups</a>
				<dl class="layui-nav-child">
					<dd><a href="">menu 11</a></dd>
					<dd><a href="">menu 22</a></dd>
					<dd><a href="">menu 33</a></dd>
				</dl>
			</li>--%>
		</ul>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
					<%=SecurityContextHolder.getContext().getAuthentication().getName()%>
				</a>
				<dl class="layui-nav-child">
					<dd><a href="">set 1</a></dd>
					<dd><a href="">set 2</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="">登出</a></li>
		</ul>
	</div>
	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<li class="layui-nav-item layui-nav-itemed">
					<a href="javascript:;">信息管理</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;"  onclick="changInframe('/operator/main.do')" >操作员信息管理</a></dd>
						<dd><a href="javascript:;"  onclick="changInframe('/user/main.do')" >用户信息管理</a></dd>
						<dd><a href="javascript:;" onclick="changInframe('/plateNumber/main.do')">车牌信息管理</a></dd>
						<dd><a href="javascript:;" onclick="changInframe('/driveLicence/main.do')">驾驶证信息管理</a></dd>
						<dd><a href="javascript:;" onclick="changInframe('/vehiclelicense/main.do')">行驶证信息管理</a></dd>
						<dd><a href="javascript:;" onclick="changInframe('/car/main.do')">车辆信息管理</a></dd>
					</dl>
				</li>
				<%
				  if(rid.equals("1")){
				%>
				<%--<li class="layui-nav-item layui-nav-itemed">
				<a href="javascript:;">权限管理</a>
				<dl class="layui-nav-child">
					<dd><a href="javascript:;">移动模块</a></dd>
					<dd><a href="javascript:;">后台模版</a></dd>
					<dd><a href="">电商平台</a></dd>
				</dl>
			   </li>--%>
				<li class="layui-nav-item">
					<a href="javascript:;">日志管理</a>
					<dl class="layui-nav-child">
						<dd><a href="javascript:;"  onclick="changInframe('/syslog/main.do')" >日志信息管理</a></dd>
					</dl>
				</li>
				<%}%>
			</ul>
		</div>
	</div>
	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;"><iframe id="inframe"  marginWidth=0 marginHeight=0  width="100%" height="900px" scrolling="auto" frameBorder=0 style="float: right;right: 300px;"></iframe></div>
	</div>
	<div class="layui-footer">
		<!-- 底部固定区域 -->
		<p><span>Copyright © </span><a id="u2803" class="link" title="点击打开https://reveriezh.github.io"><span>reveriezh</span></a><span>, All Rights Reserved.</span></p><p><span></span></p>
	</div>

</div>
</body>
</html>