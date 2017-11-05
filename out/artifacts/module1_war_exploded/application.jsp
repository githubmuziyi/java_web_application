<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>application内置对象</h1>
    <%
        application.setAttribute("name", "muzi");
        application.setAttribute("age", 25);
        application.setAttribute("email", "muzi@gmail.com");
    %>
    年龄:<%=application.getAttribute("age") %><br>
    application的所用属相：<br>
    <%
        Enumeration attributes = application.getAttributeNames();
        while (attributes.hasMoreElements()) {
            out.println(attributes.nextElement() + "&nbsp;&nbsp;<br>");
        }
    %><br>
    JSP(SERVLET)引擎版本号：<%=application.getServerInfo() %><br>
</body>
</html>
