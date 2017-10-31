package cn.muzi;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by muzi on 2017/10/31.
 * request域
 */
public class RequestDemo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取URI
         */
        System.out.println(req.getRequestURI());
        /**
         * 获取URL
         */
        System.out.println(req.getRequestURL());
        /**
         * 获取请求参数
         */
        System.out.println(req.getQueryString());
        /**
         * 得到请求ip地址
         */
        System.out.println(req.getRemoteAddr());
        /**
         * 得到请求主机名
         */
        System.out.println(req.getRemoteHost());
        /**
         * 得到客户端所使用的网络端口号
         */
        System.out.println(req.getRemotePort());
        /**
         * 得到服务器的ip地址
         */
        System.out.println(req.getLocalAddr());
        /**
         * 得到服务器的主机名
         */
        System.out.println(req.getLocalName());
        /**
         * 得到客户端的请求方式
         */
        System.out.println(req.getMethod());
        /**
         * 获取请求头
         */
        System.out.println(req.getHeader("Accept-Encoding"));
        Enumeration enumeration2 = req.getHeaders("Accept-Encoding");
        while (enumeration2.hasMoreElements()) {
            System.out.println((String) enumeration2.nextElement());
        }
        Enumeration enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            System.out.println((String) enumeration.nextElement());
        }
        /**
         * 获取请求数据
         */
        System.out.println(req.getParameter("username"));
        Enumeration enumeration1 = req.getParameterNames();
        while (enumeration1.hasMoreElements()) {
            String paramName = (String) enumeration1.nextElement();
            System.out.println(req.getParameter(paramName));
        }
        String[] values = req.getParameterValues("username");
        for (int i = 0; values != null && i < values.length; i++) {
            System.out.println(values[i]);
        }
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //文件上传
        InputStream inputStream = req.getInputStream();
        int len = 0;
        byte buffer[] = new byte[1024];
        while ((len = inputStream.read(buffer)) > 0) {
            System.out.println(new String(buffer, 0, len));
        }

    }
}
