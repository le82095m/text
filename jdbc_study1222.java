package jdbc.test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Info {
    String class_name;
    String student_name;
    int sn;
    String course_name;
    BigDecimal score;

    public Info(String class_name, String student_name, int sn,
                String course_name, BigDecimal score) {
        this.class_name = class_name;
        this.student_name = student_name;
        this.sn = sn;
        this.course_name = course_name;
        this.score = score;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getSn() {
        return sn;
    }

    public String getCourse_name() {
        return course_name;
    }

    public BigDecimal getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Info{" +
                "class_name='" + class_name + '\'' +
                ", student_name='" + student_name + '\'' +
                ", sn=" + sn +
                ", course_name='" + course_name + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
//1. 创建数据库连接Connection
//2. 创建操作命令Statement
//3. 使用操作命令来执行SQL
//4. 处理结果集ResultSet
//5. 释放资源
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法
        //区，并执行该类的静态方法块、静态属性。
        Class.forName("com.mysql.jdbc.Driver");
        // 创建数据库连接
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/test" +
                "?user=root&password=123&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        Connection connection = ds.getConnection();
        //        Connection connection =
//                DriverManager.getConnection("jdbc:mysql://localhost:3306/test" +
//                        "?user=root&password=123&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        //创建操作命令Statement
        Statement statement = connection.createStatement();
        //使用操作命令来执行SQL
        ResultSet resultSet = statement.executeQuery("select cla.name class_name,stu.name student_name,stu.sn,cou.name course_name,sco.score\n" +
                "from student stu\n" +
                "join score sco on sco.student_id = stu.id\n" +
                "join course cou on sco.course_id = cou.id\n" +
                "join class cla on stu.class_id = cla.id\n" +
                "where cla.name = '计算机系2019级1班';");
        //处理结果集ResultSet
        List<Info> list = new ArrayList<>();
        while(resultSet.next()){
            Info i = new Info(resultSet.getString("class_name"),resultSet.getString(
                    "student_name"),resultSet.getInt("stu.sn"),resultSet.getString(
                            "course_name"),resultSet.getBigDecimal("sco.score"));
            list.add(i);
        }
        System.out.println(list.toString());
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
