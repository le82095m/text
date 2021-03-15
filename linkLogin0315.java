package jdbc;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.sql.DriverManager;

@WebServlet("/linkLogin")
public class linkLogin extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        //一、创建并连接数据库

        // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法
        //区，并执行该类的静态方法块、静态属性。
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 创建数据库连接
        Connection connection =
                null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123&useUnicode=true&characterEncoding=UTF-8");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //二、创建操作命令
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //三、创建sql语句
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select name,password from user");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //四、处理结果集

    }
}
