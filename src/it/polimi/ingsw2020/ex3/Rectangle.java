package it.polimi.ingsw2020.ex3;

public class Rectangle extends Polygon {

    private float edge1, edge2;

    public Rectangle(float edge1, float edge2){
        this.edge1 = edge1;
        this.edge2 = edge2;
    }

    @Override
    public float getPerimeter() {
        return 2*(edge1+edge2);
    }

    @Override
    public String getName() {
        return "Rettangolo";
    }
}
