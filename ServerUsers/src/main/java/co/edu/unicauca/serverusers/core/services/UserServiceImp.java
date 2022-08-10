package co.edu.unicauca.serverusers.core.services;

import co.edu.unicauca.serverusers.core.repositories.TokenRepository;
import co.edu.unicauca.serverusers.core.repositories.UserRepository;
import common.entities.TokenDTO;
import common.entities.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author adrianfGP
 */
@Service
public class UserServiceImp implements IUserService{
    
    @Autowired
    private TokenRepository tokenRepository;
    
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public boolean userIsRegistred(String username) {
       return this.userRepository.userIsRegistred(username);
    }

    @Override
    public boolean validateCredentials(String username, String password) {
       return this.userRepository.validateCredentials(username, password);
    }

    @Override
    public boolean registerUser(UserDTO user) {
       return this.userRepository.registerUser(user);
    }

    @Override
    public String generateToken() {
        return this.tokenRepository.generateToken();
    }

    @Override
    public boolean validateToken(String token) {
        return this.tokenRepository.validateToken(token);
    }

}
