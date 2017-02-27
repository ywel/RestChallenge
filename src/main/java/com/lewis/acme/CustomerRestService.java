/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lewis.acme;

/**
 *
 * @author adtel
 * 
 * customer Crud methods
 */
import com.api.models.Customer;
import com.api.models.CustomerFact;
import com.api.models.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.annotation.security.RolesAllowed;

@Path("/customer")
@Produces({MediaType.APPLICATION_JSON})
public class CustomerRestService {

    @GET
    @Path("ping")
    
    //check if service is up
    public String Ping() {
        System.out.println("Service Availabe ==> ping");
        return " on " + new Date().toString();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {

        String result = "Customer saved : " + customer;
        CustomerFact CF =new CustomerFact();
        int rn= CF.Number();
        customer.setCustomer_id("KLM"+rn);
        return Response.status(201).entity(customer).build();

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getInfo() {
        
        CustomerFact CF =new CustomerFact();
       int rn= CF.Number();

        Customer cust = new Customer();
        cust.setCustomer_name("Lewis");
        cust.setCusomer_limit(50000.00);
        cust.setCustomer_account_no("001123547889Z");
        cust.setCustomer_id("KLM"+rn);
        return cust;
    }

   

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCustomer(Customer customer) {

        String result = "Customer edited : " + customer;
        return Response.status(201).entity(customer).build();

    }

}
