package server.controllers;

import server.repository.ISongCopyRepository;
import soap_server_backup.IControllerCopySecurityPOA;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonfer
 */
public class ControllerCopySecurity extends IControllerCopySecurityPOA {
    private final ISongCopyRepository objCopySongs;
    
    public ControllerCopySecurity(ISongCopyRepository objCopySongs) {
        this.objCopySongs = objCopySongs;
    }
    
    @Override
    public boolean saveCopySong(SongDTO objSong) {
        return this.objCopySongs.saveSong(objSong);
    }
}
