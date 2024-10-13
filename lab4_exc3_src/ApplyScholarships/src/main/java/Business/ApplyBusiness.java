/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;



import Helper.ScholarshipApply;
import Persistence.Apply_CRUD;

/**
 *
 * @author student
 */
public class ApplyBusiness {

    public ScholarshipApply getApplications(String isbn) {
        ScholarshipApply bs = Apply_CRUD.getHoldBook(isbn);

        return (bs);
    }

public boolean apply(String firstName, String lastName, String email, String phoneNumber,String school, int age, double GPA, String syear, String gender){
        return (Apply_CRUD.addHold(firstName, lastName, email, phoneNumber,school,age,GPA,syear,gender));
    }
    
}
