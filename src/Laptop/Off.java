package Laptop;

public class Off implements PowerState{
    @Override
    public void powerPush() {
        System.out.println("절전모드");
    }
}
