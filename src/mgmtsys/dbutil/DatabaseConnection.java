/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmtsys.dbutil;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DatabaseConnection {
    
    private static Connection con; // creating connection object
    
    static  // we take static block because it will execute before main method.
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); // to register driver class
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mgmtsysdb","root",""); // to establish connection with database.
            JOptionPane.showMessageDialog(null,"Connection Established Successfully.....","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException E)
        {
            JOptionPane.showMessageDialog(null,"Error Loading Driver","Error",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Cnnection not Established Please Check Code","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Connection getConnection()
    {
        return con; // it will return connection object if connection is established.
    }
    
    public static void closeConnection()
    {
        try
        {
            if(con != null) // i.e connection is established successfully.
            {
                con.close();
            }
        }
        catch(SQLException E) // connection is not established.
        {
            JOptionPane.showMessageDialog(null,"Check Database Connection Class","Error",JOptionPane.ERROR);
        }
    }
}
