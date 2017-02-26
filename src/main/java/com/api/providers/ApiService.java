/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.providers;

/**
 *
 * @author adtel
 */
 
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
 

 
public class ApiService extends ResourceConfig 
{
    public ApiService() 
    {
        packages("com.howtodoinjava.jersey");
        register(LoggingFilter.class);
        
 
        // AuthFilter here
        register(AuthFilter.class);
    }
}

