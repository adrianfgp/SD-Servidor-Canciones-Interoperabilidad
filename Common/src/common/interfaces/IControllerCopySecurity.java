package common.interfaces;

import common.entities.SongDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jhonfer
 */
public interface IControllerCopySecurity extends Remote {
    public boolean saveCopySong(SongDTO objSong) throws RemoteException;
}