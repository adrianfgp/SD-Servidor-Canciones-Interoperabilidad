package server.controllers;

import common.interfaces.ISongRepository;
import soap_server_backup.IControllerCopySecurityPOA;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonfer
 */
public class ControllerCopySecurity extends IControllerCopySecurityPOA {
    private final ISongRepository objCopySongs;
    
    public ControllerCopySecurity(ISongRepository objCopySongs) {
        this.objCopySongs = objCopySongs;
    }
    
    @Override
    public boolean saveCopySong(SongDTO objSong) {
        return this.objCopySongs.saveSong(objSong);
    }
}
