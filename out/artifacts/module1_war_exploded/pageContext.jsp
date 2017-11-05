<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>pageContext内置对象</h1>
    session_id: <%=pageContext.getSession().getId() %>
    <%
        //跳转
        pageContext.forward("index.jsp");
        //包含
        pageContext.include("exercise.jsp");
    %>
</body>
</html>
