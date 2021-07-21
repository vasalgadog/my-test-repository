
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vasal
 */
public class UConnection {
    private static Connection con = null;
        
    public static Connection getConnection(){
        if(con==null){
            String usr = "curso";
            String pwd = "1234";
            
            String driver = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            
            try{
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }catch(ClassNotFoundException ex){
                    ex.printStackTrace();
            }catch(SQLException ex){
                    ex.printStackTrace();
            }
        }
        return con;
    }
}
