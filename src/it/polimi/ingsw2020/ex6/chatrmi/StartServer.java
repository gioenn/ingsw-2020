package it.polimi.ingsw2020.ex6.chatrmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        ChatServerI server = new ChatServer();
        Naming.rebind("rmi://127.0.0.1/chat", server);
        System.out.println("Server ready");
    }

}

