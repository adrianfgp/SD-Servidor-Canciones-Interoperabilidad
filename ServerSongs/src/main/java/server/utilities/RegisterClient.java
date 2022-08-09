package server.utilities;

import common.utilities.Console;
import java.rmi.Naming;
import java.rmi.Remote;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import soap_server_backup.IControllerCopySecurity;
import soap_server_backup.IControllerCopySecurityHelper;

/**
 *
 * @author jhonfer
 */
public class RegisterClient {
    public static Remote getObjectRemote(String addressIp, int port, String nameObjectRegistered) {
        String uriRegister;
        uriRegister = "rmi://" + addressIp + ":" + port + "/" + nameObjectRegistered;
        try {
            return Naming.lookup(uriRegister);
        } catch (Exception e) {
            Console.writeJumpLine("Excepción en la obtención del objeto remoto" + e, false);
            return null;
        }
    }
    public static IControllerCopySecurity getObjRemote(String[] vectorDatosNS, String idObjetoRemoto) {

        IControllerCopySecurity ref = null;
        try {
            ORB orb = ORB.init(vectorDatosNS, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***            
            ref = IControllerCopySecurityHelper.narrow(ncRef.resolve_str(idObjetoRemoto));
        } catch (Exception e) {
            System.out.println("Error al localizar el objeto remoto");
        }

        return ref;
    }

}
