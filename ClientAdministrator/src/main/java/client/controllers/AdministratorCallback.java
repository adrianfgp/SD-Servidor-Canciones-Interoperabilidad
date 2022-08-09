package client.controllers;

import common.entities.NotifyDTO;
import common.interfaces.IAdministratorCallback;
import common.utilities.Console;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jhonfer
 */
public class AdministratorCallback extends UnicastRemoteObject implements IAdministratorCallback {
    
    public AdministratorCallback() throws RemoteException {
        super();
    }
    
    @Override
    public boolean notifyNewSong(NotifyDTO notify) throws RemoteException {
        Console.writeJumpLine("\nN O T I F I C A C I Ó N",false);
        Console.writeJumpLine("Una nueva canción se ha registrado.",false);
        Console.writeJumpLine("Id: "+notify.getId(), false);
        Console.writeJumpLine("Titulo: "+notify.getSong().getTitle(), false);
        Console.writeJumpLine("Artista: "+notify.getSong().getArtist(), false);
        Console.writeJumpLine("Tipo: "+notify.getSong().getType(), false);
        Console.writeJumpLine("Fecha de registro de la canción en el servidor: "+notify.getDate().toString(), false);
        Console.writeJumpLine("Cantidad de canciones registradas: "+notify.getSize(), false);
        return true;
    }
}
