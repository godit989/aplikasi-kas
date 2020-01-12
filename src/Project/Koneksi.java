
package Project;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class Koneksi {
    
    private static Connection mysqlconfig;
    
    public static Connection configDb() throws SQLException {
        try{
            String url = "jdbc:mysql://localhost:3306/project_netbeans";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url,user,pass);
        } catch(Exception e){
            System.err.println("koneksi gagal" + e.getMessage());
        }
    return mysqlconfig;
    }
       
}
