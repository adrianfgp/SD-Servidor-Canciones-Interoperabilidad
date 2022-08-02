package server.services;

import common.utilities.Console;
import java.rmi.RemoteException;
import server.controllers.ControllerCopySecurity;
import server.repository.SongCopyRepository;
import server.utilities.RegisterServer;

/**
 *
 * @author jhonfer
 */
public class ServerObject {

    public static void main(String[] args) throws RemoteException {
        int numPortRMIRegistry = 0;
        String addressIpRMIRegistry = " ";
        addressIpRMIRegistry = Console.read("Cual es la direccion ip donde se encuentra el rmiRegistry ?", addressIpRMIRegistry, false);
        numPortRMIRegistry = Console.read("Cual es el numero de puerto por el cual escucha el rmiRegistry ?", numPortRMIRegistry, false);

        SongCopyRepository objRepository = new SongCopyRepository();
        ControllerCopySecurity objRemote = new ControllerCopySecurity(objRepository);

        try {
            RegisterServer.runNS(numPortRMIRegistry);
            RegisterServer.registerObjectRemote(objRemote, addressIpRMIRegistry, numPortRMIRegistry, "objServicioGestionCopiaCanciones");
        } catch (Exception e) {
            Console.writeJumpLine("No fue posible arrancar el ns o registrar el objeto remoto " + e.getMessage(), false);
        }
    }
}