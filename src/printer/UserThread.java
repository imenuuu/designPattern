package printer;

public class UserThread extends Thread {
    private Printer myPrinter;

    public UserThread(String name) {
        super(name);
    }
    public void run() {
        PrintManager mgr = PrintManager.getPrinterManager();
        myPrinter=mgr.getPrinter();
        myPrinter.print(getName());
    }

}

