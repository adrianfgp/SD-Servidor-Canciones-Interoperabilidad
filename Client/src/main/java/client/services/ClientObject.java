package client.services;

import client.utilities.RegisterClient;
import client.view.MenuClient;
import common.interfaces.IControllerManageSong;
import common.utilities.Console;

/**
 *
 * @author jhonfer
 */
public class ClientObject {
    private static IControllerManageSong objRemoteSong;

    public static void main(String[] args) {
        ClienteServices objRemoteUser = new ClienteServices();
        int numPortRMIRegistry = 0;
        String addressIpRMIRegistry = "";
        
        //QUEMANDO DIRECCION Y PUERTO
        addressIpRMIRegistry ="localhost" ;
        numPortRMIRegistry = 2020;
        
        //PIDIENDO LA DIRECCION Y PUERTO
        /*
        addressIpRMIRegistry = Console.read("Cuál es la dirección ip donde se encuentra el rmiregistry ?", addressIpRMIRegistry, false);
        numPortRMIRegistry = Console.read("Cuál es el numero de puerto por el cual escucha el rmiregistry ?", numPortRMIRegistry, false);
        */
        objRemoteSong = (IControllerManageSong) RegisterClient.getObjectRemote(addressIpRMIRegistry, numPortRMIRegistry, "objServicioGestionCanciones");
       
        MenuClient objMenu = new MenuClient("          === Menu ===          ", new String[]{"Registrarse en el servidor de usuarios","Iniciar Sesion","Ingresar y enviar datos de la canción", "Listar datos de las canciones registradas"}, objRemoteSong,objRemoteUser);
    }
}
