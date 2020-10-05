package it.polimi.ingsw2020.ex2;

import java.util.Date;

public class Person {

    private String name, surname;
    private Date birthday;

    public Person(String name, String surname, Date birthday){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }
}
