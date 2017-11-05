package cn.muzi;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by muzi on 2017/11/4.
 * 应用:
 *  1.使用session完成用户登录
 *  2.利用session防止表单重复提交（生成表单唯一号存储在session中）
 *  3.利用session实现一次性验证码的校验
 */
public class SessionDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        /**
         * 设置session(服务器默认创建的session没有有效期，在关闭浏览器后记录在cookie的session_id会消失)
         * 我们可以自己设置session的有效期
         */
        HttpSession session = req.getSession();
        //设置session有效期
        String sessionId = session.getId();
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setPath("/module1");
        cookie.setMaxAge(30*60);
        //设置session的值
        session.setAttribute("name", "空调");
        /**
         * 摧毁session
         */
        //session.invalidate();
        /**
         * 只获取不创建session
         */
        //HttpSession session1 = req.getSession(false);
        String name = (String) session.getAttribute("name");
        /**
         * 用户禁用cookie的解决方案
         * 方案：
         *  通过response对象的encodeURL方法可以把sessionid追加到url链接的后面
         *  getSession方法在获取sessionid时首先到cookie里面取，没有的话到url里面取
         *  encodeURL方法在用户禁用cookie的情况下才会把sessionid追加到url后面
         */
        String url = resp.encodeURL("/module1/cookieservlet");

        PrintWriter out = resp.getWriter();
        out.write(name);
        out.write(url);
    }
}
