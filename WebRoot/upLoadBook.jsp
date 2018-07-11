<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upLoadBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="jquery/jquery-2.0.3.js"></script><!-- 这个是jquery库，需自己下载 -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	$(document).ready(function(){
		$.ajax({
			type:"POST",
			url:"isLogin?t="+new Date().getTime(),
			dataType:"json",
			cache:false,
			success:function(data){
				if(data["result"]=="已登录"){
					alert(data["result"]+":{用户名:"+data["userName"]+",用户id:"+data["idUser"]+"}");
					$("#writerId").val(data["idUser"]);
					$("#writerName").val(data["userName"]);
				}
				else
				{
					alert(data["result"]);
					window.location.href="index.jsp";
				}
			},
			error:function(xhr){
				alert("error: "+xhr.responseText);
			}
		})
		})
	</script>

  </head>
  
  <body>
    <form id="CommitForm" method="post" enctype="multipart/form-data" action="upLoadBook">
    <input type="file" name="UserPic" id="userPic" ><br>
    <!--  <input type="text" name="hello"><br>-->
     书籍名称:：<input type="text" name="ebookName"><br>
   上传 日期：<input type="text" name="ebookTime"><br>
    上传封面：<input type="file" name="bookPic"><br>
    上传作品压缩包：<input type="file" name="TxtInfo"><br>
    作品简介:<input type="text" name="ebookAbstract"><br>
 <input type="hidden" name="ebookWriter" id="writerId">
 <input type="hidden" name="ebookWriterName" id="writerName">
    <input type="submit" id="CommitBtn" value="点击上传">
    </form>
  </body>
</html>
