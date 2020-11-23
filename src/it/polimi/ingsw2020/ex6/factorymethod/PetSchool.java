package it.polimi.ingsw2020.ex6.factorymethod;

import java.util.ArrayList;
import java.util.List;

abstract public class PetSchool {

    List<Pet> pets;

    static final int N = 50;

    public PetSchool(/* String petType */){
        pets = new ArrayList<>();
        for (int i = 0; i < N; i++){
            pets.add(createStudent());
        }
    }

    abstract protected Pet createStudent();


    /* ANTIPATTERN 1
    if (petType.equals("cat"))
        pets.add(new Cat());
    else if(petType.equals("dog"))
        pets.add(new Dog());
     ...
     */
    /* ANTIPATTERN 2
    if (this instanceof DogSchool)
        pets.add(new Dog());
    else if (this instanceof CatSchool)
        pets.add(new Cat());
     */

}
