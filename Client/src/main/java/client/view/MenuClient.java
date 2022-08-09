package client.view;

import java.rmi.RemoteException;
import common.interfaces.IControllerManageSong;
import common.utilities.Audio;
import common.utilities.Console;
import common.utilities.Menu;
import common.entities.UserDTO;
import java.util.List;
import client.services.ClienteServices;
import common.entities.TokenDTO;
import soap_server_backup.IControllerCopySecurityPackage.SongDTO;

public class MenuClient extends Menu {

    private IControllerManageSong objRemoteSong;
    private ClienteServices objRemoteUser ;

    public MenuClient(String title, String[] options, IControllerManageSong objRemoteSong, ClienteServices objRemoteUser) {
        super(title, options);
        this.objRemoteSong = objRemoteSong;
        this.objRemoteUser = objRemoteUser;
        this.repeatedMenu();
    }

    @Override
    public void processOption() {
        switch (option) {
            case 1: {
                this.registerUser();
                break;
            }
            case 2: {
                this.login();
                break;
            }
            case 3: {
                this.registerSong();
                break;
            }
            case 4: {
                this.showSongs();
                break;
            }
            case 5: {
                Console.writeJumpLine("Salir...", false);
                break;
            }
        }
    }

    private void registerUser() {
        UserDTO objUser = new UserDTO();
        boolean value = false;
        String name = "";
        String password = "";
        String message = "";

        Console.writeJumpLine("\nRegistrando un nuevo Usuario", false);
        name = Console.read("Ingrese el usuario: ", name, false);
        objUser.setName(name);
        password = Console.read("Ingrese la contraseña: ", password, false);
        objUser.setPassword(password);
        value = objRemoteUser.registerUser(objUser);
        message = (value) 
                ?  "Usuario registrado con exito.\n"
                :  "No se pudo registrar el usuario...\n";
        Console.writeJumpLine(message, false);
    }

    private void login() {
        String name = "";
        String password = "";
        String message = "";
        UserDTO objUser = new UserDTO();
        Console.writeJumpLine("Inicio de sesion", false);
        name = Console.read("Ingrese el usuario: ", name, false);
        objUser.setName(name);
        password = Console.read("Ingrese la contraseña: ", password, false);
        objUser.setPassword(password);
        TokenDTO token =  objRemoteUser.login(objUser);
        message = (token != null) 
                ? "Bienvenido: " + objUser.getName()+"\n"
                + "Su token de acceso es: "+token.getValue()
                : "Usuario o Contraseña no validos.";
        Console.writeJumpLine(message, false);   
    }

    private void registerSong() {
        try {
            boolean value = false;
            String nameSong = "", token = "";
            nameSong = Console.read("Ingrese el nombre de la canción a registrar (junto con su extensión): ", nameSong, false);
            token = Console.read("Ingrese el token de verificacion: ", token, false);
            SongDTO objSong = Audio.readMetaData(nameSong);
            TokenDTO objToken = new TokenDTO();
            objToken.setValue(token);
            if (objSong != null) {
                value = this.objRemoteSong.saveSong(objSong, objToken);
            }
            String messageOut = (value) 
                    ? "Registro realizado satisfactoriamente..." 
                    : "No se pudo realizar el registro";
            Console.writeJumpLine(messageOut, false);
        } catch (RemoteException e) {
            Console.writeJumpLine("La operación no se pudo completar, intente nuevamente..."+e.getMessage(), false);
        }
    }

    private void showSongs() {
        try {
            List<SongDTO> listSongs = this.objRemoteSong.listSong();
            if (!listSongs.isEmpty()) {
                int counter = 1;
                Console.writeJumpLine("\n*** Información de las canciones ***", false);
                for (SongDTO listSong : listSongs) {
                    Console.writeJumpLine("\nCanción No " + counter, false);
                    Console.writeJumpLine(
                            "Titulo: " + listSong.getTitle()
                            + "\nArtista: " + listSong.getArtist()
                            + "\nTamaño: " + listSong.getSizeMB() + "KB\n", 
                            false);
                    counter++;
                }
            }
        } catch (Exception e) {
            Console.writeJumpLine("La operación no se pudo completar, intente nuevamente...", false);
        }
    }
}
