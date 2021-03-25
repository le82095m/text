package org.example.dao;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class loginDAO {
    public static User query(String username) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, username, password," +
                    " nickname, head, sex, birthday" +
                    " from user where username=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,username);
            //设置占位符
            r = ps.executeQuery();
            User user = null;
            while(r.next()){
                user = new User();
                //设置user的值
                user.setId(r.getInt("id"));
                user.setUsername(r.getString("username"));
                user.setPassword(r.getString("password"));
                user.setNickname(r.getString("nickname"));
                user.setSex(r.getBoolean("sex"));
                //关于日期的使用，java中一般使用java.util.Date//年月日时分秒
                //rs.getData()返回值时java.sql.Data//时分秒
                //rs.getTimestamp()返回值是java.sql.Timestamp//年月日时分秒
                java.sql.Date bir = r.getDate("birthday");
                if(bir == null){
                    user.setBirthday(null);
                }else {
                    user.setBirthday(new Date(bir.getTime()));
                }
                user.setHead(r.getString("head"));
            }
            return user;
        }catch (Exception e){
            throw new AppException("LOG001","查询用户操作出错",e);
        }finally {
            DBUtil.close(c,ps,r);
        }
    }
}