package cn.muzi;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by muzi on 2017/10/26.
 * servlet案例
 */
public class ServletDemo extends GenericServlet{

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        OutputStream outputStream = servletResponse.getOutputStream();
        outputStream.write("hello world!".getBytes());
    }
}
