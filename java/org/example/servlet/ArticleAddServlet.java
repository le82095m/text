package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.User;
import org.example.util.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet{

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");
        //请求数据类型是application/json，需要使用输入流获取
        InputStream is = req.getInputStream();
        Article a = JsonUtil.deserialize(is,Article.class);
        //设置session里的用户id
        a.setUser_id(user.getId());
        //插入一个文章信息
        int num = ArticleDAO.insert(a);
        return null;
    }
}
