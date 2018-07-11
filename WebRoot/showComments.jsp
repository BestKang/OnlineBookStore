<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showComments.jsp' starting page</title>
    
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
	/*$("#btn").click(function(){
		$.ajax({
			type:"POST",
			url:"showComments?t="+new Date().getTime(),
			data:$("#showCommsForm").serialize(),
			dataType:"json",
			cache:false,
			success:function(data){
				alert(data["result"]);
			},
			error:function(xhr){
				alert("error: "+xhr.responseText);
			}
		})
})*/
</script>
  </head>
  
  <body>
  <form id="showCommsForm" method="post" action="showComments">
  	输入bookId<input type="text" id="bookId" name="idbook">
  	书籍类型:<select name="booktype">
  	<option value="eBook">电子书</option>
  	<option value="oBook">二手书</option>
  	<option value="pBook">实体书</option>
  	</select><br>
    <input type="submit" value="查看评论" id="showComms">
    </form>
    <hr>
     <form id="writeCommsForm" method="post" action="writeComments">
  	输入bookId<input type="text" id="bookId" name="idbook"><br>
  	输入userId<input type="text" id="userId" name="iduser"><br>
  	选择书籍类型:<select name="booktype">
  	<option value="eBook">电子书</option>
  	<option value="oBook">二手书</option>
  	<option value="pBook">实体书</option>
  	</select><br>
  	评论内容：<textarea name="comment" rows="3" cols="70"></textarea><br>
  	评论日期:<input type="text" name="commentTime">
    <input type="submit" value="发表评论" id="writComments">
    </form>
  </body>
</html>
