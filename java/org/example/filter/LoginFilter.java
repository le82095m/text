package org.example.filter;

import org.example.model.JSONResponse;
import org.example.util.JsonUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 配置用户统一会话管理的过滤器，匹配所有请求路径
 * 服务端资源：/login不用校验Session,其他都要校验,如果不通过，返回401，响应内容随便
 * 前端资源：/jsp/需要校验Session，不通过重定向到登录页面
 *         /js/,/static/,/view/ 全部不校验
 *
 * */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *
     * 每次http请求匹配到过滤器路径时，会执行doFilter
     * 如果往下执行，是调用filterChain.doFilter(request,response)
     * 否则自行处理
     *
     * */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();//获取当前请求的服务路径
        //不需要登录允许访问：往下执行继续调用
        if(servletPath.startsWith("/js/") || servletPath.startsWith("/static/") ||
                servletPath.startsWith("/view/") || servletPath.equals("/login")){
            filterChain.doFilter(request,response);
        }else{
            //获取Session对象,没有就返回null
            HttpSession session = req.getSession(false);
            //验证用户是否登录，如果没有登录，还需要根据前端或后端左不同处理
            if(session == null || session.getAttribute("user") == null){
                //前端重定向到登录页
                if(servletPath.startsWith("/jsp/")){
                    resp.sendRedirect(basePath(req)+"/view/login.html");
                }else{//后端返回401状态码
                    resp.setStatus(401);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    JSONResponse json = new JSONResponse();
                    json.setCode("LOG000");
                    json.setMassage("用户没有登录，不允许访问");
                    PrintWriter pw = resp.getWriter();
                    pw.println(JsonUtil.serialize(json));
                    pw.flush();
                    pw.close();
                }
            }else{
                filterChain.doFilter(request,response);
            }
        }
    }

    /**
     *
     * 根据http请求，动态的获取访问路径
     *
     * */

    public static String basePath(HttpServletRequest req){
        String schema = req.getScheme();// http
        String host = req.getServerName();// 主机ip或域名
        int port = req.getServerPort(); //服务器端口号
        String contextPath = req.getContextPath(); //应用上下文路径
        return schema +"://"+host+":"+ port + contextPath;
    }

    @Override
    public void destroy() {

    }
}
