package it.polimi.ingsw2020.ex3;

import java.util.List;

abstract public class Polygon {

    public abstract float getPerimeter();
    public abstract String getName();

    public static void printPolygon(Polygon p){
        System.out.println("Il perimetro del "+p.getName()+" è "+p.getPerimeter());
    }

    public static void printPolygons(Polygon[] ps){
        for(Polygon p : ps)
            printPolygon(p);
    }

    public static void main(String args[]){
        Square s = new Square(5);
        Triangle t = new Triangle(1,2,3);
        Rectangle r = new Rectangle(3, 4);

        Polygon[] ps = {s, t, r};

        printPolygons(ps);

    }

}
