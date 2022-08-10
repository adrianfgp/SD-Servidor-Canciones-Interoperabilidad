package common.interfaces;

import common.entities.Song;
import java.util.List;

/**
 *
 * @author jhonfer
 */
public interface ISongRepository {
    public boolean saveSong(Song objSong);   
    public List<Song> listSong();
}
