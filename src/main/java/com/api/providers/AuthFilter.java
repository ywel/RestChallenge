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
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
 
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
 
import org.glassfish.jersey.internal.util.Base64;
 
/**
 * Here verify the access permissions for a user
 * based on username and password provided in request
 * */
@Provider
public class AuthFilter implements javax.ws.rs.container.ContainerRequestFilter
{
     
    @Context
    private ResourceInfo resourceInfo;
     
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
                                                        .entity("Acess Denied ").build();
    private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
                                                        .entity("UnAuthorised").build();
      
    @Override
    public void filter(ContainerRequestContext requestContext)
    {
        Method method = resourceInfo.getResourceMethod();
        //Access allowed for all
        if( ! method.isAnnotationPresent(PermitAll.class))
        {
            //Access denied for all
            if(method.isAnnotationPresent(DenyAll.class))
            {
                requestContext.abortWith(ACCESS_FORBIDDEN);
                return;
            }
              
           
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
              
            
            final List<String> auth = headers.get(AUTHORIZATION_PROPERTY);
              
           
            if(auth == null || auth.isEmpty())
            {
                requestContext.abortWith(ACCESS_DENIED);
                return;
            }
              
            
            final String Provided_Password = auth.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
              
            //Decode suppliebd basic credentials
            String basic_credentials = new String(Base64.decode(Provided_Password.getBytes()));;
  
            //Seperate username and password tokens
            final StringTokenizer tokenizer = new StringTokenizer(basic_credentials, ":");
            final String username = tokenizer.nextToken();
            final String password = tokenizer.nextToken();
              
            //Verifying Username and password
            System.out.println(username);
            System.out.println(password);
              
            //Verify user access
            if(method.isAnnotationPresent(RolesAllowed.class))
            {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
                  
                
                if( ! isUserAllowed(username, password, rolesSet))
                {
                    requestContext.abortWith(ACCESS_DENIED);
                    return;
                }
            }
        }
    }
    private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet)
    {
        boolean isAllowed = false;
          
        //DB impl
         
        if(username.equals("lewis") && password.equals("1234"))
        {
            String userRole = "ADMIN";
             
            
            if(rolesSet.contains(userRole))
            {
                isAllowed = true;
            }
        }
        return isAllowed;
    }
}