package it.polimi.ingsw2019.ex5;

public class PI implements Runnable {

    private Buffer[] buff;
    private String[] commands;

    PI(Buffer[] b, String[] commands){
        buff = b;
        this.commands = commands;
    }


    // commands are provided in the form ["i,ch", ...]
    @Override
    public void run() {
        for (int i = 0; i < commands.length; i++){
            String command = commands[i];
            int bufferIndex = Integer
                    .parseInt(String.valueOf(command.charAt(0)));
            char c = command.charAt(2);
            buff[bufferIndex].put(c);
            System.out.println("Inserted char "+c+" in buffer "+bufferIndex);
        }
    }

}
