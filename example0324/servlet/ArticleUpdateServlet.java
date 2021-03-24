package org.example.servlet;


import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.util.jsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //请求数据类型是application/json，需要使用输入流获取
        InputStream is = req.getInputStream();
        Article a = jsonUtil.deserialize(is,Article.class);
        //插入一个文章信息
        int num = ArticleDAO.update(a);
        return null;
    }
}
