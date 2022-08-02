package server.repository;

import common.entities.SongDTO;
import common.interfaces.ISongRepository;
import common.utilities.Audio;
import common.utilities.Console;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonfer
 */
public class SongRepository implements ISongRepository {
    private final List<SongDTO> listSongs;
    private int counter;
    
    public SongRepository() {
        this.listSongs = new ArrayList<SongDTO>();
        this.counter = 0;
    }
    
    @Override
    public boolean saveSong(SongDTO objSong) {
        Console.writeJumpLine("\n\nEntrando al método guardar canción", false);
        String nameSong = "misCanciones/"+objSong.getTitle()+"_"+(counter+1)+".mp3";
        boolean result = Audio.storeFile(nameSong, objSong.getArrayBytes());
        if (result) {
            this.listSongs.add(objSong);
            Console.writeJumpLine("Archivo creado en el servidor de canciones", false);
            Console.writeJumpLine("Metadatos del archivo", false);
            Console.writeJumpLine("titulo: " + objSong.getTitle(), false);
            Console.writeJumpLine("Artista: " + objSong.getArtist(), false);
            Console.writeJumpLine("Tamaño: " + objSong.getSizeMB() + "KB\n", false);
            this.counter++;
        }
        return result;
    }

    @Override
    public List<SongDTO> listSong() {
        Console.writeJumpLine("\nEntrando al método listar canciones", false);
        return this.listSongs;
    } 
}
