/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import Helper.*;

/**
 *
 * @author student
 */
public class Business {

    public static boolean isAuthenticated(String username, String password) throws IOException {
        Messaging.sendMessage(username + " " + password);
        if (username.equals("eraj") || username.equals("iman") || username.equals("ironman")) {
            return true;
        } else {
            return false;
        }
    }

    public static ScholarshipXML getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        String applyService = System.getenv("applyService");
        String registerService = System.getenv("registerService");
        WebTarget searchwebTarget
                = searchclient.target("http://"+applyService+"/ApplyScholarships/webresources/apply");
//                = searchclient.target("http://localhost:8080/ApplyScholarships/webresources/apply");
        InputStream is
                = searchwebTarget.path("update").request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        ScholarshipXML books = bookxmltoObjects(xml);
        if (token != null) {
            Client holdclient = ClientBuilder.newClient();
            WebTarget holdwebTarget
                    = holdclient.target("http://"+registerService+"/RegisterUser/webresources/register/update");
//                    = holdclient.target("http://localhost:8080/RegisterUser/webresources/register/update");
            for (Scholarship book : books.getScholarships()) {

                InputStream holddata
                        = holdwebTarget.path(book.getName()).queryParam("token", token).
                                request(MediaType.APPLICATION_XML).get(InputStream.class);
                try{
                    Scholarship a=bookholdxmltoObjects(IOUtils.toString(holddata, "utf-8"));
                    if(a!=null)
                        book.setTobeApplied(true);
                    else
                        book.setTobeApplied(false);
                }
                catch(Exception e){
                    book.setTobeApplied(false);
                }
            
            }
        }

        return (books);

    }

    private static ScholarshipXML bookxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ScholarshipXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ScholarshipXML books = (ScholarshipXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return books;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Scholarship bookholdxmltoObjects(String xml) {
        if(xml.isEmpty())
            return null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Scholarship.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Scholarship book = (Scholarship) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return book;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
