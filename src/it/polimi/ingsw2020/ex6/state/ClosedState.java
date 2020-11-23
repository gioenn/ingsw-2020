package it.polimi.ingsw2020.ex6.state;

public class ClosedState extends DoorState {

    public ClosedState(Door d) {
        super(d);
        System.out.println("Door is closed");
    }

    public void touch() {
        door.setState(new OpeningState(door));
    }
}
