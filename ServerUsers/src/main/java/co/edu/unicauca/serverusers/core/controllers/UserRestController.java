/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.serverusers.core.controllers;

import co.edu.unicauca.serverusers.core.models.TokenDTO;
import co.edu.unicauca.serverusers.core.models.UserDTO;
import co.edu.unicauca.serverusers.core.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adrianfGP
 */
@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("/clientes")
    public boolean registerUser(@RequestBody UserDTO user) {
        boolean respuesta = false;
        if(!this.userService.userIsRegistred(user.getName())){
            this.userService.registerUser(user);
            respuesta = true;
        }
        return respuesta;
    }
    
   @GetMapping("clientes/{name}/{password}") 
    public TokenDTO login(@PathVariable("name") String name, @PathVariable("password") String password) {  
        if(this.userService.validateCredentials(name, password)){
            return this.userService.generateToken();
        }
        return null;
    }
    
    @GetMapping("/tokens") 
    public boolean validateToken(@RequestBody TokenDTO token) {        
       return this.userService.validateToken(token);
    }
       
}
