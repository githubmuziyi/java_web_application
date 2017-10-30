package cn.muzi;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.Random;

/**
 * Created by muzi on 2017/10/29.
 * response域
 */
public class ResponseDemo extends HttpServlet{

    public static final int WIDTH = 120;
    public static final int HEIGHT = 35;

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
        /*//生成内存图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //获取到图片画布
        Graphics graphics = image.getGraphics();
        //设置背景色
        setBackGroundColor(graphics);
        //设置边框
        setBorder(graphics);
        //画干扰线
        drawRandomLine(graphics);
        //写随机数
        drawRandomNum((Graphics2D) graphics);
        //输出到浏览器
        resp.setContentType("image/jpeg");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", -1);
        ImageIO.write(image, "jpg", resp.getOutputStream());*/
        /**
         * 控制浏览器定时刷新
         */
        //方式1
        //resp.setHeader("refresh", "3;url='/module1/servletdemo'");
        //String day = new Random().nextInt() + "";
        //resp.getOutputStream().write(day.getBytes());
        //方式2
        String message = "<meta http-equiv='refresh' content='3;url=/module1/servletdemo'> 登入成功";
        this.getServletContext().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void drawRandomNum(Graphics2D graphics) {
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 20));
        //[\u4e00-\u9fa5] 中文
        String base = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765";
        int x = 5;
        for (int i = 0; i < 4; i++) {
            //旋转弧度
            int degree = new Random().nextInt() % 30;
            String s = base.charAt(new Random().nextInt(base.length())) + "";
            //旋转
            graphics.rotate(degree*Math.PI/180, x, 20);
            graphics.drawString(s, x, 20);
            //转回来
            graphics.rotate(-degree*Math.PI/180, x, 20);
            x = x + 30;
        }
    }

    private void drawRandomLine(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 4; i++) {
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    private void setBackGroundColor(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void setBorder(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }
}
