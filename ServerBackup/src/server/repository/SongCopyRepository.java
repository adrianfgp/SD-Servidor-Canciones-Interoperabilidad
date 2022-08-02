package server.repository;

import common.entities.SongDTO;
import common.interfaces.ISongRepository;
import common.utilities.Audio;
import common.utilities.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonfer
 */
public class SongCopyRepository implements ISongRepository {
    private final List<SongDTO> listCopySongs;
    private int counter;
    
    public SongCopyRepository() {
        this.listCopySongs = new ArrayList<SongDTO>();
        this.counter = 0;
    }
    
    @Override
    public boolean saveSong(SongDTO objSong) {
        Console.writeJumpLine("\n\nEntrando al metodo guardar copia cancion", false);
        String nameSong = "misCanciones/copia_" + objSong.getTitle() + "_" + (this.counter + 1) + ".mp3";
        boolean result = Audio.storeFile(nameSong, objSong.getArrayBytes());
        if (result) {
            this.listCopySongs.add(objSong);
            Console.writeJumpLine("Archivo creado en el servidor de respaldo", false);
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
        return this.listCopySongs;
    } 
}
