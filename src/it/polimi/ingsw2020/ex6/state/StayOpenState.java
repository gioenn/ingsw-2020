package it.polimi.ingsw2020.ex6.state;

public class StayOpenState extends DoorState {
    public StayOpenState(Door door) {
        super(door);
        System.out.println("Door should stay open");
    }

    @Override
    public void touch() {
        door.setState(new ClosingState(door));
    }
}