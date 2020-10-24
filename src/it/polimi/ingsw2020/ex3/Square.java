package it.polimi.ingsw2020.ex3;

public class Square extends Rectangle {

    public Square(float edge){
        super(edge, edge);
    }

    @Override
    public String getName() {
        return "Quadrato";
    }
}
