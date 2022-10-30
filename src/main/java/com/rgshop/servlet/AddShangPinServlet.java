//4. 创建接收新增商品信息的servlet
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

@WebServlet(name = "AddShangPinServlet", value = "/AddShangPinServlet")
public class AddShangPinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");      // 处理需求中的中文乱码

        // 接收addShangPin.jsp传递的商品信息
        ShangPin sp = new ShangPin();
        sp = (ShangPin) BeanUtil.copyParams(ShangPin.class, request);


        // 连接数据库，并将新增商品信息写入商品数据表
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        ShangPinDao spd = new ShangPinDao();

        try {
            conn = dbUtil.getCon();
            spd.addShangPin(conn, sp);      // 将新增商品信息写入数据表
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 6. 转发至显示所有商品信息的servlet
        request.getRequestDispatcher("AllShangPinServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
