package printer;

import java.util.ArrayList;

public class PrintManager {
    private static PrintManager mgr=null;
    private ArrayList<Printer> managedPrinters=new ArrayList<Printer>();

    private PrintManager(){
        managedPrinters.add(new Printer());
        managedPrinters.add(new Printer());
        managedPrinters.add(new Printer());
    }

    public synchronized static PrintManager getPrinterManager(){
        if(mgr==null){
            mgr=new PrintManager();
        }
        return mgr;
    }

    public synchronized Printer getPrinter(){
        while(true){
            for(Printer printer : managedPrinters){
                if(printer.isAvailable()){
                    printer.setAvailable(false);
                    return printer;
                }
            }
        }
    }
}
