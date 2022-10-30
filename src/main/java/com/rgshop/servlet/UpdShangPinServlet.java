package com.rgshop.servlet;

import com.rgshop.dao.ShangPinDao;
import com.rgshop.model.ShangPin;
import com.rgshop.util.BeanUtil;
import com.rgshop.util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdShangPinServlet", value = "/UpdShangPinServlet")
public class UpdShangPinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");      // 处理需求中的中文乱码

        // 接收addShangPin.jsp传递的商品信息


        ShangPin sp = (ShangPin) BeanUtil.copyParams(ShangPin.class,request);
//        ShangPin sp = new ShangPin();
//        sp.setSpid(Integer.parseInt(request.getParameter("spid")));
//        sp.setSpbh(request.getParameter("spbh"));
//        sp.setSpmc(request.getParameter("spmc"));


        // 连接数据库，并将新增商品信息写入商品数据表
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        ShangPinDao spd = new ShangPinDao();

        try {
            conn = dbUtil.getCon();
            spd.updShangPinById(conn, sp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        // 6. 转发至显示所有商品信息的servlet
//        request.getRequestDispatcher("listAllShangPin").forward(request, response);
        request.getRequestDispatcher("AllShangPinServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
