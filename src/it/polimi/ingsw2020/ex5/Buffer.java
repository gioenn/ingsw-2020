package it.polimi.ingsw2020.ex5;

public class Buffer {

    private char c;
    private boolean full;

    public synchronized void put(char c){
        while(full){
            try {
                wait();
            }
            catch (InterruptedException e){

            }
        }
        full = true;
        this.c = c;
        notify();
    }

    public synchronized char get () {
        while(!full){
            try {
                wait();
            }
            catch (InterruptedException e){

            }
        }
        notify();
        full = false;
        return c;
    }

    public static void main(String[] args){

        Buffer[] bfs = new Buffer[4];
        bfs[0] = new Buffer();
        bfs[1] = new Buffer();
        bfs[2] = new Buffer();
        bfs[3] = new Buffer();

        // Part 1: {"1,c", "0,b", "2,m", "0,f", "1,h", "3,n"};
        String commands[] = {"1,a", "1,b"};

        PI pi = new PI(bfs, commands);
        PO po = new PO(bfs);

        new Thread(pi).start();
        new Thread(po).start();

    }
}
