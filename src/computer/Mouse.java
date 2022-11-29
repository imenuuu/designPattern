package computer;

public class Mouse extends ComputerDevice{
    private final int price;
    private final int power;

    public Mouse(int price, int power){
        this.price = price;
        this.power = power;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPower() {
        return power;
    }
}