<%@ page import="com.reverie.domain.Platenumberapply" %>
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

				function handlePlateNumberApply() {
					var applyNumber=document.getElementById("applyNumber").value;
					ajaxRequest(applyNumber);
				}

				function ajaxRequest(applyNumber) {
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
									window.parent.alertmessage("受理成功");
									parent.layer.close(index);
									parent.location.reload();
								}else{
									window.parent.alertmessage("受理失败");
								}
								//获取元素对象
							}else if(ajax.status==404){
								alert("请求资源不存在")
							}else if(ajax.status==500){
								alert("服务器繁忙")
							}
						}
					}

					ajax.open("post", "/plateNumberApply/handle.do");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("applyNumber="+applyNumber);
				}

				function reset() {
					document.getElementById("academicName").value="";
				}
		</script>
	</head>
	<body>
		<%Platenumberapply platenumberapply= (Platenumberapply) request.getAttribute("platenumberapply");%>
			<table class="table_context" width="100%">
						<input id="applyNumber" name="applyNumber" type="hidden" value="<%=platenumberapply.getApplyNumber()%>">
						<tr>
							<td width="10%" height="50" align="right">车辆车型:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="carType" id="carTypeop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden value="<%=platenumberapply.getCarType()%>" ><%=platenumberapply.getCarType()%></option>
								<option value="小型汽车" >小型汽车</option>
								<option value="大型汽车" >大型汽车</option>
								<option value="专用汽车" >专用汽车</option>
								<option value="特种车" >特种车</option>
								<option value="有轨电车" >有轨电车</option>
								<option value="无轨电车" >无轨电车</option>
								<option value="电瓶车" >电瓶车</option>
								<option value="三轮摩托车" >三轮摩托车</option>
								<option value="二轮摩托车" >二轮摩托车</option>
								<option value="轻便摩托车" >轻便摩托车</option>
								<option value="轻便摩托车" >轻便摩托车</option>
								<option value="四轮农用运输车" >四轮农用运输车</option>
								<option value="大型方向盘式拖拉机" >大型方向盘式拖拉机</option>
								<option value="小型方向盘式拖拉机" >小型方向盘式拖拉机</option>
								<option value="全挂车" >全挂车</option>
								<option value="半挂车" >半挂车</option>
								<option value="轮式自行专用机械" >轮式自行专用机械</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">机动车凭证:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="vehicleProof" name="vehicleProof" type="text" value="<%=platenumberapply.getVehicleProof()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">合格证号:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="certificateNumber" name="certificateNumber" type="text" value="<%=platenumberapply.getCertificateNumber()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">品牌型号:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="brandModel" name="brandModel" type="text" value="<%=platenumberapply.getBrandModel()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">VIN:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="vin" name="vin" type="text" value="<%=platenumberapply.getVin()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">可选号牌头:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="optionalPlateHead" name="optionalPlateHead" type="text" value="<%=platenumberapply.getOptionalPlateHead()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">号码:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="phoneNumber" name="phoneNumber" type="text" value="<%=platenumberapply.getPhoneNumber()%>"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">用户名:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="username" name="username" type="text" value="<%=platenumberapply.getUsername()%>"></td>
						</tr>

	                    <tr>
							<td height="50" colspan="2" align="center"><button class="layui-btn" onclick="handlePlateNumberApply()">给予受理</button><button class="layui-btn layui-btn-danger" onclick="forbidHandle()">不受理</button></td>
	                    </tr>
			</table>
	</body>
</html>
