<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: muzi
  Date: 2017/11/5
  Time: 上午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exercise</title>
</head>
<body>
    <%!
        String printMultiTable() {
            String s = "";
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j <= i; j++) {
                    s+=i + "*" +j + "=" + (i*j) + "&nbsp;&nbsp;";
                }
                s+="<br>";
            }
            return s;
        }
        //JSP内置out对象，使用脚本方式调用
        void printMultiTable2(JspWriter out) throws IOException{
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j <= i; j++) {
                    out.println(i + "*" +j + "=" + (i*j) + "&nbsp;&nbsp;");
                }
                out.println("<br>");
            }
        }
    %>
    <h1>99乘法表</h1>
    <%=printMultiTable() %>
    <br>
    <%
        printMultiTable2(out);
    %>
</body>
</html>
