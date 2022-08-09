package vista;

import java.rmi.RemoteException;
import common.interfaces.IControllerManageSong;
import common.utilities.Audio;
import common.utilities.Console;
import common.utilities.Menu;
import common.entities.UserDTO;
import java.util.List;
import servicios.ClienteServices;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;


public class MenuClient extends Menu {
    private IControllerManageSong objRemoteSong;
    private ClienteServices objRemoteUser;
    
    
    public MenuClient(String title, String [] options, IControllerManageSong objRemoteSong,ClienteServices objRemoteUser) {
        super(title, options);
        this.objRemoteSong = objRemoteSong;
        this.objRemoteUser=objRemoteUser;
        this.repeatedMenu();
    }
    
    @Override
    public void processOption() {
        switch (option) {
            case 1: {
                this.registerUser();
            }
            case 2: {
                this.login();
            }
            case 3: {
                this.registerSong();
            }
            case 4: {
                this.showSongs();
            }
            case 5: {
                Console.writeJumpLine("Salir...", false);
            }
        }
    }
    
    private void registerUser() {
        
            UserDTO objUser = new UserDTO();
            boolean value = false;
            String name = "";
            String password = "";
            
          System.out.println("\nRegistrando un nuevo Usuario");
        name = Console.read("Ingrese el usuario: ", name, false);
        objUser.setName(name);
        password = Console.read("Ingrese la contraseña: ", password, false);
        objUser.setPassword(password);
        if (objRemoteUser.registerUser(objUser) == null) {
            System.out.println("No se pudo registrar el usuario...\n");
            return;
        }
        System.out.println("Usuario registrado con exito.\n");
    }
    
    private void login() {
        String name = "";
        String password = "";
        UserDTO objUser = new UserDTO();
        System.out.println("Inicio de sesion");
        name = Console.read("Ingrese el usuario: ", name, false);
        objUser.setName(name);
        password = Console.read("Ingrese la contraseña: ", password, false);
        objUser.setPassword(password);
        objUser = objRemoteUser.login(objUser);
        if (objUser == null) {
            System.out.println("Usuario o Contraseña no validos.");
            return;
        }
        System.out.println("Bienvenido: " + objUser.getName());
    }
    private void registerSong() {
        try {
            boolean value = false;
            String nameSong = "";
            nameSong = Console.read("Ingrese el nombre de la canción a registrar (junto con su extensión): ", nameSong, false);
            SongDTO objSong = Audio.readMetaData(nameSong);
            if (objSong != null) {
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
