<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'busket.jsp' starting page</title>
    
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
  <!-- bookId;
	private String bookType;
	private String option;
	private String num; -->
    <form method="post" action="busket">
   bookId: <input type="text" name="bookId">
   bookType:<select name="bookType">
   <option value="ebook">电子书</option>
   <option value="obook">二手书</option>
   <option value="pbook">实体书</option>
   </select><br>
   optionType:<select name="option">
   <option value="add">添加到购物车</option>
   <option value="removeAll">清空购物车</option>
   <option value="payAll">结算</option>
   <option value="removeOne">清除一件</option>
   </select><br>
    bookNum:<input type="text" name="num"><br>
    <input type="submit" value="提交">
    </form>
    <hr>
    <form action="showBusketInfo" method="post">
    <input type="submit" value="查看购物车">
    </form>
  </body>
</html>
