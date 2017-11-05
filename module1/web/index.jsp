<%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/10/25
  Time: 下午10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <h1>Hello World!</h1>

  <!--jsp声明-->
  <%!
    String name = "muzi";  //声明字符串变量
    int add(int x, int y) { //声明函数
      return x + y;
    }
  %>

  <!--jsp表达式-->
  你好，<%=name %>
  <br>
  x + y = <%=add(5, 6) %>

  </body>
<%--</html>--%>
