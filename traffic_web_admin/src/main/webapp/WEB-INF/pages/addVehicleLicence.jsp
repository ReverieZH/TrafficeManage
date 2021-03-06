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
					var plateNumber = document.getElementById("plateNumber").value;
					plateNumber = trim(plateNumber);
					if (plateNumber == "") {
						window.parent.alertmessage("请输入车牌号");
						return false;
					}
					var carTypeop=document.getElementById("carTypeop");
					var index = carTypeop.selectedIndex;
					var carType= carTypeop.options[index].value;
					carType=trim(carType);
					if(carType==""){
						window.parent.alertmessage("请选择车辆类型");
						return false;
					}
					var owner = document.getElementById("owner").value;
					owner = trim(owner);
					if (owner == "") {
						window.parent.alertmessage("请输入所有人");
						return false;
					}
					var address = document.getElementById("address").value;
					address = trim(address);
					if (address == "") {
						window.parent.alertmessage("请输入所在地");
						return false;
					}
					var brandModel = document.getElementById("brandModel").value;
					brandModel = trim(brandModel);
					if (brandModel == "") {
						window.parent.alertmessage("请输入品牌模型");
						return false;
					}
					var vin = document.getElementById("vin").value;
					vin = trim(vin);
					if (vin == "") {
						window.parent.alertmessage("请输入VIN号");
						return false;
					}
					var engineNumber = document.getElementById("engineNumber").value;
					engineNumber = trim(engineNumber);
					if (engineNumber == "") {
						window.parent.alertmessage("请输入用户名");
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
					ajaxRequest(plateNumber,carType,owner,address,brandModel,vin,engineNumber,status);
				}


				function ajaxRequest(plateNumber,carType,owner,address,brandModel,vin,engineNumber,status) {
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

					ajax.open("post", "/vehiclelicense/addVehiclelicense.do");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("plateNumber="+plateNumber+"&carType="+carType+"&owner="+owner+"&address="+address+"&brandModel="+brandModel+"&vin="+vin+"&engineNumber="+engineNumber+"&status="+status);
				}

				function reset() {
					document.getElementById("academicName").value="";
				}
		</script>
	</head>
	<body>

			<table class="table_context" width="100%">
						<tr>
							<td width="10%" height="50" align="right">车牌号:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="plateNumber" name="plateNumber" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">车辆车型:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="carType" id="carTypeop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden ></option>
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
							<td width="10%" height="50" align="right">所有人:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="owner" name="owner" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">所在地:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="address" name="address" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">品牌模型:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="brandModel" name="brandModel" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">VIN号:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="vin" name="vin" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">发动机号码:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="engineNumber" name="engineNumber" type="text"></td>
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
