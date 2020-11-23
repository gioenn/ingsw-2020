package it.polimi.ingsw2020.ex6.chatrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient extends UnicastRemoteObject implements ChatClientI {

    private String username;
    private UI ui;

    public ChatClient(String username, UI ui) throws RemoteException {
        this.username = username;
        this.ui = ui;
    }

    @Override
    public void receive(String message) throws RemoteException {
        ui.showMessage(message);
    }

    @Override
    public String getUsername() throws RemoteException {
        return username;
    }
}
