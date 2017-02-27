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

import java.util.Random;


public class CustomerFact {
    
    
    public CustomerFact(){
    }
    
    
    public int Number(){
        
        Random rand = new Random();

int  n = rand.nextInt(10001) + 1;

return n;
    
    }
    
}
