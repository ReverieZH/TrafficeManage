<%@ page import="com.reverie.domain.User" %>
<%@ page import="com.reverie.utils.StringUtil" %>
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

				function editUser() {
					var username = document.getElementById("username").value;
					var password = document.getElementById("password").value;
					password = trim(password);
					if (password == "") {
						window.parent.alertmessage("请输入密码");
						return false;
					}

					var certificatetypeop=document.getElementById("certificatetypeop");
					var index = certificatetypeop.selectedIndex;
					var certificatetype= certificatetypeop.options[index].value;
					certificatetype=trim(certificatetype);
					if(certificatetype==""){
						window.parent.alertmessage("请选择驾驶证类型");
						return false;
					}


					var certificatenumber = document.getElementById("certificatenumber").value;
					certificatenumber = trim(certificatenumber);
					if (certificatenumber == "") {
						window.parent.alertmessage("请输入驾驶证号码");
						return false;
					}
					var phonenumber = document.getElementById("phonenumber").value;
					phonenumber = trim(phonenumber);
					if (phonenumber == "") {
						window.parent.alertmessage("请输入电话号码");
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
					ajaxRequest(username,password,certificatetype,certificatenumber,phonenumber,status);
				}


				function ajaxRequest(username,password,certificatetype,certificatenumber,phonenumber,status) {
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

					ajax.open("post", "/user/editUser.do");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("username="+username+"&password="+password+"&certificatetype="+certificatetype+"&certificatenumber="+certificatenumber+"&phonenumber="+phonenumber+"&valid="+status);
				}

				function reset() {
					document.getElementById("academicName").value="";
				}
		</script>
	</head>
	<body>
            <% User user= (User) request.getAttribute("user");%>
			<table class="table_context" width="100%">
				  <input id="username" name="username" type="hidden" value="<%=user.getUsername()%>"></td>
						<tr>
							<td width="10%" height="50" align="right">密码:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="password" name="password" type="password" value="<%=user.getPassword()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">证件类型:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="certificatetype" id="certificatetypeop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden value="<%=user.getCertificatetype()%>"><%=StringUtil.getCertificateType(user.getCertificatetype())%></option>
								<option value="A" >A居民身份证</option>
								<option value="C2" >C军官证</option>
								<option value="D" >D士兵证</option>
								<option value="E" >E军官离退休证</option>
								<option value="F" >F境外人员身份证明</option>
								<option value="G" >G外交人员身份证明</option>
								<option value="I" >I外国人永久居留身份证</option>
								<option value="Q" >Q港澳台居民居住证</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">证件号码:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="certificatenumber" name="certificatenumber" type="text" value="<%=user.getCertificatenumber()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">电话号码:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="phonenumber" name="phonenumber" type="text" value="<%=user.getPhonenumber()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">状态:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="statusop" id="statusop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden value="<%=user.getValid()%>"><%=StringUtil.getStatusStr(user.getValid())%></option>
								<option value="0" >限制使用</option>
								<option value="1" >正常使用</option>
								<option value="2" >申请中</option>
							</select></td>
						</tr>
	                    <tr>
							<td height="50" colspan="2" align="center"><button class="layui-btn" onclick="editUser()">保存数据</button><button class="layui-btn layui-btn-danger" onclick="reset()">取消编辑</button></td>
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
