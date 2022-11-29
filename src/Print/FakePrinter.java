package Print;

public class FakePrinter implements ReceiptPrinter{
    private String s;
    @Override
    public void print(String s){
        this.s=s;
    }

    public String getReceiptContents(){
        return s;
    }
}
