package server.controllers;

import common.entities.NotifyDTO;
import common.interfaces.IControllerManageSong;
import common.interfaces.ISongRepository;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.utilities.RegisterClient;
import soap_server_backup.IControllerCopySecurity;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonfer
 */
public class ControllerManageSong extends UnicastRemoteObject implements IControllerManageSong {
    private final ISongRepository objSongRepository;
    private final ControllerManageAdministrator objManageAdministrator;
    private static IControllerCopySecurity objSongCopySecurity;
    private int counter;
    
    public ControllerManageSong(ISongRepository objSongRepository, ControllerManageAdministrator objManageAdministrator) throws RemoteException {
        this.objSongRepository = objSongRepository;
        this.objManageAdministrator = objManageAdministrator;
        this.counter = 0;
    }
    
    public void getObjectRemoteServerBackup(String addressIp, int portNS) throws RemoteException {
        String[] arrayDataLocationNS = {"-ORBInitialHost", addressIp, "-ORBInitialPort", ""+portNS };
        this.objSongCopySecurity = (IControllerCopySecurity) RegisterClient.getObjRemote(arrayDataLocationNS, "objServicioGestionCopiaCanciones");
    }
    
    @Override
    public boolean saveSong(SongDTO objSong) throws RemoteException {
        boolean result = this.objSongRepository.saveSong(objSong);
        if (result) {
            int size = this.listSong().size();
            NotifyDTO notify = new NotifyDTO(counter + 1, objSong, size);
            this.objManageAdministrator.notifyAdministrator(notify);
            this.objSongCopySecurity.saveCopySong(objSong);
            this.counter++;
        }
        return result;
    }

    @Override
    public List<SongDTO> listSong() throws RemoteException {
        return this.objSongRepository.listSong();
    }
}
