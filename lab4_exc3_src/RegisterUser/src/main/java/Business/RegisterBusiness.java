/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Helper.UserRegistration;
import Persistence.Register_CRUD;

/**
 *
 * @author student
 */
public class RegisterBusiness {

   



    public UserRegistration getApplications(String isbn) {
        UserRegistration bs = Register_CRUD.getHoldBook(isbn);

        return (bs);
    }

public boolean register(String emailAddress, String username, String phoneNumber, String password, String firstName, String lastName){
        return (Register_CRUD.addUser(emailAddress, username, phoneNumber, password, firstName, lastName));
    }

    
}
