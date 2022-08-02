package common.interfaces;

import common.entities.SongDTO;
import java.util.List;

/**
 *
 * @author jhonfer
 */
public interface ISongRepository {
    public boolean saveSong(SongDTO objSong);   
    public List<SongDTO> listSong();
}