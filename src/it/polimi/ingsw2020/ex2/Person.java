package it.polimi.ingsw2020.ex2;

import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(birthday, person.birthday);
    }


    @Override
    public int compareTo(Person p) {
        int c1 = surname.compareTo(p.surname);
        int c2 = name.compareTo(p.name);
        if(c1 > 0 || (c1 == 0 && c2 > 0))
            return 1;
        else if(c1 == 0 && c2 == 0)
            return 0;
        return -1;
    }
}
