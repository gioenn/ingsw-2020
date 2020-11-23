package it.polimi.ingsw2020.ex6.chatrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServerI extends Remote {

    boolean login(ChatClientI o) throws RemoteException;
    void publish(String message) throws RemoteException;
    List<ChatClientI> getConnected() throws RemoteException;

}
