public class CreatureTest {

    public static void main(String[] args) {
        Creature[] creatures = { new Boat("타이타닉"), new Car("람보르기니"), new Duck("도널드")};

        for (Creature creature : creatures) {
            System.out.println(creature.getName());
            System.out.println(creature);

            System.out.print("Vehicle? ");
            if (creature instanceof Vehicle)
                ((Vehicle) creature).board();
            else
                System.out.println("No.");

            System.out.print("Floatable on water? ");
            if (creature instanceof IFloatable)
                ((IFloatable) creature).floatOnWater();
            else
                System.out.println("No.");

            System.out.print("Runnable on the ground? ");
            if (creature instanceof IRunnableOnGround)
                ((IRunnableOnGround) creature).run();
            else
                System.out.println("No.");

            System.out.println("End of Iteration" + "\n");
        }
    }



}
class Boat extends Creature implements Vehicle,IFloatable  {

    private final String name;

    public String getName() {
        return name;
    }


    public Boat(String name) {
        this.name = name;
    }

    public String toString() {
        return "Boat "+name;
    }

    public void floatOnWater() {
        System.out.println("Boat "+getName()+" can float on water");
    }

    public void board() {
        System.out.println("Many people can board Boat "+getName());
    }
}

abstract class Creature {
    private String name;

    public String getName() {
        return name;
    }

}

class Car extends Creature implements IRunnableOnGround,Vehicle {
    private final String name;

    public String getName() {
        return name;
    }

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Car "+getName()+" can run on the ground");
    }

    public void board()  {
        System.out.println("A small number of people can board Car "+getName());
    }

    public String toString() {
        return "Car "+name;
    }
}
class Duck extends Creature implements IRunnableOnGround,IFloatable{



    private final String name;

    public String getName() {
        return name;
    }

    public Duck(String name) {
        this.name = name;
    }


    public String toString() {
        return "Duck "+name ;
    }

    public void floatOnWater() {
        System.out.println("Duck "+getName()+" can float on water");
    }

    public void run() {
        System.out.println("Duck "+getName()+" can run on the ground");
    }
}

interface IFloatable {
    void floatOnWater();
}

interface IRunnableOnGround {
    void run();
}

interface Vehicle {
    void board();
}
