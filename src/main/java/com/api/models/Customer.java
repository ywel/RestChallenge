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
public class Customer {
    
    String customer_name;
    String customer_account_no;
    String customer_id;
    double cusomer_limit;
    
    public Customer(){
    
    }
    

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_account_no() {
        return customer_account_no;
    }

    public void setCustomer_account_no(String customer_account_no) {
        this.customer_account_no = customer_account_no;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public double getCusomer_limit() {
        return cusomer_limit;
    }

    public void setCusomer_limit(double cusomer_limit) {
        this.cusomer_limit = cusomer_limit;
    }
    
    
    
}
