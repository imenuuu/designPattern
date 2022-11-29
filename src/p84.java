abstract class Animal{
    public abstract void printName();

    public void ride() {
    }
}

class Cat extends Animal{
    public void printName(){
        System.out.println("고양이");
    }
}
class Dog extends Animal{
    public void printName(){
        System.out.println("개");
    }
}
class Lion extends Animal{
    public void printName(){
        System.out.println("사자");
    }
    public void ride(){
        System.out.println("사자 타보았니? 타보지 않았으면 말을 하지마!");
    }
}
class Snake extends Animal{
    public void printName(){
        System.out.println("뱀");
    }
}
public class p84 {
    public static void main(String[] args) {
        Animal[] animals= {new Cat(),new Dog(),new Lion(), new Snake()};
        ((Cat)animals[0]).printName();
        ((Dog)animals[1]).printName();
        ((Lion)animals[2]).printName();
        ((Lion)animals[2]).ride();
        animals[3].printName();


    }
}
