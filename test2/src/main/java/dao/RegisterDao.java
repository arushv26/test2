package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bean.RegisterBean;
import util.DBConnection;
 
public class RegisterDao { 
     public String registeruser(RegisterBean registerBean)
     {
         String fname = registerBean.getfname();
         String username = registerBean.getusername();
         String password = registerBean.getpassword();
         
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into users(SLNo,fullname,username,password) values (NULL,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, fname);
             //preparedStatement.setString(2, email);
             preparedStatement.setString(2, username);
             preparedStatement.setString(3, password);
             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
}