/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
 @XmlRootElement(name = "scholarships")
@XmlAccessorType (XmlAccessType.FIELD)
       public class ScholarshipXML{
     @XmlElement(name="scholarship")
           private ArrayList<Scholarship> scholarships;
           
           public List<Scholarship>getScholarships(){
               return scholarships;
               
           }
           ScholarshipXML(){
               
               
           }
           public void setScholarship(ArrayList<Scholarship> bs){
                scholarships=bs;
               
           }
           
       }
  



















