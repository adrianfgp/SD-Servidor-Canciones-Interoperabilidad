package common.utilities;

import common.entities.SongDTO;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 *
 * @author jhonfer
 */
public class Audio {
    private static File file;
    public static SongDTO readMetaData(String nameSong) {
        SongDTO objSong = null;
        String name = nameSong;
        try {
            PrintStream obj;
            obj = new PrintStream(new File("archivoSalida.txt"));
            System.setErr(obj);
            if(validFile(name) == 0){
                AudioFile f = AudioFileIO.read(file);
                Tag tag = f.getTag();
                int sizeMB = (int) (file.length() / 1024);
                String artist = tag.getFirst(FieldKey.ARTIST);
                String title = tag.getFirst(FieldKey.TITLE);
                objSong = new SongDTO(artist, title, sizeMB);
            }
        } catch (Exception ex) {
            Console.writeJumpLine("Error al leer los métadatos del archivo", false);
        }
        return objSong;
    }
    
    private static int validFile(String name) {
        int flag = 0;
        file = new File(name);
        if(!file.exists()) {
            flag++;
            Console.writeJumpLine("Lo sentimos, no existe la cancion", false);
        }
        String ext = "";
        if(!(ext = name.replaceAll("^.*\\\\.(.*)$", "$1")).contains("mp3")) {
            flag++;
            Console.writeJumpLine("Lo siento, el formato no es el indicado para una cancion", false);
        }
        return flag;
    }
    
    public static byte[] getBytesSong() {
        byte[] arrayBytesCancion = null;
        try {
            FileInputStream objFileInputStream = new FileInputStream(file);
            BufferedInputStream objBuffer = new BufferedInputStream(objFileInputStream);
            arrayBytesCancion = new byte[(int) file.length()];
            objBuffer.read(arrayBytesCancion, 0, arrayBytesCancion.length);
        } catch (FileNotFoundException ex) {
            Console.writeJumpLine("Error, archivo no encontrado", false);
        } catch (IOException ex) {
            Console.writeJumpLine("Error al leer los métadatos del archivo", false);
        }
        return arrayBytesCancion;
    }
    
    
    public static boolean storeFile(String name, byte [] arrayBytes) {
        boolean flag = true;
        try {
            String nameFile = name;
            File objFile = new File(nameFile.replaceAll("\\\\", "").replace(" ", ""));// archivo donde se almacenara la canción
            OutputStream output = new FileOutputStream(objFile);
            output.write(arrayBytes);// escribiendo la canción en el archivo
        } catch (FileNotFoundException e) {
            flag = false;
        } catch (IOException ex) {
            flag = false;
        }
        return flag;
    }
}