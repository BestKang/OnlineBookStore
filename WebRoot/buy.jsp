<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="shopping" method= "post">
   rcname <input type="text" name="rcname"><br>
    idPbook <input type="text" name="idPbook"><br>
    pbookAbstract  <input type="text" name="pbookAbstract"><br>
    pbookClickTimes   <input type="text" name="pbookClickTimes"><br>
    pbookName    <input type="text" name="pbookName"><br>
     pbookPictureUrl    <input type="text" name="pbookPictureUrl"><br>
      pbookPrice    <input type="text" name="pbookPrice"><br>
   pbookPublisher   <input type="text" name="pbookPublisher"><br>
   pbookPublishTime    <input type="text" name="pbookPublishTime"><br>
       
   pbookSoldNumber    <input type="text" name="pbookSoldNumber"><br>
     pbookStockNumber   <input type="text" name="pbookStockNumber"><br>
     pbookWriter    <input type="text" name="pbookWriter"><br>
    number      <input type="text" name="number"><br>
      idUser     <input type="text" name="idUser"><br>
    <input type="submit" value="dianji">
    </form>
  </body>
</html>
