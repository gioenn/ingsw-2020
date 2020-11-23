package it.polimi.ingsw2020.ex6.chatrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements ChatServerI {

    public ChatServer() throws RemoteException { }
    List<ChatClientI> users = new ArrayList<>();

    @Override
    public boolean login(ChatClientI client) throws RemoteException {
        client.receive("You are connected in this chat");
        publish(client.getUsername()+" joined this chat");
        users.add(client);
        return true; // TODO: tbc
    }

    @Override
    public void publish(String message) throws RemoteException {
        for (ChatClientI user : users)
            user.receive(message);
    }

    @Override
    public List<ChatClientI> getConnected() throws RemoteException {
        return users;
    }
}
