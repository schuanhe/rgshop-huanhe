package com.rgshop.dao;

import com.rgshop.model.ShangPin;
import com.rgshop.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public User Login(Connection conn, User user) throws Exception {
        StringBuffer sbSql = new StringBuffer("select * from tb_user where name=? and password=?;");
        PreparedStatement pstmt = conn.prepareStatement(sbSql.toString());

        pstmt.setString(1, user.getName());
        pstmt.setString(2,user.getPassword());
        ResultSet rs = pstmt.executeQuery();

        User user1 = null;
        while (rs.next()) {
            user1 = new User();
            user1.setUserid(rs.getInt("id"));
            user1.setName(rs.getString("name"));
            user1.setPassword(rs.getString("password"));
            user1.setQq(rs.getString("qq"));
        }

        return user1;
    }
}
