<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'commitPic.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="jquery/jquery-2.0.3.js"></script><!-- 这个是jquery库，需自己下载 -->
	<script>
	/*$(document).ready(function(){
	var form=new FormData(document.getElementById("CommitForm"));
	$("#CommitBtn").click(function(){
		$.ajax({
			type:"POST",
			url:"uploadpic?t="+new Date().getTime(),
			data:form,
			dataType:"json",
			cache:false,
			processData:false,
			contentType:false,
			success:function(data){
				alert(data["result"]);
			},
			error:function(xhr){
				alert("error: "+xhr.responseText);
			}
		})
	})
})*/
</script>
  </head>
  <body>
    <form id="CommitForm" method="post" enctype="multipart/form-data" action="userCenterUpdate">
    <input type="file" name="UserPic" id="userPic" ><br>
    用户名：<input type="text" name="updateUserName"><br>
    账号：<input type="text" name="userAccount"><br>
    密码：<input type="text" name="updateUserPassword"><br>
    地址：<input type="text" name="updateUserAddress"><br>
    电话：<input type="text" name="updateUserPhone"><br>
    <input type="submit" id="CommitBtn" value="点击上传">
    </form>
  </body>
</html>
