package it.polimi.ingsw2020.ex1;

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

    public void push(int n){
        if (cur < data.length)
            data[cur++] = n;
    }

    public int pop(){
        if (cur > 0){
            return data[--cur];
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.pop();
        System.out.println(s.pop());
    }

}
