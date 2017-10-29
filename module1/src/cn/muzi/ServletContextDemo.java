package cn.muzi;

import cn.muzi.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by muzi on 2017/10/28.
 * servletContext实例 代表当前servlet应用
 * 由于一个web应用中的所有servlet共享同一个ServletContext对象，所以多个servlet通过ServletContext对象实现数据共享。
 * ServletContext对象通常也被称为context域对象（还有request、session、 page域）
 *
 * 应用：
 *  1.获取web应用的初始化参数
 *  2.实现servlet的转发
 *  3.利用servletContext对象读取资源文件
 *      得到文件路径
 *      读取资源文件
 *      .properties（属性文件）
 */
public class ServletContextDemo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到servletContext实例方式1
        ServletContext context = this.getServletConfig().getServletContext();
        //方式2
        context = this.getServletContext();
        //存数据
        String name = "muzi";
        context.setAttribute("name", name);
        //取数据
        String name_get = (String) context.getAttribute("name");
        //获取web应用的初始化参数
        String context_name = context.getInitParameter("context_name");
        //servlet转发
        RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
        //读取资源文件(方式1)
        InputStream stream = context.getResourceAsStream("/WEB_INF/classes/db.properties");
        Properties properties = new Properties();
        properties.load(stream);
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //读取资源文件（方式2）
        String path= context.getRealPath("/WEB_INF/classes/db.properties");
        FileInputStream inputStream = new FileInputStream(path);
        properties.load(inputStream);
        //调用其他类
        UserDao dao = new UserDao();
        dao.update();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
