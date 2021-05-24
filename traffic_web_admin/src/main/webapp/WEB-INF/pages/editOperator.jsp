<%@ page import="com.reverie.domain.Operator" %>
<%@ page import="com.reverie.utils.StringUtil" %>
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
<%--		<link rel="stylesheet" href="../../layui/css/layui.css">--%>
<%--		<script src="../../layui/layui.js"></script>--%>
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

				layui.use('laydate', function(){
				  var laydate = layui.laydate;
				  
				  //执行一个laydate实例
				  laydate.render({
				    elem: '#date' //指定元素
				  });
				});

				function editOperator() {
					var jobnumber = document.getElementById("jobnumber").value;
					var password = document.getElementById("password").value;
					password = trim(password);
					if (password == "") {
						window.parent.alertmessage("请输入密码");
						return false;
					}

					var roleop=document.getElementById("roleop");
					var index = roleop.selectedIndex;
					var role= roleop.options[index].value;
					role=trim(role);
					if(role==""){
						window.parent.alertmessage("请选择角色");
						return false;
					}


					var name = document.getElementById("name").value;
					name = trim(name);
					if (name == "") {
						window.parent.alertmessage("请输入姓名");
						return false;
					}
					var sexop=document.getElementById("sexop");
					var index = sexop.selectedIndex;
					var sex= sexop.options[index].value;
					sex=trim(sex);
					if(sex==""){
						window.parent.alertmessage("请选择性别");
						return false;
					}
					var department = document.getElementById("department").value;
					department = trim(department);
					if (department == "") {
						window.parent.alertmessage("请输入部门");
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
					ajaxRequest(jobnumber,password,role,name,sex,department,status);
				}


				function ajaxRequest(jobnumber,password,role,name,sex,department,status) {
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

					ajax.open("post", "/operator/editOperator.do");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("jobnumber="+jobnumber+"&password="+password+"&role="+role+"&name="+name+"&sex="+sex+"&department="+department+"+&vaild="+status);
				}

				function reset() {
					document.getElementById("academicName").value="";
				}
		</script>
	</head>
	<body>
			<%Operator operator= (Operator) request.getAttribute("operator");%>
			<table class="table_context" width="100%">
				        <input id="jobnumber" name="jobnumber" type="hidden" value="<%=operator.getJobnumber()%>">

						<tr>
							<td width="10%" height="50" align="right">密码:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="password" name="password" type="password"  value="<%=operator.getPassword()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">role:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="roleop" id="roleop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden value="<%=operator.getRole()%>"><%=operator.getRole()%></option>
								<option value="管理员" >管理员</option>
								<option value="工作人员" >工作人员</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">姓名:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="name" name="name" type="text"  value="<%=operator.getName()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">性别:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="sexop" id="sexop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden  value="<%=operator.getSex()%>"><%=operator.getSex()%></option>
								<option value="男" >男</option>
								<option value="女" >女</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">部门:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="department" name="department" type="text" value="<%=operator.getDepartment()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">状态:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="statusop" id="statusop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden value="<%=operator.getVaild()%>"><%=StringUtil.getStatusStr(operator.getVaild())%></option>
								<option value="0" >限制使用</option>
								<option value="1" >正常使用</option>
								<option value="2" >申请中</option>
							</select></td>
						</tr>
	                    <tr>
							<td height="50" colspan="2" align="center"><button class="layui-btn" onclick="editOperator()">保存数据</button><button class="layui-btn layui-btn-danger" onclick="reset()">取消编辑</button></td>
	                    </tr>
			</table>
	</body>
	<script>
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#date', //指定元素
				position :"fixed"
			});
		});
	</script>
</html>
