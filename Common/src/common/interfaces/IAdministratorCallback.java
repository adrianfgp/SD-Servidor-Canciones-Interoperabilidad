package common.interfaces;

import common.entities.NotifyDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jhonfer
 */
public interface IAdministratorCallback extends Remote {
    public boolean notifyNewSong(NotifyDTO notify) throws RemoteException;
}