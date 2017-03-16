package Korrow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//    private HashMap<char,String> userType;

public class User {
    private String userId;
    private String password;
    private String userName;
    private String position;
    private ArrayList<String> email = new ArrayList<String>();
    private ArrayList<String> tel = new ArrayList<String>();
    private String userTypeId;

    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getPosition() {
        return position;
    }
    public ArrayList<String> getEmail() {
        return email;
    }
    public ArrayList<String> getTel() {
        return tel;
    }
    public String getPassword() {
        return password;
    }
    public String getUserTypeId() {
        return userTypeId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }
    public void setTel(ArrayList<String> tel) {
        this.tel = tel;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public static void getData(ResultSet rs, User u) throws SQLException {
        u.setUserId(rs.getString("user_id"));
        u.setUserId(rs.getString("user_name"));
        u.setUserName(rs.getString("user_password"));
        u.setPosition(rs.getString("user_id"));
        u.setEmail((ArrayList<String>) rs.getString("email"));
        u.setTel((ArrayList<String>) rs.getString("tel"));
    }

    public User() {

    }
    public User(String userId, String password, String userName, String position, ArrayList<String> email, ArrayList<String> tel, String userTypeId) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.userTypeId = userTypeId;
    }

    
        public void insertUser() throws ClassNotFoundException, SQLException {
        System.out.println("insert " + userId + " finish!");
        Connection con = null;
        try {
            String strMail = "";
            for(int i=0;i<email.size();i++){
                strMail += email.get(i);
                strMail += ",";
            }
            String strTel = "";
            for(int i=0;i<tel.size();i++){
                strTel += tel.get(i);
                strTel += ",";
            }
            String sql = "INSERT into User (user_id,user_password,user_name,user_position,user_email,user_tel,user_type) values (?,?,?,?,?,?,?)";
            con = ConnectionBuilder.ConnectionBuilder();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, password);
            statement.setString(3, userName);
            statement.setString(4, position);
            statement.setString(5, strMail);
            statement.setString(6, strTel);
            statement.setString(7, userTypeId);
            statement.execute();//ประมวลผลข้อมูล
            statement.close();//หยุดการประมวลผล
//            FrameInsert insert = new FrameInsert();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());//ใช้แสดงความผิดปกติเป็นString
        } finally {
            con.close();
        }
    }

    public void updateUser() throws SQLException {
        System.out.println("userId " + userId + "update finish!");
        Connection con = null;
        try {
            String strMail = "";
            for(int i=0;i<email.size();i++){
                strMail += email.get(i);
                strMail += ",";
            }
            String strTel = "";
            for(int i=0;i<tel.size();i++){
                strTel += tel.get(i);
                strTel += ",";
            }
            
            String sql = "update User set";
            sql += " user_password=?,";
            sql += " user_name=?,";
            sql += " user_position=?,";
            sql += " user_email=?,";
            sql += " user_tel=?,";
            sql += " user_type=?";
            sql += " WHERE user_id=?";
            con = ConnectionBuilder.ConnectionBuilder();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, userName);
            statement.setString(3, position);
            statement.setString(4, strMail);
            statement.setString(5, strTel);
            statement.setString(6, userTypeId);
            statement.setString(7, userId);
            
            statement.execute();//ประมวลผลข้อมูล
            statement.close();//หยุดการประมวลผล
//            FrameUpdate update = new FrameUpdate();
            
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());//ใช้แสดงความผิดปกติเป็นString
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            con.close();
        }
    }

    public void deleteUserById(String userId) throws SQLException {
        Connection con = null;
        try {
            String sql = "delete from User where user_id=?";
            con = ConnectionBuilder.ConnectionBuilder();
            PreparedStatement statement = con.prepareStatement(sql);//เป็นการเตรียมคำสั่งsqlสำหรับเรียกดูข้อมูลในตาราง
            statement.setString(1, userId);
            statement.execute();//ประมวลผลข้อมูล
            statement.close();//หยุดการประมวลผล
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
             con.close();
        }
    }
}
