/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

//import java.util.ArrayList;

public class UserRegistration {
    public String email, username, phNum, password, firstName, lastName,registrationDate;
    //private ArrayList<ApplicationInfo> applications = new ArrayList<ApplicationInfo>();

    
    public UserRegistration(String em, String user, String phNum, String pw, String fname, String lname,String registrationDate){
        
        this.email = em;
        this.username = user;
        this.phNum = phNum;
        this.password = pw;
        this.firstName = fname;
        this.lastName = lname;
        this.registrationDate=  registrationDate;
    }
    public UserRegistration(){
        
        this.email = "";
        this.username = "";
        this.phNum = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.registrationDate= "";
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUsername() {
        return username;
    }

    
    public String getPhNum() {
        return phNum;
    }
    public String getPassword() {
        return password;
    }
    
    public String getFirstname() {
        return firstName;
    }
    public String getHoldDate() {
        return registrationDate;
    }
    public String getLastname() {
        return lastName;
    }

//    public ArrayList<ApplicationInfo> getApplications() {
//        return applications;
//    }
//
//    public void setApplications(ArrayList<ApplicationInfo> applications) {
//        this.applications = applications;
//    }
//
//    public Object getScholarshipList() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}