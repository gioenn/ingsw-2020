package it.polimi.ingsw2020.ex5;

public class Plant implements Runnable {

    private enum State {
        OK, STOPPED, BUSY
    }

    private State state;

    public Plant(){
        state = State.OK;
    }

    @Override
    public void run() {
        while(state != State.STOPPED){
            System.out.println("Working...");
            while(Math.random() <= 0.8){
                System.out.println("Working...");
            }

            System.out.println("Plant is busy...");

            state = State.BUSY;

            Valve valve = new Valve();
            Thread threadValve = new Thread(valve);
            threadValve.start();

            synchronized (valve){
                try {
                    valve.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (valve.getState() == Valve.State.CLOSED){
                System.out.println("Failed");
                state = State.STOPPED;
            }
            else {
                System.out.println("Valve is opened, waiting...");
                try {
                    threadValve.join();
                    state = State.OK;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    state = State.STOPPED;
                }

            }
        }
    }


    public static void main(String[] args){
        new Thread(new Plant()).start();
    }


}
