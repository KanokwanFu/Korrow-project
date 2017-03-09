package korrow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
   public static void Login (String id,String password){
        try{
            String sql ="select * From Users where user_id=? and user_password =?";
            Connection con=(Connection) Connection.connectionBuilder();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,password);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("Login Success");
            }else{
                System.out.println("Incorrect ID or Password");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

        
}
