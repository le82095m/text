package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/myServletData"+
            "?user=root&password=123&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final DataSource ds = new MysqlDataSource();
    static {
        ((MysqlDataSource)ds).setURL(URL);
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            //自定义异常
            throw new AppException("获取数据库连接失败",e);
        }
    }
}
