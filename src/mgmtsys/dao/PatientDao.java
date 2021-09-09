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
import mgmtsys.po.Patient;

/**
 *
 * @author HP
 */
public class PatientDao {
    public static boolean addPatient(Patient p)  throws SQLException
    {
        String firstname = p.getFirstname();
        String lastname = p.getLastname();
        String disease = p.getDisease();
        String dob = p.getDob();
        String gender = p.getGender();
        String weight = p.getWeight();
        String bloodgroup = p.getBloodgroup();
        String contact = p.getContact();
        String permanentaddress = p.getPermanentaddress();
        String presentaddress = p.getPresentaddress();
        
        Connection con = DatabaseConnection.getConnection();
        String sql = "insert into patient (firstname, lastname, disease, dob, gender, weight, bloodgroup, contact, permanentaddress, presentaddress) values ('"+firstname+"','"+lastname+"','"+disease+"','"+dob+"','"+gender+"','"+weight+"','"+bloodgroup+"','"+contact+"','"+permanentaddress+"','"+presentaddress+"') ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        int iRet = ps.executeUpdate(sql);
         
         return true;
    }
    
    public static ResultSet Display(Patient p) throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = " select * from patient where id = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,p.getId());
        
        ResultSet rs = ps.executeQuery();
        
        return rs;
    }
    
    public static boolean updatePatient(Patient p) throws SQLException
    {
        String id = p.getId();
        String firstname  = p.getFirstname();
        String lastname = p.getLastname();
        String disease = p.getDisease();
        String dob = p.getDob();
        String gender = p.getGender();
        String weight = p.getWeight();
        String bloodgroup = p.getBloodgroup();
        String contact = p.getContact();
        String permanentaddress = p.getPermanentaddress();
        String presentaddress = p.getPresentaddress();
        
        Connection con = DatabaseConnection.getConnection();
        String sql = " update patient set firstname = '"+firstname+"', lastname = '"+lastname+"', disease = '"+disease+"', dob = '"+dob+"', gender = '"+gender+"', weight = '"+weight+"', bloodgroup = '"+bloodgroup+"', contact = '"+contact+"', permanentaddress = '"+permanentaddress+"', presentaddress = '"+presentaddress+"' where id = "+id+" ";
        PreparedStatement ps = con.prepareStatement(sql);
        
        int iRet = ps.executeUpdate(sql);
        return iRet == 1;
    }
    
    public static ResultSet viewData() throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from patient";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs =  ps.executeQuery(sql);
        return rs;
    }
    
    public static boolean deletePatient(Patient p) throws SQLException
    {
        String id = p.getId();
        Connection con = DatabaseConnection.getConnection();
        String sql = " delete from patient where id = "+id+" ";
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
    
    public static ResultSet searchPatient(Patient p) throws SQLException
    {
        String search = p.getSearch();
        Connection con = DatabaseConnection.getConnection();
        if(search.matches("^[0-9]"))
        {
            String sql = " select * from patient where id = "+search+" ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }
        else
        {
            String sql = " select * from patient where id like '%"+search+"%' or firstname like '%"+search+"%' or lastname like '%"+search+"%' or disease like '%"+search+"%' or dob like '%"+search+"%' or gender like '%"+search+"%'  or weight like '%"+search+"%' or bloodgroup like '%"+search+"%' or contact like '%"+search+"%' or permanentaddress like '%"+search+"%' or presentaddress like '%"+search+"%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }
    }
    
    public static void deleteAll() throws SQLException
    {
        Connection con = DatabaseConnection.getConnection();
        String sql = " truncate table patient";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }
}
