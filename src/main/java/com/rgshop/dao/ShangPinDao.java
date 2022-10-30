package com.rgshop.dao;

import com.rgshop.model.Page;
import com.rgshop.model.ShangPin;
import com.rgshop.model.ShangPinQuery;
import com.rgshop.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShangPinDao {
    public ShangPin getShangPinBySpbh(Connection conn, String spbh) throws Exception {
        StringBuffer sbSql = new StringBuffer("select * from tb_shangpin where spbh=?;");
        PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());
        pstmt.setString(1, spbh);

        ResultSet rs = pstmt.executeQuery();
        ShangPin sp = null;
        while (rs.next()) {
            sp = new ShangPin();

            sp.setSpbh(rs.getString("spbh"));
            sp.setSpmc(rs.getString("spmc"));
            sp.setSpdj(rs.getFloat("spdj"));
            sp.setSpsl(rs.getInt("spsl"));
            sp.setSpbz(rs.getString("spbz"));
        }

        return sp;
    }

    public ShangPin getShangPinBySpid(Connection conn, Integer spid) throws Exception {
        StringBuffer sbSql = new StringBuffer("select * from tb_shangpin where id=?;");
        PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());
        pstmt.setInt(1, spid);

        ResultSet rs = pstmt.executeQuery();
        ShangPin sp = null;
        while (rs.next()) {
            sp = new ShangPin();
            sp.setSpid(rs.getInt("id"));
            sp.setSpbh(rs.getString("spbh"));
            sp.setSpmc(rs.getString("spmc"));
            sp.setSpdj(rs.getFloat("spdj"));
            sp.setSpsl(rs.getInt("spsl"));
            sp.setSpbz(rs.getString("spbz"));
        }

        return sp;
    }

    /**
     * 获取商品总数量
     * @param conn
     * @return
     * @throws Exception
     */
    public int getPageNum(Connection conn) throws Exception{
        int pageNum = 0;
        StringBuffer sbSql = new StringBuffer("select count(id) from tb_shangpin");
        PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            pageNum = rs.getInt(1);
        }
        return pageNum;
    }


    /**
     * 根据页数和每页数量获取商品列表
     * @param conn
     * @param pageNum
     * @return
     * @throws Exception
     */
    public List<ShangPin> getPage(Connection conn,int pageNum,int pageSize) throws Exception{
        Page page = null;
        List<ShangPin> shangPins = new ArrayList<ShangPin>();

            StringBuffer sbSql = new StringBuffer("select * from tb_shangpin limit ?,?");
            PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());
            pstmt.setInt(1, (pageNum-1)*pageSize);
            pstmt.setInt(2, pageSize);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ShangPin sp = new ShangPin();
                sp.setSpid(rs.getInt("id"));
                sp.setSpbh(rs.getString("spbh"));
                sp.setSpmc(rs.getString("spmc"));
                sp.setSpdj(rs.getFloat("spdj"));
                sp.setSpsl(rs.getInt("spsl"));
                sp.setSpbz(rs.getString("spbz"));
                shangPins.add(sp);
            }
            return shangPins;
    }

    public List<ShangPin> getAllShangPins(Connection conn) throws Exception {
        List<ShangPin> shangPins = new ArrayList<ShangPin>();
        StringBuffer sbSql = new StringBuffer("select * from tb_shangpin;");

        PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ShangPin sp = new ShangPin();
            sp.setSpid(rs.getInt("id"));
            sp.setSpbh(rs.getString("spbh"));
            sp.setSpmc(rs.getString("spmc"));
            sp.setSpdj(rs.getFloat("spdj"));
            sp.setSpsl(rs.getInt("spsl"));
            sp.setSpbz(rs.getString("spbz"));

            shangPins.add(sp);
        }

        return shangPins;
    }

    // 5. 创建插入一条新记录的ShangPinDao方法
    public void addShangPin(Connection conn, ShangPin sp) throws Exception {
        String sql = "insert into tb_shangpin values(null, ?, ?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sp.getSpbh());
        pstmt.setString(2, sp.getSpmc());
        pstmt.setFloat(3, sp.getSpdj());
        pstmt.setInt(4, sp.getSpsl());
        pstmt.setString(5, sp.getSpbz());

        pstmt.executeUpdate();
    }

    //删除商品的方法
    public void delShangPinBySpid(Connection conn, Integer spid) throws Exception{
        String delsql = "delete from tb_shangpin where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(delsql);
        pstmt.setInt(1, spid);
        pstmt.executeUpdate();
    }
    //更新商品
    public void updShangPinById(Connection conn, ShangPin sp) throws Exception{
        String sql = "update tb_shangpin set spbh=?,spmc=?,spdj=?,spsl=?,spbz=? where id =?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, sp.getSpbh());
        pstmt.setString(2, sp.getSpmc());
        pstmt.setFloat(3, sp.getSpdj());
        pstmt.setInt(4, sp.getSpsl());
        pstmt.setString(5, sp.getSpbz());
        pstmt.setInt(6,sp.getSpid());

        pstmt.executeUpdate();

    }

    /**
     * 根据条件查询商品
     * @param conn 数据库链接
     * @param spq 查询条件
     * @return 商品列表
     * @throws Exception 抛出异常
     */
    public Page queryShangPins(Connection conn, ShangPinQuery spq ,int pageNum,int pageSize) throws Exception{
        StringBuffer sbSql = new StringBuffer("select * from tb_shangpin where 1=1");

        if (StringUtil.isNotEmpty(spq.getSpbh())){
            sbSql.append(" and spbh like '%"+spq.getSpbh()+"%'");
        }
        if (StringUtil.isNotEmpty(spq.getSpmc())){
            sbSql.append(" and spmc like '%"+spq.getSpmc()+"%'");
        }
        if (StringUtil.isNotEmpty(spq.getSpbz())){
            sbSql.append(" and spbz like '%"+spq.getSpbz()+"%'");
        }

        sbSql.append(" and spdj>="+spq.getSpdj_from().toString());
        sbSql.append(" and spdj<="+spq.getSpdj_to().toString());

        sbSql.append(" and spsl>="+spq.getSpsl_from().toString());
        sbSql.append(" and spsl<="+spq.getSpsl_to().toString());
        sbSql.append(" order by spbh;");//排序

        System.out.println(sbSql);

        PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());
        List<ShangPin> shangPins = new ArrayList<ShangPin>();
        ResultSet rs = pstmt.executeQuery();
        int i=0,j=0;//记录多少数据
        while (rs.next()) {
            if((pageNum-1)*pageSize<=i&&j<pageSize){
                j++;
                //只有
                ShangPin sp = new ShangPin();
                sp.setSpid(rs.getInt("id"));
                sp.setSpbh(rs.getString("spbh"));
                sp.setSpmc(rs.getString("spmc"));
                sp.setSpdj(rs.getFloat("spdj"));
                sp.setSpsl(rs.getInt("spsl"));
                sp.setSpbz(rs.getString("spbz"));
                shangPins.add(sp);
            }
            i++;


        }


        Page page = new Page(pageNum, pageSize, i, shangPins);

        return page;


    }
}
