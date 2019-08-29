
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
     public static Connection getConnection(){
     
        Connection con = null;
        try {
<<<<<<< HEAD
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad_db","root","mypass");
=======
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/QMS","konsulta","resulta");
>>>>>>> 7d17aab6d5704f23d66a2a16181ee6f8ceed01c2
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
