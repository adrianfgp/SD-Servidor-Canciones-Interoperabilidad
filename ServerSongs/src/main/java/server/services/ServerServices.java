/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.services;

import common.entities.TokenDTO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author jhonf
 */
public class ServerServices {
    private String endPoint;
    private Client objClientePeticiones;
    
    public ServerServices() {
        this.endPoint = "http://localhost:6000/api";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public boolean validToken(String token) {
        boolean response = false;
        WebTarget target = this.objClientePeticiones.target(this.endPoint +"/tokens/"+token);
        Builder objRequest = target.request(MediaType.APPLICATION_JSON_TYPE);
        response = objRequest.get(boolean.class);
        return response;
    }
}
