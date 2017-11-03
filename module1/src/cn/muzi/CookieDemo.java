package cn.muzi;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by muzi on 2017/11/3.
 * cookie域
 */
public class CookieDemo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("上次访问时间：");
        //获取用户的cookie
        Cookie cookies[] = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("lastAccessTime")) {
                long cookieValue = Long.parseLong(cookies[i].getValue());
                Date date = new Date(cookieValue);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                writer.print(dateFormat.format(date));
            }
        }
        //写最新的cookie
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        //cookie生命时间
        cookie.setMaxAge(30*24*3600);
        //cookie生效路径
        cookie.setPath("/module1");
        resp.addCookie(cookie);
    }
}
