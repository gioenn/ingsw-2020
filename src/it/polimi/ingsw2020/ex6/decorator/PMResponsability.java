package it.polimi.ingsw2020.ex6.decorator;

public class PMResponsability extends Responsability {

    public PMResponsability(Employee decorated, String office) {
        super(decorated, office);
    }

    @Override
    protected String getResponsabilityDescription() {
        return "project manager";
    }
}
