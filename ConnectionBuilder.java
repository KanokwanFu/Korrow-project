package Korrow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionBuilder {
    public static Connection ConnectionBuilder() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");//การโหลด driver MySQL ขึ้นมาทำงาน
        Connection con = DriverManager.getConnection("jdbc:mysql://35.166.222.133:3306/Project?zeroDateTimeBehavior=convertToNull","sitfreshy","123456789");//การเชื่อมต่อกับฐานข้อมูล
        return con;
    }
}
