package it.polimi.ingsw2020.ex5;

public class Producer implements Runnable {

    private Account account;
    private final int time, max;

    public Producer(Account account, int time, int max){
        this.account = account;
        this.time = time;
        this.max = max;
    }

    @Override
    public void run() {
        while(true){
            int amount = (int) (Math.random()*max);
            synchronized (account) {
                account.deposit(amount);
                System.out.println("Depositati " + amount + "E");
                System.out.println("Disponibilità: " + account.getAmount() + "E");
            }

            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
