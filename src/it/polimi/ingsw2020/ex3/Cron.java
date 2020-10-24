package it.polimi.ingsw2020.ex3;

import java.util.Date;

public class Cron {

    private final int NUM_ACTIONS = 10;
    private DateAction[] todo = new DateAction[NUM_ACTIONS];
    private boolean[] done = new boolean[NUM_ACTIONS];

    public Cron(){
       for(int i=0; i < NUM_ACTIONS; i++)
           done[i] = false;
    }

    public void addDateAction(DateAction da){
        for(int i = 0; i < NUM_ACTIONS; i++){
            if (todo[i] == null){
                todo[i] = da;
                done[i] = false;
                break;
            }
        }
    }

    public void start(){
        int i = 0;
        boolean ended = false;

        do {
            Date now = new Date();
            DateAction action = todo[i];

            if(action != null && now.after(action.getWhen()) && !done[i]){
                action.getWhat().execute();
            }

        } while(!ended);
    }
}
