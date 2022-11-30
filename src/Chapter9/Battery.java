package Chapter9;

public class Battery extends Subject{
    private int level=100;
    public void consume(int amount){
        level-=amount;
        notifyObserver();
    }

    public int getLevel(){
        return level;
    }
}
