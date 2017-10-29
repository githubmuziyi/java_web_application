package cn.muzi.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by muzi on 2017/10/28.
 * servlet调用其他程序时，在其他文件中如何读取资源文件？ （通过类装载器读取）
 */
public class UserDao {

    private static Properties properties = new Properties();

    static {
        try {
            /**
             * 通过类装载器读取配置文件，在文件更新后，如果服务器不重启的话数据读取到的还是原来的数据（以为类装载器在装载文件时只装载一次）
             * 想要解决这个问题需要通过方式2读取
             */
            //方式1
            InputStream steam = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
            //方式2
            String path = UserDao.class.getClassLoader().getResource("db.properties").getPath();
            FileInputStream inputStream = new FileInputStream(path);
            properties.load(inputStream);
            properties.load(steam);
        } catch (IOException e) {
            throw new ExceptionInInitializerError();
        }
    }
    public void update() throws IOException {
        System.out.println(properties.getProperty("url"));
    }
}
