package common.interfaces;

import common.entities.Song;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author jhonfer
 */
public interface IControllerManageSong extends Remote {
    public boolean saveSong(Song objSong, String token) throws RemoteException;
    public List<Song> listSong() throws RemoteException;
}
