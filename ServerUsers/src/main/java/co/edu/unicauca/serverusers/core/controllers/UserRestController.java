package co.edu.unicauca.serverusers.core.controllers;

import common.entities.UserDTO;
import co.edu.unicauca.serverusers.core.services.IUserService;
import common.entities.TokenDTO;
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
        System.out.println("Registrar ingresando al sistema" + user.getName() + "   " + user.getPassword());
        boolean respuesta = false;
        if(!this.userService.userIsRegistred(user.getName())){
            this.userService.registerUser(user);
            respuesta = true;
        }
        return respuesta;
    }
    
   @GetMapping("clientes/{name}/{password}") 
    public TokenDTO login(@PathVariable("name") String name, @PathVariable("password") String password) {  
        System.out.println("Login ingresando al sistema" + name+ "   " + password);
        if(this.userService.validateCredentials(name, password)){
            return this.userService.generateToken();
        }
        return null;
    }
    
    @PostMapping("/tokens") 
    public boolean validateToken(@RequestBody TokenDTO token) {        
       System.out.println("Token ingresando al sistema" + token.getValue());
       return this.userService.validateToken(token);
    }
       
}
