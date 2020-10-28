package it.polimi.ingsw2020.ex3;

import java.util.Calendar;
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
                done[i] = true;
            }

            if (i == NUM_ACTIONS - 1)
                i = 0;
            else
                i++;

            ended = true;

            for (int k = 0; k < NUM_ACTIONS; k++){
                if(todo[k] != null && !done[k]){
                    ended = false;
                    break;
                }
            }


        } while(!ended);
    }

    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        Date d1 = c.getTime();

        c.add(Calendar.SECOND, 2);
        Date d2 = c.getTime();

        c.add(Calendar.SECOND, 2);
        Date d3 = c.getTime();

        Cron cron = new Cron();

        cron.addDateAction(new DateAction(d1, new PrintAction("Action 1")));
        cron.addDateAction(new DateAction(d2, new PrintAction("Action 2")));
        cron.addDateAction(new DateAction(d3, new PrintAction("Action 3")));

        cron.addDateAction(new DateAction(d3, new Actionable() {
            @Override
            public void execute() {
                for(int i = 0; i < 10; i++){
                    System.out.println(i);
                }
            }
        }));

        cron.start();

    }
}
