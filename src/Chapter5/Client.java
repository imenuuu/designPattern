package Chapter5;

interface MovingStrategy {
    public void move();
}
interface AttackStrategy {
    public void attack();
}
class FlyingStrategy implements MovingStrategy {
    public void move(){
        System.out.println("I can fly");
    }
}
class WalkingStrategy implements MovingStrategy {
    public void move(){
        System.out.println("walk");
    }
}
class PunchStrategy implements AttackStrategy {
    public void attack(){
        System.out.println("punch");
    }
}
class MissileStrategy implements AttackStrategy {
    public void attack(){
        System.out.println("missile");
    }
}

abstract class Robot {
    private String name;
    private AttackStrategy attackStrategy;
    private MovingStrategy movingStrategy;

    public Robot(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void move(){
        movingStrategy.move();
    }
    public void attack(){
        attackStrategy.attack();
    }
    public void setMovingStrategy(MovingStrategy movingStrategy){
        this.movingStrategy = movingStrategy;
    }
    public void setAttackStrategy(AttackStrategy attackStrategy){
        this.attackStrategy = attackStrategy;
    }
}

class Atom extends Robot {
    public Atom(String name){
        super(name);
    }
}
class TaekwonV extends Robot {
    public TaekwonV(String name){
        super(name);

    }
}

public class Client {
    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("TaekwonV");
        Robot atom = new Atom("Atom");

        taekwonV.setMovingStrategy(new WalkingStrategy());
        taekwonV.setAttackStrategy(new MissileStrategy());

        atom.setMovingStrategy(new FlyingStrategy());
        atom.setAttackStrategy(new PunchStrategy());

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();
    }
}