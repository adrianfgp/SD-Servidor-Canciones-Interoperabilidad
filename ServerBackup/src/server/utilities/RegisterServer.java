package server.utilities;

import common.utilities.Console;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author jhonfer
 */
public class RegisterServer {
    
    public static void runNS(int numPortRMI) throws RemoteException {
        try {
            Registry register = LocateRegistry.getRegistry(numPortRMI);
            String[] listRegister = register.list();
            for (String idNS : listRegister) {
                Console.writeJumpLine("ns : " + idNS, false);
            }
            Console.writeJumpLine("El rmiRegistry se ha obtenido y se encuentra escuchando en el puerto: " + numPortRMI, false);
        } catch (RemoteException e) {
            Console.writeJumpLine("El rmiRegistry no se localizo en el puerto: " + numPortRMI, false);
            Registry register = LocateRegistry.createRegistry(numPortRMI);
            Console.writeJumpLine("El rmiRegistry se ha creado en el puerto: " + numPortRMI, false);
        }
    }

    public static void registerObjectRemote(Remote objectRemote, String addrIpNS, int numPortNS, String idObjectRemote) throws MalformedURLException {
        String uriRegister = "rmi://" + addrIpNS + ":" + numPortNS + "/" + idObjectRemote;
        try {
            Naming.rebind(uriRegister, objectRemote);
            Console.writeJumpLine("Se realizo el registro del objecto remoto en el ns ubicado en la direccion: " + addrIpNS + " y puerto " + numPortNS, false);
        } catch (RemoteException e) {
            Console.writeJumpLine("Error en el registro del objecto remote", false);
        } catch (MalformedURLException e) {
            Console.writeJumpLine("Error uri invalida...", false);
        }
    }
}