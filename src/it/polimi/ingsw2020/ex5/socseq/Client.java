package it.polimi.ingsw2020.ex5.socseq;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedReader inSocket;
    private PrintWriter outSocket;
    private BufferedReader inKeyboard;

    public Client(){
        try {
            socket = new Socket("localhost", Server.PORT);
            inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outSocket = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            inKeyboard = new BufferedReader(new InputStreamReader(System.in));

            play();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void play() {
        System.out.println("Partita iniziata");
        System.out.println("Leggi i numeri, memorizzali e riscrivili");
        System.out.println("Premi invio per iniziare");
        try {
            inKeyboard.readLine();
            outSocket.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean ok = true;

        while(ok){
            try {
                System.out.println("Sequenza:");
                String serverSeq = inSocket.readLine();
                System.out.println(serverSeq);
                Thread.sleep(500);
                generateSpace();
                String seq = inKeyboard.readLine();
                outSocket.println(seq);
                ok = Boolean.valueOf(inSocket.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hai perso...");
    }

    private void generateSpace() {
        for(int i=0; i<200; i++)
            System.out.println();
    }

    public static void main(String[] args){
        new Client();
    }

}
