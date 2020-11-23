package it.polimi.ingsw2020.ex6.singleton;

public class LazyPrinterManager {

    private static LazyPrinterManager sharedInstance;

    private LazyPrinterManager(){}

    public synchronized static LazyPrinterManager getSharedInstance() {
        if(sharedInstance == null)
            sharedInstance = new LazyPrinterManager();
        return sharedInstance;
    }
}
