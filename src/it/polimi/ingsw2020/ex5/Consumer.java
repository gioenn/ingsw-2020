package it.polimi.ingsw2020.ex5;

public class Consumer implements Runnable {

    private Account account;
    private final int time, max;

    public Consumer(Account account, int time, int max){
        this.account = account;
        this.time = time;
        this.max = max;
    }


    @Override
    public void run() {
        while (true){
            int amount = (int) (Math.random() * max);
            synchronized (account) {
                if (account.collect(amount))
                    System.out.println("Prelevati " + amount + "E");
                else
                    System.out.println("Impossibile prelevare");
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
