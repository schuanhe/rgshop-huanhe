package com.rgshop.servlet;

import com.rgshop.dao.ShangPinDao;
import com.rgshop.model.Page;
import com.rgshop.model.ShangPin;
import com.rgshop.util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllShangPinServlet", value = "/AllShangPinServlet")
public class AllShangPinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //处理乱码问题
        int pageSize = 8;
        //读取传递参数 小于0或者空设置为一
        Integer pageNum;
        try {
            pageNum = Integer.parseInt(request.getParameter("page"));
            if (pageNum <= 0){
                pageNum = 1;
            }
        }catch (Exception e){
            pageNum=1;
        }

        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        ShangPinDao spd = new ShangPinDao();
        List<ShangPin> allShangPins = new ArrayList<ShangPin>();
        Page page = new Page();

        try {
            conn = dbUtil.getCon();
            int recordCount = spd.getPageNum(conn);//获取全部数据条数
            allShangPins = spd.getPage(conn, pageNum, pageSize);//获取指定数据段
            page = new Page(pageNum,pageSize,recordCount,allShangPins);//生成page类


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 将商品信息放入request对象
        //request.setAttribute("sps", allShangPins);
        //将分页信息传入对象
        request.setAttribute("page",page);
        // 转发至listAllShangPin.jsp
        request.getRequestDispatcher("listAllShangPin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
