
import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
     public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/QMS","konsulta","resulta");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}
