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
        
        //quemando direccion y puerto
        String[] vectorDatosLocalizarNS = {"-ORBInitialHost", "localhost", "-ORBInitialPort", "3030" };
        /*
        String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
        
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = Console.read("Ingrese la dirección IP donde escucha el n_s: ", "", false);
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = String.valueOf(Console.read("Ingrese el puerto donde escucha el n_s: ", 0, false));
        */
        SongCopyRepository objRepository = new SongCopyRepository();
        ControllerCopySecurity objRemote = new ControllerCopySecurity(objRepository);

        try {
            RegisterServer.registerObjectRemoto(vectorDatosLocalizarNS, objRemote, "objServicioGestionCopiaCanciones");
        } catch (Exception e) {
            Console.writeJumpLine("No fue posible arrancar el ns o registrar el objeto remoto " + e.getMessage(), false);
        }
    }
}