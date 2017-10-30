package cn.muzi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by muzi on 2017/10/29.
 * response域
 */
public class ResponseDemo extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 输出中文
         * 字节流
         */
        String date = "中国";
        //设置编码头 方式1
        //resp.setHeader("Content-type", "text/html;charset=UTF-8");
        //用html中的meta标签模拟http响应头来控制浏览器的行为 方式2
        //resp.getOutputStream().write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        //resp.getOutputStream().write(date.getBytes("UTF-8"));
        /**
         * 输出中文
         * 字符流
         */
        //设置response使用的码表,以控制response以❓码表向浏览器写数据
        //resp.setCharacterEncoding("UTF-8");
        //resp.setHeader("Content-type", "text/html;charset=UTF-8");
        //resp.getWriter().write(date);
        /**
         * 文件下载
         */
        /*String img_path = this.getServletContext().getRealPath("/download/IMG_0332.JPG");
        String file_name = img_path.substring(img_path.lastIndexOf("/") + 1);
        //设置文件头
        //如果文件名含有中文，文件名需要经过url编码
        resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file_name, "UTF-8"));
        InputStream in = new FileInputStream(img_path);
        OutputStream out = resp.getOutputStream();
        int len = 0;
        byte buffer[] = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();*/
        /**
         * 生成随机验证码图片
         */

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
