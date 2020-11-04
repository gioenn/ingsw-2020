package it.polimi.ingsw2019.ex5;

public class PO implements Runnable {

    private Buffer[] buff;

    public PO(Buffer[] b){
        this.buff = b;
    }

    @Override
    public void run() {
        while(true){
            for(int i = 0; i < buff.length; i++){
                System.out.println("Buffer "+i+": "+buff[i].get());
            }
        }

    }

}
