package common.interfaces;

import common.entities.TokenDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonfer
 */
public interface IControllerManageSong extends Remote {
    public boolean saveSong(SongDTO objSong, TokenDTO objToken) throws RemoteException;
    public List<SongDTO> listSong() throws RemoteException;
}
