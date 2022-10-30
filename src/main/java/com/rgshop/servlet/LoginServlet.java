package com.rgshop.servlet;

import com.rgshop.dao.ShangPinDao;
import com.rgshop.dao.UserDao;
import com.rgshop.model.ShangPin;
import com.rgshop.model.User;
import com.rgshop.util.BeanUtil;
import com.rgshop.util.DbUtil;
import com.rgshop.util.Md5Util;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");      // 处理需求中的中文乱码
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-type","application/json");//返回json数据


        if (request.getParameter("username")==null||request.getParameter("password")==null){
            response.getWriter().write("{\"code\":false,\"msg\":\"你丫的东西没填完\"}");//返回正确的
            return;
        }


        Md5Util md5Util = new Md5Util();//导入md5加密类
        User user = new User();

        user.setName(request.getParameter("username"));
        user.setPassword(md5Util.MD5(request.getParameter("password")));//吧密码进行md5加密一哈试试



        // 连接数据库，并将新增商品信息写入商品数据表
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;

        UserDao userDao = new UserDao();

        try {


            conn = dbUtil.getCon();
            User user1 = userDao.Login(conn, user);//获取登录
            if (user1!=null) {

                //登录成功
                String name = "key";
                String value = md5Util.MD5(user1.getName()+user1.getPassword()+"123");//账号+密码+盐

                Cookie cookie = new Cookie(name, value);//写入key的
                cookie.setMaxAge(60*60*24*15);//设置15天过期
                response.addCookie(cookie);//将cookie写入

                response.addCookie(new Cookie("user",user1.getName()));//dddd
                response.addCookie(new Cookie("qq",user1.getQq()));//吧q存到cookie

                response.getWriter().write("{\"code\":true,\"msg\":\"正确的\"}");//返回正确的
            }
            else {

               //登录错误
                response.getWriter().write("{\"code\":false,\"msg\":\"账号或密码错误\"}");//返回错误
            }
        } catch (Exception e) {
            response.getWriter().write("{\"code\":false,\"msg\":\"未知错误\"}");//返回错误
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }







    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
