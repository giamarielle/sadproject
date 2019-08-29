
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle Lainez
 */
public class Get_Queue {
    public String service;
    public String firstname,midname,lastname,address,gender;
    
    public void setService(String service){
        this.service = service;
    }
    
    public void Get_Queue(String service_input) throws SQLException {
        String query;
        query = "SELECT * FROM queue WHERE service = '"+service+"'";
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
