package it.polimi.ingsw2020.ex6.state;

public class OpenState extends DoorState {
    public OpenState(Door door) {
        super(door);
        System.out.println("Door is open...");
    }

    @Override
    public void timeout() {
        door.setState(new ClosingState(door));
    }

    @Override
    public void touch() {
        door.setState(new StayOpenState(door));
    }
}