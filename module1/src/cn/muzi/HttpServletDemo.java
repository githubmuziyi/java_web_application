package cn.muzi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by muzi on 2017/10/26.
 * HttpServlet案例
 *
 * 线程安全：
 *      1.要实现线程安全的servlet需要实现SingleThreadModel接口
 *          非标准的线程安全解决方式（不再建议）
 *      2.synchronized解决
 *      3.避免使用共享变量
 *
 * Servlet初始化参数：（例如db的链接信息就可以通过初始化参数配置）
 *      ServletConfig对象用于封装servlet的配置信息
 *      <init-param>
            <param-name>name</param-name>
            <param-value>muzi</param-value>
        </init-param>
 */
public class HttpServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getOutputStream().write("hello httpservlet".getBytes());
        //String name = this.getServletConfig().getInitParameter("name");
        Enumeration enumeration = this.getServletConfig().getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramsName = (String) enumeration.nextElement();
            String value = this.getServletConfig().getInitParameter(paramsName);
            System.out.println(paramsName + ":" + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
