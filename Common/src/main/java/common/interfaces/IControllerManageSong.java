package common.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;
import common.entities.UserDTO;

/**
 *
 * @author jhonfer
 */
public interface IControllerManageSong extends Remote {
    public boolean saveSong(SongDTO objSong) throws RemoteException;
    public List<SongDTO> listSong() throws RemoteException;
}
