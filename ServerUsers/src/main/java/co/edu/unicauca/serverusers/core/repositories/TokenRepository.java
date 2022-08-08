/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.serverusers.core.repositories;

import co.edu.unicauca.serverusers.core.models.TokenDTO;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author adrianfGP
 */
@Service
public class TokenRepository {
    private ArrayList<TokenDTO> activeTokens = new ArrayList<TokenDTO>();
    
    public TokenDTO generateToken(){
        TokenDTO token = new TokenDTO();
        activeTokens.add(token);
        return  token;
    }
    
    public boolean validateToken(TokenDTO token){
        for(TokenDTO tokenAux: activeTokens){
            
        }
        return false;
    }
}
