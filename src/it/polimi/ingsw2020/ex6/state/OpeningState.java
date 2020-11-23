package it.polimi.ingsw2020.ex6.state;

public class OpeningState extends DoorState{
    public OpeningState(Door d) {
        super(d);
        System.out.println("Opening the door...");
    }

    @Override
    public void complete(){
        door.setState(new OpenState(door));
    }

    @Override
    public void touch(){
        door.setState(new ClosingState(door));
    }

}
