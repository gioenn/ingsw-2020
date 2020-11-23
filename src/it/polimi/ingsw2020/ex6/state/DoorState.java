package it.polimi.ingsw2020.ex6.state;

public abstract class DoorState implements DoorI {
    protected Door door;

    public DoorState(Door d){
        door = d;
    }

    @Override
    public void complete() { }

    @Override
    public void touch() { }

    @Override
    public void timeout() { }
}
