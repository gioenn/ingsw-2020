package it.polimi.ingsw2020.ex4;

import it.polimi.ingsw2020.ex3.Square;

import java.util.Iterator;
import java.util.LinkedList;

public class GenericStack<E> implements Iterable<E> {

    protected LinkedList<E> data = new LinkedList<>();
    private int size;

    public GenericStack(int size){
        this.size = size;
    }

    public void push(E elem) throws OutOfSpaceException {
        if (data.size() == size)
            throw new OutOfSpaceException();
        data.addFirst(elem);
    }

    public E pop()  {
        if (data.size() == 0)
            throw new OutOfDataException();
        return data.removeFirst();
    }

    @Override
    public Iterator<E> iterator() {
        System.out.println("ITERATOR");
        return new StackIterator();
    }


    private class StackIterator implements Iterator<E>{

        private int idx = 0;

        @Override
        public boolean hasNext() {
            System.out.println("HAS NEXT");
            return idx < data.size();
        }

        @Override
        public E next() {
            System.out.println("NEXT");
            return data.get(idx++);
        }
    }

    public static void main(String[] args) throws OutOfSpaceException {
        GenericStack<String> s = new GenericStack<>(5);
        s.push("A");
        s.push("B");
        System.out.println(s.pop());
        System.out.println(s.pop());
        GenericStack<Square> s1 = new GenericStack<>(5);
        s1.push(new Square(3));

        System.out.println("Iterator:");
        s.push("C");
        s.push("D");
        s.push("E");
        s.pop();


        Iterator<String> i = s.iterator();
        while(i.hasNext())
            System.out.println(i.next());


        for(String elem : s){
            // codice utente
            System.out.println(elem);
        }

        /* compilato in
        for(Iterator<String> i = s.iterator(); i.hasNext(); ){
            String elem = i.next();
            // codice utente
            ...
        }
        */
    }


}
