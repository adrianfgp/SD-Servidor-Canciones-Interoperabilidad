package server.controllers;

import common.entities.NotifyDTO;
import common.interfaces.IAdministratorCallback;
import common.interfaces.IControllerManageAdministrator;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonfer
 */
public class ControllerManageAdministrator extends UnicastRemoteObject implements IControllerManageAdministrator {
    private final List<IAdministratorCallback> referencesAdmin;
    
    public ControllerManageAdministrator() throws RemoteException {
        super();
        this.referencesAdmin = new ArrayList<IAdministratorCallback>();
    }
    
    @Override
    public boolean saveReferenceRemoteAdministrator(IAdministratorCallback objRefRemote) throws RemoteException {
        this.referencesAdmin.add(objRefRemote);
        return true;
    }
    
    public void notifyAdministrator(NotifyDTO notify) throws RemoteException {
        for (IAdministratorCallback objReference : referencesAdmin) {
            objReference.notifyNewSong(notify);
        }
    }
}