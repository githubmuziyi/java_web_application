<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.muzi.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>使用普通方式创建javabean的实例</h1>
    <%
        User user = new User();
        user.setName("muzi");
        user.setAge(26);
    %>
    用户名：<%=user.getName() %><br>
    年龄：<%=user.getAge() %><br>

    <h1>使用useBean动作创建javabean实例</h1>
    <jsp:useBean id="myUser" class="cn.muzi.User" scope="page"/>
    <jsp:setProperty name="myUser" property="name" value="wacai"/>
    <jsp:setProperty name="myUser" property="age" value="24"/>

    用户名：<jsp:getProperty name="myUser" property="name"/><br>
    年龄：<jsp:getProperty name="myUser" property="age"/><br>
</body>
</html>
