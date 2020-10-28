package it.polimi.ingsw2020.ex4;

public class StringBufferTest {

    public static void main(String[] args){
        int numChar = 250000;

        System.out.println("Costruisco una string di classe String");

        long b = System.currentTimeMillis();

        String s1 = "";

        for(int i=0; i< numChar; i++)
            s1 += 'a';

        long e = System.currentTimeMillis();

        System.out.println("Il tempo trascorso con String è "+(e-b));

        b = System.currentTimeMillis();

        StringBuffer s2 = new StringBuffer();

        for(int i=0; i< numChar; i++)
            s2.append('a');

        e = System.currentTimeMillis();

        System.out.println("Il tempo trascorso con StringBuffer è "+(e-b));


    }
}
