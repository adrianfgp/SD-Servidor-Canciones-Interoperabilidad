package interfaces;

import entities.SongDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/**
 *
 * @author jhonfer
 */
public interface IControllerManageSong extends Remote {
    public boolean saveSong(SongDTO objSong) throws RemoteException;
    public List<SongDTO> listSong() throws RemoteException;
}
