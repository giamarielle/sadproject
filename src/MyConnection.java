
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
            
>>>>>>> 500e86618ebfa25294e8b5ff3d9adef61511f454
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
