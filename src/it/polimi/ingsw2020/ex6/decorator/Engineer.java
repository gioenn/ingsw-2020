package it.polimi.ingsw2020.ex6.decorator;


public class Engineer implements Employee {

    private String name;
    private String office;

    public Engineer(String name, String office){
        this.name = name;
        this.office = office;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOffice() {
        return office;
    }

    @Override
    public String getDescription() {
        return "Eng. "+name+" based at office "+office;
    }

    public static void main(String[] args){
        Employee e = new Engineer("Giovanni", "Cremona");
        e = new AdminResponsability(new PMResponsability(e, "Milano"), "Pavia");
        e = new PMResponsability(e, "Lecco");

        System.out.println(e.getDescription());
    }

}
