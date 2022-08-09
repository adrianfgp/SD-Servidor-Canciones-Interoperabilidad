/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.serverusers.core.models;

import java.util.Base64;

/**
 *
 * @author adrianfGP
 */
public class TokenDTO {
    private String value;
    
    public TokenDTO() {
        int i = 100; // longitud
        String theAlphaNumericS;
        StringBuilder builder;
        
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; 

        //create the StringBuffer
        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) { 
            // generate numeric
            int myindex = (int)(theAlphaNumericS.length()* Math.random()); 

            // add the characters
            builder.append(theAlphaNumericS.charAt(myindex)); 
        }  
        String tokenrandomichars = builder.toString();
        
        //Convertir en base64 y guardar en value        
        this.value =  Base64.getEncoder().encodeToString(tokenrandomichars.getBytes()); 
    }

    public String getValue() {
        return value;
    }
        
}
