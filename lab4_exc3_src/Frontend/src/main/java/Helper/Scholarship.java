/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
    @XmlRootElement(name = "scholarship")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scholarship {

 @XmlTransient
    private boolean tobeApplied;

    public boolean isTobeApplied() {
        return tobeApplied;
    }

    public void setTobeApplied(boolean tobeApplied) {
        this.tobeApplied = tobeApplied;
    }
   
    private String scholarshipName, description, requirement;
    Date deadline;
    double grantValue;
    boolean available;
    
    public Scholarship(){
        
    }
    public Scholarship(String name, String requirements, String description, double value, Date deadline) {
    this.scholarshipName = name;
    this.requirement = requirements;
    this.description = description;
    this.grantValue = value;
    this.deadline = deadline;
    this.available = true;
}

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return scholarshipName;
    }

    public void setName(String name) {
        this.scholarshipName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirement;
    }

    public void setRequirements(String requirements) {
        this.requirement = requirements;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date date) {
        this.deadline = date;
    }

    public double getValue() {
        return grantValue;
    }

    public void setValue(double value) {
        this.grantValue = value;
    }
}
    
