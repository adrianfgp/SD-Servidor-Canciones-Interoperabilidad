package client.services;

import common.entities.TokenDTO;
import common.entities.UserDTO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

public class ClienteServices {

    private String endPoint;
    private Client objClientePeticiones;

    public ClienteServices() {
        this.endPoint = "http://localhost:6000/api";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public boolean registerUser(UserDTO objUserRegister) {
        boolean respuesta = false;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/clientes");
        Entity<UserDTO> data = Entity.entity(objUserRegister, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        respuesta = objPeticion.post(data, boolean.class);
        return respuesta;
    }

    public TokenDTO login(UserDTO objUserLogin) {
        TokenDTO objUser = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/clientes/" + objUserLogin.getName() + "/" + objUserLogin.getPassword());
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objUser = objPeticion.get(TokenDTO.class);
        return objUser;
    }
}
