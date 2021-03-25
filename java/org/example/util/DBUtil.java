package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/myServletData"+
            "?user=root&password=123&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final DataSource ds = new MysqlDataSource();

    /**
     *
     * 工具类提供数据库JDBC操作
     * 不足：1.static代码快出现错误，NoClassDefFoundError，类找到但类加载失败
     * 2.学多线程后，可能会采取双重校验的单例模式来创建DataSource
     * 3.工具类设计上不是最优，数据库框架ORM框架Mybatis，都是模板模式设计的
     */
    static {
        ((MysqlDataSource)ds).setURL(URL);
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            //自定义异常
            throw new AppException("DB000","获取数据库连接失败",e);
        }
    }

    public static void close(Connection c, Statement s){
        close(c,s,null);
    }

    public static void close(Connection c , Statement s , ResultSet r) {
        try {
            if (r != null) {
                r.close();
            }
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            throw new AppException("DB002","释放资源出错",e);
        }
    }
}
