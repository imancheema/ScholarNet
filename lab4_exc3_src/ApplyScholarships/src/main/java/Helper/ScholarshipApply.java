/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement(name = "book")
 @XmlAccessorType(XmlAccessType.FIELD)
public class ScholarshipApply {
    
    private String firstName, lastName, email, phoneNumber,school,syear,gender,applicationDate;
    private int age;
    private double GPA;
    public ScholarshipApply(String firstName, String lastName, String email, String phoneNumber,String school, int age, double GPA, String syear, String gender, String applicationDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.school = school;
        this.age = age;
        this.GPA = GPA;
        this.syear= syear;
        this.gender = gender;
        this.applicationDate = applicationDate;
    }
  
    public ScholarshipApply() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        this.school = "";
        this.age = 0 ;
        this.GPA = 0.0;
        this.syear= "";
        this.gender ="";
        this.applicationDate = "";
    }

    public String getfirstName() {
        return firstName;
    }

    public String getHoldDate() {
        return applicationDate;
    }

    public String getlastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getYear() {
        return syear;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNum() {
        return phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public String getSchool() {
        return school;
    }
    public double getGPA() {
        return GPA;
    }
    
}
