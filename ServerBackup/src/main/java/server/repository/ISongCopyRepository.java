package server.repository;

import java.util.List;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonf
 */
public interface ISongCopyRepository {
    public boolean saveSong(SongDTO objSong);   
    public List<SongDTO> listSong();
}
