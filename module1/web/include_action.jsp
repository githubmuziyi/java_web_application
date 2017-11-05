<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Include动作</h1>
    include指令和include动作的区别：<br>
    1.语法格式不一样 <br>
    2.包含的内容不一样，include指令包含的是文件的实际内容，include动作包含的是页面的输出<br>
    3.转换成的servlet不一样，include指令将主页面和被包含页面转换成一个servlet，include动作的主页面和被包含页面被转换为独立的servlet<br>
    4.include指令编译时间较慢，执行时间稍快，include动作正好相反
    <jsp:include page="date.jsp" flush="true"/>
</body>
</html>
