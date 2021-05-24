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

				function addTrafficOffence() {
					var trafficOffenceDate = document.getElementById("trafficOffenceDate").value;
					trafficOffenceDate = trim(trafficOffenceDate);
					if (trafficOffenceDate == "") {
						window.parent.alertmessage("请输入违法日期");
						return false;
					}
					var trafficOffencePlace=document.getElementById("trafficOffencePlace").value;
					trafficOffencePlace = trim(trafficOffencePlace);
					if (trafficOffencePlace == "") {
						window.parent.alertmessage("请输入违法地点");
						return false;
					}
					var trafficOffenceAct = document.getElementById("trafficOffenceAct").value;
					trafficOffenceAct = trim(trafficOffenceAct);
					if (trafficOffenceAct == "") {
						window.parent.alertmessage("请输入违法行为");
						return false;
					}
					var scoreop=document.getElementById("scoreop");
					var index = scoreop.selectedIndex;
					var score= scoreop.options[index].value;
					score=trim(score);
					if(score==""){
						window.parent.alertmessage("请选择计分值");
						return false;
					}
					var money = document.getElementById("money").value;
					money = trim(money);
					if (money == "") {
						window.parent.alertmessage("请输入罚款金额");
						return false;
					}
					var dlNumber = document.getElementById("dlNumber").value;
					dlNumber = trim(dlNumber);

					var plateNumber = document.getElementById("plateNumber").value;
					plateNumber = trim(plateNumber);
					if (plateNumber == "") {
						window.parent.alertmessage("请输入车牌号");
						return false;
					}
					var punishOffice = document.getElementById("punishOffice").value;
					punishOffice = trim(punishOffice);
					if (punishOffice == "") {
						window.parent.alertmessage("请输入处罚机关");
						return false;
					}

					var needwindowop=document.getElementById("needwindowop");
					var index = needwindowop.selectedIndex;
					var needwindow= needwindowop.options[index].value;
					needwindow=trim(needwindow);
					if(needwindow==""){
						window.parent.alertmessage("请选择是否需要窗口办理");
						return false;
					}
					ajaxRequest(trafficOffenceDate,trafficOffencePlace,trafficOffenceAct,score,money,dlNumber,plateNumber,punishOffice,needwindow);
				}


				function ajaxRequest( trafficOffenceDate,trafficOffencePlace,trafficOffenceAct,score,money,dlNumber,plateNumber,punishOffice,needwindow) {
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

					ajax.open("post", "/illegal/addTrafficOffence.do");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("trafficOffenceDateStr="+trafficOffenceDate+"&trafficOffencePlace="+trafficOffencePlace+"&trafficOffenceAct="+trafficOffenceAct+"&score="+score+"&money="+money+"&dlNumber="+dlNumber+"&plateNumber="+plateNumber+"&punishOffice="+punishOffice+"&needWindow="+needwindow);
				}

				function reset() {
					document.getElementById("academicName").value="";
				}
		</script>
	</head>
	<body>
			<table class="table_context" width="100%">
						<tr>
							<td width="10%" height="50" align="right">违法日期:</td>
							<td width="10%" height="50" align="left"> <input id="trafficOffenceDate" name="trafficOffenceDate" type="text" placeholder="yyyy-mm-dd"  autocomplete="off"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">违法地点:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="trafficOffencePlace" name="trafficOffencePlace" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">违法行为:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="trafficOffenceAct" name="trafficOffenceAct" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">计分:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="score" id="scoreop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden ></option>
								<option value="1" >1</option>
								<option value="2" >2</option>
								<option value="3" >3</option>
								<option value="4" >4</option>
								<option value="5" >5</option>
								<option value="6" >6</option>
								<option value="7" >7</option>
								<option value="8" >8</option>
								<option value="9" >9</option>
								<option value="10" >10</option>
								<option value="11" >11</option>
								<option value="12" >12</option>
							</select></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">罚款金额:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="money" name="money" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">驾驶证号:</td>
							<td width="10%" height="50" align="left"><input id="dlNumber" name="dlNumber" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">车牌号:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="plateNumber" name="plateNumber" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">处罚机关:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><input id="punishOffice" name="punishOffice" type="text"></td>
						</tr>
						<tr>
							<td width="10%" height="50" align="right">是否需要窗口办理:<span style="color: red;">*</span></td>
							<td width="10%" height="50" align="left"><select name="needwindowop" id="needwindowop" style="height: 25px ;width: 200px"  >
								<option selected disabled hidden ></option>
								<option value="0" >不需要窗口办理</option>
								<option value="1" >需要窗口办理</option>
							</select></td>
						</tr>
	                    <tr>
							<td height="50" colspan="2" align="center"><button class="layui-btn" onclick="addTrafficOffence()">保存数据</button><button class="layui-btn layui-btn-danger" onclick="reset()">取消编辑</button></td>
	                    </tr>
			</table>
	</body>
	<script>
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem: '#trafficOffenceDate', //指定元素
				type: 'datetime',
				position :"fixed"
			});
		});
	</script>
</html>
