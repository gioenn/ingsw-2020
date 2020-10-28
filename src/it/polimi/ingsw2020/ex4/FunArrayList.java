package it.polimi.ingsw2020.ex4;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunArrayList<T> extends ArrayList<T> {

    public <E> ArrayList<E> map(Function<T, E> f) {
        ArrayList<E> res = new ArrayList<>();
        for(T elem : this) {
            res.add(f.apply(elem));
        }
        return res;
    }

    public ArrayList<T> filter(Predicate<T> p){
        ArrayList<T> res = new ArrayList<>();
        for(T elem : this) {
            if(p.test(elem))
                res.add(elem);
        }
        return res;
    }

    public <E> E reduce(BiFunction<E, T, E> f, E initial){
        E res = initial;
        for (T elem : this)
            res = f.apply(res, elem);
        return res;
    }


    public static void main(String[] args){
        var a = new FunArrayList<String>();
        a.add("ABC");
        a.add("D");
        a.add("EFGH");

        var r = a.map((s) -> s.length());
        System.out.println(r);

        var q = a.filter((s) -> s.charAt(0) > 'C');
        System.out.println(q);

        var w = a.reduce((x, y) -> x + y.length(), 0);
        System.out.println(w);



    }

}
