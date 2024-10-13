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
import Helper.ScholarshipApply;


public class Apply_CRUD {
    private static Connection getCon(){
    Connection con=null;
     try{
         
         Class.forName("com.mysql.cj.jdbc.Driver");
        //con=DriverManager.getConnection("jdbc:mysql://db:3306/hold_LBS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
       
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/APPLY_SMS?autoReconnect=true&useSSL=false", "root", "student");
        System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
    
    
    
    public static boolean addHold(String firstName, String lastName, String email, String phoneNumber,String school, int age, double GPA, String syear, String gender){
      
        try{
            Connection con= getCon();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now();
            String q = "insert into SCHOLARSHIP_APPLY"
                    + "(firstName, lastName, email, phoneNumber,school,age,GPA,syear,gender,applicationDate) values "
                    + "('"+firstName+"', "
                    +"'"+lastName+"', "
                    + "'"+email+"', "
                    + "'"+phoneNumber+"', "
                    + "'"+school+"', "
                    + ""+age+", "
                    + ""+GPA+", "
                    +"'"+syear+"', "
                    + "'"+gender+"', "
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
    public static ScholarshipApply getHoldBook(String isbn){
        ScholarshipApply book=null;
        try{
            Connection con= getCon();
            
            String q = "select * FROM SCHOLARSHIP_APPLY WHERE isbn =" +'"' + isbn + '"'+ ";";
            System.out.println(q);

            PreparedStatement ps=con.prepareStatement(q);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){

                String date=rs.getDate("applicationdate").toString();
                String firstName=rs.getString("firstName").toString();
                String lastName =rs.getString("lastName").toString();
                String email=rs.getString("email").toString();
                String phoneNumber =rs.getString("phoneNumber").toString();
                String school=rs.getString("school").toString();
                int age = rs.getInt("age");
                double GPA = rs.getDouble("GPA");
                String syear =rs.getString("syear").toString();
                String gender=rs.getString("age").toString();

                book = new ScholarshipApply(firstName, lastName, email, phoneNumber,school,age,GPA,syear,gender,date);

                }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return book;
        
    }

    public static boolean addHold(String firstName, String lastName, String email, String phoneNumber,String school, int age, double GPA, String syear, String gender, String applicationDate) {
      return( addHold(firstName, lastName, email, phoneNumber,school,age,GPA,syear,gender));
    }
}
