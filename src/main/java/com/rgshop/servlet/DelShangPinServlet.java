package com.rgshop.servlet;

import com.rgshop.dao.ShangPinDao;
import com.rgshop.util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "DelShangPinServlet", value = "/DelShangPinServlet")
public class DelShangPinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //处理乱码问题
        //读取传递参数
        Integer spid = Integer.parseInt(request.getParameter("spid"));

        DbUtil dbUtil =new DbUtil();
        Connection conn = null;
        ShangPinDao spd = new ShangPinDao();
        try {

            conn = dbUtil.getCon();
            spd.delShangPinBySpid(conn, spid);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                dbUtil.closeCon(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("AllShangPinServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
