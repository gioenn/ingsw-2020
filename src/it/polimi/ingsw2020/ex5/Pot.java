package it.polimi.ingsw2020.ex5;

public class Pot {

    private final int P = 40;
    private int parts = P;

    public synchronized void getPart(String name){
        while(parts == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        parts--;
        notify();
        System.out.println("Camper "+name+" obtained a part. Remaining parts "+parts);
    }

    public synchronized void fill(){
        while(parts > 0){
            System.out.println("Chef is checking the pot...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        parts = P;
        notifyAll();
    }
    public static void main(String[] args){
        Pot pot = new Pot();
        new Thread(new Chef(pot)).start();
        new Thread(new Camper(pot, "A")).start();
        new Thread(new Camper(pot, "B")).start();
        new Thread(new Camper(pot, "C")).start();
        new Thread(new Camper(pot, "D")).start();
        new Thread(new Camper(pot, "E")).start();
        new Thread(new Camper(pot, "F")).start();
        new Thread(new Camper(pot, "G")).start();

    }
}
