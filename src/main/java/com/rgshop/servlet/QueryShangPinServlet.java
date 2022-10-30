package com.rgshop.servlet;

import com.rgshop.dao.ShangPinDao;
import com.rgshop.model.Page;
import com.rgshop.model.ShangPin;
import com.rgshop.model.ShangPinQuery;
import com.rgshop.util.BeanUtil;
import com.rgshop.util.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryShangPinServlet", value = "/QueryShangPinServlet")
public class QueryShangPinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");      // 处理需求中的中文乱码
        int pageSize = 8;
        //获取session 对象
        HttpSession session = request.getSession();

        //页数判断
        Integer pageNum;
        try {
            pageNum = Integer.parseInt(request.getParameter("page"));
            if (pageNum <= 0){
                pageNum = 1;
            }
        }catch (Exception e){
            pageNum=1;
        }

        //搜索捏
        ShangPinQuery spq=new ShangPinQuery();
        try {
            spq = (ShangPinQuery) BeanUtil.copyParams(ShangPinQuery.class,request);
            if(spq.getSpdj_from()==null){
                spq = (ShangPinQuery)session.getAttribute("spq");
                spq.getSpdj_from();//这就是都没有
            }

        }catch (Exception e){
            request.getRequestDispatcher("AllShangPinServlet").forward(request, response);//session和post里都没有就回首页
        }finally {
            session.setAttribute("spq", spq);//反正是老还是新都存在spq里面捏
        }


//        //查看旧商品查询条件存在不
//        try {
//            spq = (ShangPinQuery)session.getAttribute("spq");//旧的商品查询条件
//
//        }catch (Exception e){
//            spq = (ShangPinQuery) BeanUtil.copyParams(ShangPinQuery.class,request);//session没有就需要这一步，获取post的
//        }finally {
//            session.setAttribute("spq", spq);//反正是老还是新都存在spq里面捏
//        }


        
        Page page = new Page();

        // 连接数据库，并将新增商品信息写入商品数据表
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        ShangPinDao spd = new ShangPinDao();

        try {
            conn = dbUtil.getCon();
            page = spd.queryShangPins(conn, spq,pageNum, pageSize);// 将查询商品
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        request.setAttribute("page", page);
        // 转发至listAllShangPin.jsp
        request.getRequestDispatcher("listAllShangPin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
