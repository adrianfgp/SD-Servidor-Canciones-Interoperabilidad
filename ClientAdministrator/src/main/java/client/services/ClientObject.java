package client.services;

import client.controllers.AdministratorCallback;
import client.utilities.RegisterClient;
import common.interfaces.IControllerManageAdministrator;
import common.utilities.Console;
import java.rmi.RemoteException;

/**
 *
 * @author jhonfer
 */
public class ClientObject {
    private static IControllerManageAdministrator objRemoteAdministrator;
    
    public static void main(String[] args) throws RemoteException {
        int numPortRMIRegistry = 0;
        String addressIpRMIRegistry = " ";
        //QUEMANDO DIRECCION Y PUERTO
        addressIpRMIRegistry ="localhost" ;
        numPortRMIRegistry = 2020;
        
        /*
        addressIpRMIRegistry = Console.read("Cuál es la dirección ip donde se encuentra el rmiRegistry ?", addressIpRMIRegistry, false);
        numPortRMIRegistry = Console.read("Cuál es el numero de puerto por el cual escucha el rmiRegistry ?", numPortRMIRegistry, false);
        */
        objRemoteAdministrator = (IControllerManageAdministrator) RegisterClient.getObjectRemote(addressIpRMIRegistry, numPortRMIRegistry, "objServicioGestionAdministradores");
        AdministratorCallback objAdminCallback = new AdministratorCallback();
        objRemoteAdministrator.saveReferenceRemoteAdministrator(objAdminCallback);
        Console.writeJumpLine("Servidor de Notificaciones ejecutandose...", false);
    }  
}
