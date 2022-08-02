package client.view;

import java.rmi.RemoteException;
import common.entities.SongDTO;
import common.interfaces.IControllerManageSong;
import common.utilities.Audio;
import common.utilities.Console;
import common.utilities.Menu;
import java.util.List;


public class MenuClient extends Menu {
    private IControllerManageSong objRemoteSong;
    
    public MenuClient(String title, String [] options, IControllerManageSong objRemoteSong) {
        super(title, options);
        this.objRemoteSong = objRemoteSong;
        this.repeatedMenu();
    }
    
    @Override
    public void processOption() {
        switch (option) {
            case 1 -> {
                this.registerSong();
            }
            case 2 -> {
                this.showSongs();
            }
            case 3 -> {
                Console.writeJumpLine("Salir...", false);
            }
        }
    }
    private void registerSong() {
        try {
            boolean value = false;
            String nameSong = "";
            nameSong = Console.read("Ingrese el nombre de la canción a registrar (junto con su extensión): ", nameSong, false);
            SongDTO objSong = Audio.readMetaData(nameSong);
            if (objSong != null) {
                byte[] arrayBytesSong = Audio.getBytesSong();
                objSong.setArrayBytes(arrayBytesSong);
                value = this.objRemoteSong.saveSong(objSong);
            }
            String messageOut = (value) ? "Registro realizado satisfactoriamente..." : "No se pudo realizar el registro";
            Console.writeJumpLine(messageOut, false);
        } catch (RemoteException e) {
            Console.writeJumpLine("La operación no se pudo completar, intente nuevamente...", false);
        }
    }
    
    private void showSongs() {
        try {
            List<SongDTO> listSongs = this.objRemoteSong.listSong();
            if(!listSongs.isEmpty()) {
                int counter = 1;
                Console.writeJumpLine("\n*** Información de las canciones ***", false);
                for (SongDTO listSong : listSongs) {
                    Console.writeJumpLine("\nCanción No " + counter, false);
                    Console.writeJumpLine("Titulo: " + listSong.getTitle() +
                            "\nArtista: " + listSong.getArtist() + 
                            "\nTamaño: " + listSong.getSizeMB() + "KB\n", false);
                    counter++;
                }
            }
        } catch (Exception e) {
            Console.writeJumpLine("La operación no se pudo completar, intente nuevamente...", false);
        }
    }
}
