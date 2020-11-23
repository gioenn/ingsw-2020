package it.polimi.ingsw2020.ex6.factorymethod;

public class CatSchool extends PetSchool {
    @Override
    protected Pet createStudent() {
        return new Cat();
    }
}
