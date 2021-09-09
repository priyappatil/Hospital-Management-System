/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmtsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mgmtsys.dbutil.DatabaseConnection;
import mgmtsys.po.User;

/**
 *
 * @author HP
 */
public class Userdao {
    
    public static String validateUser(User u) throws SQLException
    {
        Connection con = DatabaseConnection.getConnection(); // return con from DatabaseConnection.java
        PreparedStatement ps = con.prepareStatement("select adminname from admin where adminname = ? and password = ? ");
        ps.setString(1,u.getAdminname());
        ps.setString(2,u.getPassword());
        
        ResultSet rs = ps.executeQuery();
        
        String loginid = null;
        if(rs.next())
        {
            loginid = rs.getString(1);
        }
        return loginid;
    }
}
