<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>out内置对象</h1>
    <%
        out.println("<h2>静夜思</h2>");
        out.println("窗前明月光<br>");
        out.println("疑似地上霜<br>");
        out.flush(); //将缓冲区内容输出到客户端
        //out.clear() 清楚缓冲区内容，如果在flush之后调用会抛出异常
        //out.clearBuffer 清除缓冲区内容，如果在flush之后调用不会抛出异常
        out.println("举头望明月<br>");
        out.println("低头思故乡<br>");
    %>
    缓冲区大小：<%=out.getBufferSize() %><br>
    缓冲区剩余大小：<%=out.getRemaining() %><br>
    是否自动刷新缓冲区：<%=out.isAutoFlush() %><br>
</body>
</html>
