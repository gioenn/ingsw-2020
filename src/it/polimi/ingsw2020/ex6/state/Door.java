package it.polimi.ingsw2020.ex6.state;

public class Door implements DoorI {

    private DoorState state;

    public Door() {
        state = new ClosedState(this);
    }

    public void setState(DoorState state){
        this.state = state;
    }

    @Override
    public void complete() {
        state.complete();
    }

    @Override
    public void touch() {
        state.touch();
    }

    @Override
    public void timeout() {
        state.timeout();
    }

    public static void main(String[] args){
        Door door = new Door();
        door.touch();
        door.touch();
        door.touch();
        door.complete();
    }

}
