package it.polimi.ingsw2020.ex6.chatrmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ChatCLI implements UI {

    private BufferedReader inKeyboard;
    private ChatClientI client;
    private ChatServerI server;

    public ChatCLI() throws IOException, NotBoundException {
        inKeyboard = new BufferedReader(new InputStreamReader(System.in));
        if(connect())
            write();
    }

    private boolean connect() throws IOException, NotBoundException {
        System.out.println("Inserisci l'indirizzo del server");
        String ip = inKeyboard.readLine();
        System.out.println("Inserisci il tuo username");
        String username = inKeyboard.readLine();
        server = (ChatServerI) Naming.lookup("rmi://"+ip+"/chat");
        client = new ChatClient(username, this);
        showUsers();
        return server.login(client);
    }

    private void write() throws IOException {
        while(true){
            String message = inKeyboard.readLine();
            server.publish("["+client.getUsername()+"] "+message);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    private void showUsers() throws RemoteException {
        System.out.println("Gli utenti in chat sono:");
        List<ChatClientI> users = server.getConnected();
        for (ChatClientI user : users)
            System.out.println(user.getUsername());
    }

    public static void main(String[] args) throws IOException, NotBoundException {
        new ChatCLI();
    }
}
