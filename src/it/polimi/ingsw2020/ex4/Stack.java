package it.polimi.ingsw2020.ex4;

public class Stack {

    private int data[];
    private int cur;

    public Stack(int size){
        cur = 0;
        data = new int[size];
    }

    public Stack(){
        this(10);
    }

    public void push(int n) throws OutOfSpaceException {
        if (cur == data.length)
            throw new OutOfSpaceException();
        data[cur++] = n;
    }

    public int pop()  {
        if (cur > 0){
            return data[--cur];
        }
        else throw new OutOfDataException();
    }

    public static void main(String[] args){
        Stack s = new Stack(1);
        try {
            s.push(10);
            System.out.println("Push 1");
            s.push(20);
            System.out.println("Push 2");
            s.push(30);
            System.out.println("Push 3");
        } catch (OutOfSpaceException e) {
            // gestisco l'eccezione
            System.out.println("Errore");
        }

        try {
            test(s);
        }
        catch (OutOfDataException e){
            System.out.println("Errore 2");
        }
        System.out.println("Continuo...");
    }

    public static void test(Stack s) {
        s.pop();
        System.out.println("Pop 1");
        s.pop();
        System.out.println("Pop 2");
        s.pop();
        System.out.println("Pop 3");
    }
}
