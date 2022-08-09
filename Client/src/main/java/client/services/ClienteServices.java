package client.services;

import common.entities.TokenDTO;
import common.entities.UserDTO;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

public class ClienteServices {

    private String endPoint;
    private Client objClientePeticiones;

    public ClienteServices() {
        this.endPoint = "http://localhost:6000/api/clientes";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public UserDTO consultarCliente(Integer id) {
        UserDTO objCliente = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + id);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objCliente = objPeticion.get(UserDTO.class);
        return objCliente;
    }

    public List<UserDTO> listarClientes() {
        List<UserDTO> listUser = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        listUser = objPeticion.get(new GenericType<List<UserDTO>>() { });
        return listUser;
    }

    public boolean registerUser(UserDTO objUserRegister) {
        boolean respuesta = false;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<UserDTO> data = Entity.entity(objUserRegister, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        respuesta = objPeticion.post(data, boolean.class);
        return respuesta;
    }

    public TokenDTO login(UserDTO objUserLogin) {
        TokenDTO objUser = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + objUserLogin.getName() + "/" + objUserLogin.getPassword());
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objUser = objPeticion.get(TokenDTO.class);
        return objUser;
    }
}
