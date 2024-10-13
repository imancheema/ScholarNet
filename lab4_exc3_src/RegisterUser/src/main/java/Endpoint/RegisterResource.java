/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Endpoint;

import java.io.StringWriter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import Business.RegisterBusiness;
import Helper.UserRegistration;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("register")
public class RegisterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public RegisterResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ryerson.ca.searchbook.endpoint.SearchResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("isOnHold/{firstName}")
    public String getXml(@PathParam("firstName") String isbn) {
        System.out.println(isbn);
        RegisterBusiness a = new RegisterBusiness();
        UserRegistration s = a.getApplications(isbn);
        if (s == null) {
            return("");
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(UserRegistration.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(s, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(RegisterResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String  updateBookHold(@FormParam("emailAddress") String emailAddress, @FormParam("username") String username, @FormParam("phoneNumber") String phoneNumber, @FormParam("password") String password, @FormParam("firstName") String firstName,@FormParam("lastName") String lastName) 
    {
          RegisterBusiness a = new RegisterBusiness();
          boolean bs=a.register(emailAddress, username, phoneNumber, password, firstName, lastName);
          if(bs)
              return("Inserted");
          else
              return("Not inserted");
          
    }
}

