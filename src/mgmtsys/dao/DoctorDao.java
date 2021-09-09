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
import mgmtsys.po.Doctor;

/**
 *
 * @author HP
 */
public class DoctorDao {
    
    public static boolean addDoctor(Doctor d)  throws SQLException
    {
        String firstname  = d.getFirstname();
        String lastname = d.getLastname();
        String speciality = d.getSpeciality();
        String dob = d.getDob();
        String contact = d.getContact();
        String gender = d.getGender();
        String emailid = d.getEmailid();
        String permanentaddress = d.getPermanentaddress();
        String presentaddress = d.getPresentaddress();
        
        Connection con = DatabaseConnection.getConnection();
        String sql = "insert into doctor (firstname, lastname, speciality, dob, contact, gender, emailid, permanentaddress, presentaddress) values ('"+firstname+"','"+lastname+"','"+speciality+"','"+dob+"','"+contact+"','"+gender+"','"+emailid+"','"+permanentaddress+"','"+presentaddress+"') ";
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
    
    public static ResultSet viewData() throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from doctor";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs =  ps.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet Display(Doctor d) throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = " select * from doctor where id = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,d.getId());
        
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    
    public static boolean updateDoctor(Doctor d) throws SQLException
    {
        String id = d.getId();
        String firstname  = d.getFirstname();
        String lastname = d.getLastname();
        String speciality = d.getSpeciality();
        String dob = d.getDob();
        String contact = d.getContact();
        String gender = d.getGender();
        String emailid = d.getEmailid();
        String permanentaddress = d.getPermanentaddress();
        String presentaddress = d.getPresentaddress();
        
        Connection con = DatabaseConnection.getConnection();
        String sql = " update doctor set firstname = '"+firstname+"', lastname = '"+lastname+"', speciality = '"+speciality+"', dob = '"+dob+"', contact = '"+contact+"', gender = '"+gender+"', emailid = '"+emailid+"', permanentaddress = '"+permanentaddress+"', presentaddress = '"+presentaddress+"' where id = "+id+" ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        int iRet = ps.executeUpdate(sql);
        return iRet == 1;
    }
    
    public static boolean deleteDoctor(Doctor d) throws SQLException
    {
        String id = d.getId();
        Connection con = DatabaseConnection.getConnection();
        String sql = " delete from doctor where id = "+id+" ";
        PreparedStatement ps = con.prepareStatement(sql);
        //ps.setString(1,d.getId());
        
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
    
    public static ResultSet searchDoctor(Doctor d) throws SQLException
    {
        String search = d.getSearch();
        Connection con = DatabaseConnection.getConnection();
        if(search.matches("^[0-9]"))
        {
            String sql = " select * from doctor where id = "+search+" ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }
        else
        {
            String sql = " select * from doctor where id like '%"+search+"%' or firstname like '%"+search+"%' or lastname like '%"+search+"%' or speciality like '%"+search+"%' or dob like '%"+search+"%' or contact like '%"+search+"%'  or gender like '%"+search+"%' or emailid like '%"+search+"%' or permanentaddress like '%"+search+"%' or presentaddress like '%"+search+"%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }
    }
    
    public static void deleteAll() throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = " truncate table doctor ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }
}
