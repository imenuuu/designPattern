package Chapter7;
interface State{
    void on_button_pushed(Light light);
    void off_button_pushed(Light light);
}

class ON implements State{
    private static State instance=new ON();

    public static State getInstance(){
        return instance;
    }
    @Override
    public void on_button_pushed(Light light) {
        System.out.println("ON 메서드 취침등 상태");
        light.setState(SLEEPING.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("ON 메서드 Light Off !");
        light.setState(OFF.getInstance());
    }

}

class OFF implements State{

    private static State instance =new OFF();

    public static State getInstance(){
        return instance;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("OFF 메서드 Light ON !");
        light.setState(ON.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("OFF 메서드 반응 없음");
    }

}
class SLEEPING implements State{
    private static State instance=new SLEEPING();

    public static State getInstance() {
        return instance;
    }

    @Override
    public void on_button_pushed(Light light){
        System.out.println("SLEEPING 메서드 LIGHT ON BACK!!");
        light.setState(ON.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("SLEEPING 메서드 LIGHT OFF BACK!!");
        light.setState(OFF.getInstance());
    }
}
class Light{
    private State state=SLEEPING.getInstance();

    public void setState(State state){
        this.state=state;
    }
    public void on_button_pushed(){
        state.on_button_pushed(this);
    }
    public void off_button_pushed() {
        state.off_button_pushed(this);
    }
}
public class Client {
    public static void main(String[] args) {
        Light light=new Light();
        light.off_button_pushed();
        light.on_button_pushed();
        light.off_button_pushed();
        light.on_button_pushed();
        light.off_button_pushed();
        light.off_button_pushed();
        light.on_button_pushed();
        light.on_button_pushed();
    }
}
