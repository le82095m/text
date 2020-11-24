package aim.jdbc.test;

import java.sql.*;

public class Example {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //连接数据库
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        //创建操作命令
        Statement statement = connection.createStatement();
        //创建SQL语句
//        boolean resultSet1 = statement.execute("insert into student(sn,name,qq_mail,class_id)values(15846,'程咬金'," +
//                "null," +
//                "2)");
        boolean res = statement.execute("delete from score where student_id " +
                "=4 and course_id = 6 and score = 80");
        System.out.println(res);
//        boolean res = statement.execute("insert into score(score," +
//                "student_id,course_id)values(80,4,6),(65,4,1),(76,4,3),(59,4," +
//                "4)");
//        ResultSet res = statement.executeQuery("select stu.name,cla.name from student stu join class cla on stu" +
//                ".class_id = cla.id where cla.name = '中文系2019级3班'");
//        while(res.next()){
//            String stu_name = res.getString("stu.name");
//            String cla_name = res.getString("cla.name");
//            System.out.println(String.format("%s  |  %s",cla_name,stu_name));
//        }
        ResultSet resultSet = statement.executeQuery("select id,sn,name,qq_mail,class_id from student");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            int sn = resultSet.getInt("sn");
            String name = resultSet.getString("name");
            String qq_mail = resultSet.getString("qq_mail");
            int class_id = resultSet.getInt("class_id");
            System.out.println(String.format("id=%d  |  sn=%d  |  name=%s  |  qq_mail=%s  |  class_id=%d",id,sn,name,qq_mail,class_id));
        }

        if(resultSet != null){
            try {
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
