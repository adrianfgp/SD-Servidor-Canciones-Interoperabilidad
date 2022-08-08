/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.serverusers.core.repositories;

import co.edu.unicauca.serverusers.core.models.UserDTO;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author adrianfGP
 */
@Service
public class UserRepository {
    private ArrayList<UserDTO> registeredUsers = new ArrayList<UserDTO>();
    
    public boolean userIsRegistred(String username){
        for(UserDTO userAux: registeredUsers){
            if(username.toUpperCase().equals(userAux.getName().toUpperCase())){
                return true;
            }
        }
        return false;
    }
    
    public boolean validateCredentials(String username, String password){
        for(UserDTO userAux: registeredUsers){
            if((username.toUpperCase().equals(userAux.getName().toUpperCase()))&&(password.equals(userAux.getPassword()))){
                return true;
            }
        }    
        return false;
    }
    
    public boolean registerUser(UserDTO user){
        this.registeredUsers.add(user);
        return false;
    }
    
    
}
