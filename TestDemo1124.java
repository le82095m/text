package aim.jdbc.test;


import javax.management.QueryEval;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static <Emp> void main(String[] args) throws SQLException, ClassNotFoundException {
        //一、创建并连接数据库

        // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法
        //区，并执行该类的静态方法块、静态属性。
        Class.forName("com.mysql.jdbc.Driver");
        // 创建数据库连接
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123&useUnicode=true&characterEncoding=UTF-8");
        //二、创建操作命令
        Statement statement = connection.createStatement();

        //三、执行SQL语句
        ResultSet resultSet = statement.executeQuery("select id,name,role,salary from emp");

        //三、处理结果集
        List<TestDemo.Emp> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String role = resultSet.getString("role");
            BigDecimal salary = resultSet.getBigDecimal("salary");
            list.add(new TestDemo.Emp(id, name, role, salary));
        }
        System.out.println(list);

        //五、释放资源（关闭结果集、命令、连接）
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static class Emp{
        private int id;
        private String name;
        private String role;
        private BigDecimal salary;

        public Emp(int id, String name, String role, BigDecimal salary) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}