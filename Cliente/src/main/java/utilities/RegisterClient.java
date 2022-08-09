package client.utilities;

import common.utilities.Console;
import java.rmi.Naming;
import java.rmi.Remote;

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
}
