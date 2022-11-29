package Print;

public class HdPrinter implements ReceiptPrinter {
    @Override
    public void print(String toString) {
        System.out.println(toString);
    }
}
