package server.repository;

import common.utilities.Audio;
import common.utilities.Console;
import java.util.ArrayList;
import java.util.List;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

/**
 *
 * @author jhonfer
 */
public class SongCopyRepository implements ISongCopyRepository {
    private final List<SongDTO> listCopySongs;
    private int counter;
    
    public SongCopyRepository() {
        this.listCopySongs = new ArrayList<SongDTO>();
        this.counter = 0;
    }
    
    @Override
    public boolean saveSong(SongDTO objSong) {
        Console.writeJumpLine("\n\nEntrando al metodo guardar copia cancion", false);
        String nameSong = "misCanciones/copia_" + objSong.title + "_" + (this.counter + 1) + ".mp3";
        boolean result = Audio.storeFile(nameSong, objSong.arrayBytes);
        if (result) {
            this.listCopySongs.add(objSong);
            Console.writeJumpLine("Archivo creado en el servidor de respaldo", false);
            Console.writeJumpLine("Metadatos del archivo", false);
            Console.writeJumpLine("titulo: " + objSong.title, false);
            Console.writeJumpLine("Artista: " + objSong.artist, false);
            Console.writeJumpLine("Tamaño: " + objSong.sizeMB + "KB\n", false);
            this.counter++;
        }
        return result;
    }

    @Override
    public List<SongDTO> listSong() {
        return this.listCopySongs;
    } 
}
