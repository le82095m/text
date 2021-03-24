package org.example.servlet;

import org.example.exception.AppException;
import org.example.model.JSONResponse;
import org.example.util.jsonUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        // Session 管理会话:除登录和注册接口外，其他都需要判断session
        // req.getServletPath();
        // 判断req的路径是否是登录路径或注册路径
        //TODO

        JSONResponse json = new JSONResponse();
        try {
            //调用子类重写的方法
            Object data = process(req, resp);
            //子类方法执行成功
            json.setSuccess(true);
            json.setData(data);
        } catch (Exception e) {
            //处理异常，JDBC的异常SQLException，JSON处理的异常，登录时自定义异常返回错误
            e.printStackTrace();
            String coda = "ERR000";
            String s = "未知的错误";
            if(e instanceof AppException){
                coda = ((AppException)e).getCoda();
                s = ((AppException)e).getMessage();
            }
            json.setCode(coda);
            json.setMassage(s);
        }
        PrintWriter pw = resp.getWriter();
        pw.println(jsonUtil.serialize(json));
        pw.flush();
        pw.close();
    }
    protected abstract Object process(HttpServletRequest req,
                                    HttpServletResponse resp) throws Exception;
}
