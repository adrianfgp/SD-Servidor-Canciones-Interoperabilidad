/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.serverusers.core.repositories;

import common.entities.TokenDTO;
import common.utilities.Console;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author adrianfGP
 */
@Service
public class TokenRepository {
    private ArrayList<String> activeTokens = new ArrayList<String>();
    
    public String generateToken(){
        String token = Console.encoder();
        activeTokens.add(token);
        return  token;
    }
    
    public boolean validateToken(String token){
        for(String tokenAux: activeTokens){
            if(tokenAux.equals(token)){
                return true;
            }
        }
        return false;
    }
}
