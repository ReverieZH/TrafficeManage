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

				function addDriveLicence() {
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
					var nationality = document.getElementById("nationality").value;
					nationality = trim(nationality);
					if (nationality == "") {
						window.parent.alertmessage("请输入国籍");
						return false;
					}
					var address = document.getElementById("address").value;
					address = trim(address);
					if (address == "") {
						window.parent.alertmessage("请输入所在地");
						return false;
					}
					var vehicleTypeop=document.getElementById("vehicleTypeop");
					var index = vehicleTypeop.selectedIndex;
					var vehicleType= vehicleTypeop.options[index].value;
					vehicleType=trim(vehicleType);
					if(vehicleType==""){
						window.parent.alertmessage("请选择准驾车型");
						return false;
					}
					var authority = document.getElementById("authority").value;
					authority = trim(authority);
					if (authority == "") {
						window.parent.alertmessage("请输入发证机关");
						return false;
					}
					var score = document.getElementById("score").value;
					score = trim(score);
					if (score == "") {
						window.parent.alertmessage("请输入记分");
						return false;
					}
					var username = document.getElementById("username").value;
					username = trim(username);
					if (username == "") {
						window.parent.alertmessage("请输入用户名");
						return false;
					}
					var date = document.getElementById("date").value;
					date = trim(date);
					if (date == "") {
						window.parent.alertmessage("请输入出生日期");
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
					ajaxRequest(name,sex,nationality,address,vehicleType,authority,score,username,date,status);
				}


				function ajaxRequest( name,sex,nationality,address,vehicleType,authority,score,username,date,status) {
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

					ajax.open("post", "/driveLicence/addDriveLicence.do");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("name="+name+"&sex="+sex+"&nationality="+nationality+"&address="+address+"&vehicleType="+vehicleType+"&authority="+authority+"&score="+score+"&username="+username+"&birthDate="+date+"&status="+status);
				}

				function reset() {
					document.getElementById("academicName").value="";
				}
		</script>
	</head>
	<body>

			<table class="table_context" width="100%">
						<tr>
							<td width="10%" height="50" align="right">姓名:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="name" name="name" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">性别:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="sexop" id="sexop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden ></option>
								<option value="男" >男</option>
								<option value="女" >女</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">国籍:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="nationality" name="nationality" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">所在地:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="address" name="address" type="text"></td>
						</tr>

						<tr>
							<td width="10%" height="50" align="right">准驾车型:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="vehicleType" id="vehicleTypeop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden ></option>
								<option value="C1" >小型汽车C1</option>
								<option value="C2" >小型自动挡汽车C2</option>
								<option value="C3" >低速载货汽车C3</option>
								<option value="C4" >三轮汽车C4</option>
								<option value="B1" >中型客车B1</option>
								<option value="B2" >大型货车B2</option>
								<option value="A1" >大型客车A1</option>
								<option value="A3" >城市公交车A3</option>
								<option value="D" >普通三轮摩托车D</option>
								<option value="E" >普通二轮摩托车E</option>
								<option value="F" >轻便摩托车F</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">发证机关:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="authority" name="authority" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">计分:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="score" name="score" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">用户名:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="username" name="username" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">出生日期:</td>
							<td width="10%" height="50" align="left"> <input id="date" name="date" type="text" placeholder="yyyy-mm-dd"  autocomplete="off"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">状态:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="statusop" id="statusop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden ></option>
								<option value="0" >限制使用</option>
								<option value="1" >正常使用</option>
								<option value="2" >申请中</option>
							</select></td>
						</tr>
	                    <tr>
							<td height="50" colspan="2" align="center"><button class="layui-btn" onclick="addDriveLicence()">保存数据</button><button class="layui-btn layui-btn-danger" onclick="reset()">取消编辑</button></td>
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
