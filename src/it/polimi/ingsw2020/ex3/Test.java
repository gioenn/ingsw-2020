package it.polimi.ingsw2020.ex3;

public class Test {

    public static void main(String[] args){
        Object o = null;
        if(args[0].equals("1"))
            o = "abc";
        else
            o = 1;
        String s = (String) o;
    }

}
