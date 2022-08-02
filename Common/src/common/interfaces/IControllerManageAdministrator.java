package common.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jhonfer
 */
public interface IControllerManageAdministrator extends Remote {
    public boolean saveReferenceRemoteAdministrator(IAdministratorCallback objRefRemote) throws RemoteException;
}