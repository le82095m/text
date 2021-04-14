package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/test")
public class Test2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //返回文件（浏览器下载）
        resp.setContentType("application/octet-stream");
        //读取本地硬盘文件，在输出
        FileInputStream file = new FileInputStream("D:\\JavaSE 图片素材\\Java集合框架.png");
        BufferedInputStream bis = new BufferedInputStream(file);
        OutputStream os = resp.getOutputStream();
        byte[] bytes = new byte[1024*24];
        int len = 0;
        while((len = bis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        os.flush();
        os.close();
        bis.close();
        file.close();
    }
}
