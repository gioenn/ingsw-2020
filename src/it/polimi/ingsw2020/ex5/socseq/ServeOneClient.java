package it.polimi.ingsw2020.ex5.socseq;

import java.io.*;
import java.net.Socket;

public class ServeOneClient implements Runnable {

    private Socket socket;
    private BufferedReader inSocket;
    private PrintWriter outSocket;

    public ServeOneClient(Socket socket){
        this.socket = socket;
        System.out.println("Client connected");
        try {
            inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outSocket = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        login();
        manageClient();
    }

    public void login() {
        // TODO: HOMEWORK
    }

    public void manageClient() {
        // TODO: STORE AND SHOW RECORDS (HOMEWORK)
        try {
            play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            close();
        }
        // showRecords();

    }

    public void play() throws IOException {
        boolean ok = true;
        int l = 1;
        inSocket.readLine();
        while(ok){
                String seq = generateSequence(l);
                outSocket.println(seq);
                String clientSeq = inSocket.readLine();
                System.out.println(clientSeq);
                if (clientSeq.equals(seq))
                    outSocket.println("true");
                else {
                    outSocket.println("false");
                    ok = false;
                }
                l++;

        }
    }

    private String generateSequence(int l){
        String res = "";
        for (int i = 0; i < l; i++){
            int num = (int) (Math.random()*10);
            res += num;
        }
        return res;
    }

    private void close() {
        try {
            System.out.println("Client closed");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRecords(){

    }


}
