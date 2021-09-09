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
import javax.swing.JOptionPane;
import mgmtsys.dbutil.DatabaseConnection;
import mgmtsys.po.Appointment;

/**
 *
 * @author HP
 */
public class AppointmentDao {
    
    public static boolean addAppointment(Appointment a) throws SQLException
    {
        String pfirstname = a.getPfirstname();
        String plastname = a.getPlastname();
        String dateofapp = a.getDateofapp();
        String timeofapp = a.getTimeofapp();
        String pcontact = a.getPcontact();
        String pgender = a.getPgender();
        String doctorname = a.getDoctorname();
        String dcontact = a.getDcontact();
        
        Connection con = DatabaseConnection.getConnection();
        
        String sql1 = "select * from appointment where dateofapp = '"+dateofapp+"' && timeofapp = '"+timeofapp+"' && doctorname = '"+doctorname+"' ";
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ResultSet rs = ps1.executeQuery();
        if(rs.next() == true)
        {
            return false;
        }
        else
        {
            String sql2 = "insert into appointment (pfirstname, plastname, dateofapp, timeofapp, pcontact, pgender, doctorname, dcontact) values ('"+pfirstname+"','"+plastname+"','"+dateofapp+"','"+timeofapp+"','"+pcontact+"','"+pgender+"','"+doctorname+"','"+dcontact+"') ";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            int iRet2 = ps2.executeUpdate(sql2);
            if(iRet2 == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    
    public static ResultSet Display(Appointment a) throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = " select * from appointment where id = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,a.getId());
        
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    
    public static boolean updateAppointment(Appointment a)  throws SQLException 
    {
        String id = a.getId();
        String pfirstname = a.getPfirstname();
        String plastname = a.getPlastname();
        String dateofapp = a.getDateofapp();
        String timeofapp = a.getTimeofapp();
        String pcontact = a.getPcontact();
        String pgender = a.getPgender();
        String doctorname = a.getDoctorname();
        String dcontact = a.getDcontact();
        
        Connection con = DatabaseConnection.getConnection();
        String sql = " update appointment set pfirstname = '"+pfirstname+"', plastname = '"+plastname+"', dateofapp = '"+dateofapp+"', timeofapp = '"+timeofapp+"', pcontact = '"+pcontact+"', pgender = '"+pgender+"', doctorname = '"+doctorname+"', dcontact = '"+dcontact+"' where id = "+id+" ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        int iRet = ps.executeUpdate(sql);
        return iRet == 1;
    }
    
    public static ResultSet viewData() throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from Appointment";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs =  ps.executeQuery(sql);
        return rs;
    }
    
    public static boolean deleteAppointment(Appointment a) throws SQLException
    {
        String id = a.getId();
        Connection con = DatabaseConnection.getConnection();
        String sql = " delete from appointment where id = "+id+" ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        int iRet = ps.executeUpdate(sql);
        
        if(iRet == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static ResultSet searchAppointment(Appointment a) throws SQLException
    {
        String search = a.getSearch();
        Connection con = DatabaseConnection.getConnection();
        if(search.matches("^[0-9]"))
        {
            String sql = " select * from appointment where id = "+search+" ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }
        else
        {
            String sql = " select * from appointment where id like '%"+search+"%' or pfirstname like '%"+search+"%' or plastname like '%"+search+"%' or dateofapp like '%"+search+"%' or timeofapp like '%"+search+"%' or pcontact like '%"+search+"%'  or pgender like '%"+search+"%' or doctorname like '%"+search+"%' or dcontact like '%"+search+"%' ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }
    }
    
    public static void deleteAll() throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = " truncate table appointment";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }
}
