package common.interfaces;

import java.util.List;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonfer
 */
public interface ISongRepository {
    public boolean saveSong(SongDTO objSong);   
    public List<SongDTO> listSong();
}