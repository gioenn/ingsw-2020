package it.polimi.ingsw2020.ex6.decorator;

public class AdminResponsability extends Responsability {

    public AdminResponsability(Employee decorated, String office) {
        super(decorated, office);
    }

    @Override
    protected String getResponsabilityDescription() {
        return "admin";
    }
}
