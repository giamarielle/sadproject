
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle Lainez
 */
public class Scan_DB {
    
    public static void main(String[] args) throws SQLException {
        String search_id = null;
        String query = "SELECT patient_id,firstname,midname,lastname,address,age,gender FROM patients WHERE patient_id = '"+search_id+"'";
        String firstname,midname,lastname,address,gender;
        int age;
        
        try{
            Connection con = MyConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                firstname = rs.getString("firsname");
                midname = rs.getString("midnamee");
                lastname = rs.getString("lastname");
                address = rs.getString("address");
                age = rs.getInt("age");
                gender = rs.getString("gender");
            }
            
        }catch (Exception ex){
            System.out.println("Scan_DB Error: " + ex);
        }
    }
    
   
}
