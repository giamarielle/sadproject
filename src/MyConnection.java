
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
     public static Connection getConnection(){
     
        Connection con = null;
        try {
<<<<<<< HEAD
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad_db","root","mypass");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/QMS","konsulta","resulta");
            
=======
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad_db","root","mypass");

>>>>>>> bfd6b46fb52898d28aed9ee5ba6873b1063f9e8f
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
