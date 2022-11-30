package Chapter9;

public class LowBatteryWarning implements Observer{

    private static final int LOW_BATTERY=30;
    private Battery battery;

    public LowBatteryWarning(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void update() {
        int level= battery.getLevel();
        if(level<LOW_BATTERY){
            System.out.println("<WARNING> LOW BATTERY : "+ level+"Compared with"+LOW_BATTERY);
        }
    }
}
