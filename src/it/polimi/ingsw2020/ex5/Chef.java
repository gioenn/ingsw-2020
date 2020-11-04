package it.polimi.ingsw2020.ex5;

public class Chef implements Runnable{
    private Pot pot;
    public Chef(Pot pot){
        this.pot = pot;
    }

    @Override
    public void run() {
        while(true){
            synchronized (pot) {
                System.out.println("Chef wants to fill the pot");
                pot.fill();
                System.out.println("Chef filled the pot");
            }

        }
    }
}
