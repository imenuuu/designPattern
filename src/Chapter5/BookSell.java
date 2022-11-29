package Chapter5;

import java.util.Date;

class Member{
    private String name;


    private int money;

    public Member(String name) {
        this.name = name;
        money=0;
    }

    public void addMoney(int money) {
        money+=money;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
class Book{
    private String sign;
    private String birth;

    public Book(String sign, String birth, int price) {
        this.sign = sign;
        this.birth = birth;
        this.price = price;
    }

    private int price;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
class Rental{
    private Member member;
    private Book book;
    private PricePolicy pricePolicy;
    int n;

    public Rental(Member member, Book book, PricePolicy pricePolicy, int n) {
        this.member = member;
        this.book = book;
        this.pricePolicy = pricePolicy;
        this.n = n;
        this.member.addMoney(pricePolicy.calcPrice(book.getPrice(), n));
    }


}
interface PricePolicy{
     int calcPrice(int price,int n);
}
class OrdinaryPricePolicy implements PricePolicy{
    public int calcPrice(int price,int n){
        return price*n;
    }
}
class BookDiscountPricePolicy implements PricePolicy{
    public int calcPrice(int price,int n){
        return (int)(price*n*0.95);
    }
}
class MemberDiscountPricePolicy implements PricePolicy{
    public int calcPrice(int price,int n){
        return (int)(price*n*0.9);
    }
}
public class BookSell {
    public static void main(String[] args) {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");
        Member member3 = new Member("member3");

        Book book1=new Book("book1","2004/12/24",1000);
        Book book2=new Book("book2","2002/12/24",1000);
        Book book3=new Book("book3","2003/12/24",1000);

        Rental rental1=new Rental(member1,book2,new OrdinaryPricePolicy(),2);
        Rental rental2=new Rental(member2,book1,new OrdinaryPricePolicy(),3);
        Rental rental3=new Rental(member2,book3,new OrdinaryPricePolicy(),4);
        Rental rental4=new Rental(member1,book2,new OrdinaryPricePolicy(),3);



    }
}
