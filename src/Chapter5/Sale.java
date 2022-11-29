package Chapter5;

import java.util.ArrayList;
import java.util.Iterator;

interface ReceiptPrinter{
    public void print(String s);
}

class HD108ReceiptPrinter implements ReceiptPrinter {
    @Override
    public void print(String s) {
        //실제 영수증 출력
    }
}

class FakePrinter implements ReceiptPrinter {

    private String s;

    @Override
    public void print(String s) {
        this.s=s;
    }

    public String getReceiptContens(){
        return s;
    }
}



public class Sale {
    private ArrayList<Item> items = new ArrayList<Item>();
    private ReceiptPrinter printer;

    public void printReceipt(){
        Iterator<Item> itr=items.iterator();
        StringBuffer buf=new StringBuffer();

        while(itr.hasNext()){
            Item item=itr.next();
            buf.append(item.getName());
            buf.append(item.getPrice());
        }
        printer.print(buf.toString());

    }
    public void add(Item item){
        items.add(item);
    }
    public void setReceiptPrinter(ReceiptPrinter printer){
        this.printer=printer;
    }
}

class Item {
    private String name;

    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}