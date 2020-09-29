package it.polimi.ingsw2020.ex1;

public class Point {

    private float x;
    private float y;

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p){
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }

    public static void main(String[] args){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        double d = p1.distance(p2);
        System.out.println(d);
    }
}
