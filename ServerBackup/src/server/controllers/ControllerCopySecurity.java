package server.controllers;

import common.entities.SongDTO;
import common.interfaces.IControllerCopySecurity;
import common.interfaces.ISongRepository;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jhonfer
 */
public class ControllerCopySecurity extends UnicastRemoteObject implements IControllerCopySecurity {
    private final ISongRepository objCopySongs;
    
    public ControllerCopySecurity(ISongRepository objCopySongs) throws RemoteException {
        super();
        this.objCopySongs = objCopySongs;
    }
    
    @Override
    public boolean saveCopySong(SongDTO objSong) throws RemoteException {
        return this.objCopySongs.saveSong(objSong);
    }
}