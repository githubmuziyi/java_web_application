<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>param动作</h1>
    <jsp:forward page="date.jsp">
        <jsp:param name="name" value="muzi"/>
    </jsp:forward>
</body>
</html>
