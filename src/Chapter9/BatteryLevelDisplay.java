package Chapter9;

public class BatteryLevelDisplay implements Observer{

    private Battery battery;

    public BatteryLevelDisplay(Battery battery){
        this.battery = battery;
    }

    @Override
    public void update() {
        int level=battery.getLevel();
        System.out.println("Leve: "+level);
    }
}
