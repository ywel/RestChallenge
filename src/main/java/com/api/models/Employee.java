/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.models;

/**
 *
 * @author adtel
 */

//import org.codehaus.jackson.annotate.JsonProperty;

public class Employee {
    
    String Employee_id;
    
    String Emplyee_name;
   
    String Employee_level;
    
    double Employee_salary;

    
    
    public Employee(){
    
    }
    
     
    
    public Employee(String id,String Name, String Level,double salary){
         
         this.Employee_id=id;
         this.Employee_level=Level;
         this.Employee_salary=salary;
         this.Emplyee_name=Name;
    }
    
    
    public String getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(String Employee_id) {
        this.Employee_id = Employee_id;
    }

    public String getEmplyee_name() {
        return Emplyee_name;
    }

    public void setEmplyee_name(String Emplyee_name) {
        this.Emplyee_name = Emplyee_name;
    }

    public String getEmployee_level() {
        return Employee_level;
    }

    public void setEmployee_level(String Employee_level) {
        this.Employee_level = Employee_level;
    }

    public double getEmployee_salary() {
        return Employee_salary;
    }

    public void setEmployee_salary(double Employee_salary) {
        this.Employee_salary = Employee_salary;
    }
    
    
    
     
     
    
    
}
