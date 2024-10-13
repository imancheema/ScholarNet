/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import Helper.UserRegistration;


public class Register_CRUD {
    private static Connection getCon(){
    Connection con=null;
     try{
         
         Class.forName("com.mysql.cj.jdbc.Driver");
        //con=DriverManager.getConnection("jdbc:mysql://db:3306/hold_LBS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
       
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/REGISTER_SMS?autoReconnect=true&useSSL=false", "root", "student");
        System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
    
    
    
    public static boolean addUser(String emailAddress, String username, String phoneNumber, String password, String firstName, String lastName){
      
        try{
            Connection con= getCon();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now();
            String q = "insert into REGISTER_USER"
                    + "(emailAddress, username, phoneNumber, password, firstName, lastName,registrationDate) values "
                    + "('"+emailAddress+"', "
                    + "'"+username+"', "
                    + "'"+phoneNumber+"', "
                    + "'"+password+"', "
                    +"'"+firstName+"', "
                    +"'"+lastName+"', "
                    +"'"+date.format(formatter)+"');";
                    
            Statement stmt = con.createStatement();   
            System.out.println(q);
            stmt.execute(q);
			con.close();
                        return true;

		}catch(Exception e){System.out.println(e);
                return false;
                }
 
        
    }
    public static UserRegistration getHoldBook(String isbn){
        UserRegistration book=null;
        try{
            Connection con= getCon();
            
            String q = "select * FROM REGISTER_USER WHERE isbn =" +'"' + isbn + '"'+ ";";
            System.out.println(q);

            PreparedStatement ps=con.prepareStatement(q);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){

                String date=rs.getDate("registrationdate").toString();
                String firstName=rs.getString("firstName").toString();
                String lastName =rs.getString("lastName").toString();
                String emailAddress=rs.getString("emailAddress").toString();
                String phoneNumber =rs.getString("phoneNumber").toString();
                String password =rs.getString("password").toString();
                String username=rs.getString("username").toString();

                book = new UserRegistration(emailAddress, username, phoneNumber, password, firstName, lastName,date);

                }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return book;
        
    }

    public static boolean addUser(String emailAddress, String username, String phoneNumber, String password, String firstName, String lastName,String registrationDate) {
      return( addUser(emailAddress, username, phoneNumber, password, firstName, lastName));
    }
}
