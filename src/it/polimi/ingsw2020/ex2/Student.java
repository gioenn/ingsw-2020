package it.polimi.ingsw2020.ex2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person  {

    private static int idGen = 0;
    public final static int GRADUATION_CREDITS = 180;

    private final int id;
    private List<Grade> grades = new ArrayList<>();

    public Student(String name, String surname, Date birthday) {
        super(name, surname, birthday);
        id = idGen++;
    }

    public int getId() {
        return id;
    }

    public int getTotalCredits(){
        int credits = 0;
        for(Grade g : grades)
            credits += g.getCredits();
        return credits;
    }

    public boolean canGraduate(){
        /*
        int credits = getTotalCredits();
        if (credits >= GRADUATION_CREDITS)
            return true;
        return false;
         */
        return getTotalCredits() >= GRADUATION_CREDITS;
    }

    public double getWeightedAverage(){
        double res = 0;
        for(Grade g : grades)
            res += g.getPoints()*g.getCredits();
        return res/getTotalCredits();
    }

    @Override
    public String toString() {
        return "Student "+getId();
    }

    @Override
    public int compareTo(Person p) {
        int i = super.compareTo(p);
        if (i != 0)
            return i;
        else if (p instanceof Student) {
            Student s = (Student) p;
            Integer sId = id;
            return sId.compareTo(s.id);
        }
        return 0;
    }



}
