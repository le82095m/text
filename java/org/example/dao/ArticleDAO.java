package org.example.dao;

import org.example.exception.AppException;
import org.example.model.Article;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> queryByUserId(Integer userId) {
        List<Article> articles = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id,title from article where user_id=?";
            ps = c.prepareStatement(sql);
            //设置占位符的值
            ps.setInt(1,userId);
            r = ps.executeQuery();
            while (r.next()){
                Article a = new Article();
                //结果集取值设置到文章队象
                a.setId(r.getInt("id"));
                a.setTitle(r.getString("title"));
                articles.add(a);
            }
        }catch (Exception e){
            throw new AppException("ART001","查询文章列表出错");
        }finally {
            DBUtil.close(c,ps,r);
            return articles;
        }
    }

    public static int delete(String[] split) {
        int[] ints = new int[split.length];
        for(int i = 0; i < ints.length; i++){
            ints[i] = Integer.parseInt(split[i]);
        }
        Connection c = null;
        PreparedStatement ps = null;
        try{
           c = DBUtil.getConnection();
           StringBuilder sql = new StringBuilder("delete from article where id in (");
           for(int i = 0; i < split.length; i++){
               if(i != 0){
                   sql.append(',');
               }
               sql.append('?');
           }
           sql.append(')');
           ps = c.prepareStatement(sql.toString());
           //设置占位符的值
            for(int i = 0; i < split.length; i++){
                ps.setInt(i+1,ints[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e){
            throw new AppException("ART004","文章删除操作出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static int insert(Article a) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
           String sql = "insert into article(title,content,user_id) values (?,?,?)";
            ps = c.prepareStatement(sql);
           //替换占位符
           ps.setString(1,a.getTitle());
           ps.setString(2,a.getContent());
           ps.setInt(3,a.getUser_id());
           return ps.executeUpdate();
        }catch (Exception e){
            throw new AppException("ART005","新增文章操作出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static Article query(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select title,content from article where id=?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            r = ps.executeQuery();
            Article a = null;
            while(r.next()) {
                a = new Article();
                a.setId(id);
                a.setTitle(r.getString("title"));
                a.setContent(r.getString("content"));
            }
            return a;
        }catch (Exception e){
            throw new AppException("ART006","查询文章详情出错",e);
        }finally {
            DBUtil.close(c,ps,r);
        }
    }

    public static int update(Article a) {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = DBUtil.getConnection();
            String sql ="update article set title=?,content=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getId());
            return ps.executeUpdate();
        }catch (Exception e){
            throw new AppException("ART007","修改文章操作出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }
}
