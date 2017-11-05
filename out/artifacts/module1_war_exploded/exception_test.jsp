<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="exception.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试异常页面</h1>
    <%
        System.out.println(100 / 0);
    %>
</body>
</html>
