package computer;

public class KeyBoard extends ComputerDevice{
    private final int price;
    private final int power;

    //생성자를 통한 값 할당
    public KeyBoard(int price, int power) {
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