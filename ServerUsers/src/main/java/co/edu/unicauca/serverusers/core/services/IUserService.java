/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.serverusers.core.services;

import co.edu.unicauca.serverusers.core.models.TokenDTO;
import co.edu.unicauca.serverusers.core.models.UserDTO;

/**
 *
 * @author adrianfGP
 */
public interface IUserService {
    public boolean userIsRegistred(String username);
    public boolean validateCredentials(String username, String password);
    public boolean registerUser(UserDTO user);
    public TokenDTO generateToken();
    public boolean validateToken(TokenDTO token);
}
