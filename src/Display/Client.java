package Display;

abstract class Display{
    public abstract void draw();
}
class RoadDisplay extends Display{
    @Override
    public void draw() {
        System.out.println("기본도로 표시");
    }
}
abstract class DisplayDecorator extends Display{
    private Display decoratedDisplay;

    public DisplayDecorator(Display display){
        this.decoratedDisplay=display;
    }

    @Override
    public void draw() {
        decoratedDisplay.draw();
    }
}

class LaneDecorator extends DisplayDecorator{

    public LaneDecorator(Display display) {
        super(display);
    }
    public void draw(){
        super.draw();
        drawLane();
    }
    public void drawLane(){
        System.out.println("\t차선 표시");
    }
}
class TrafficDecorator extends DisplayDecorator{

    public TrafficDecorator(Display display) {
        super(display);
    }
    public void draw(){
        super.draw();
        drawTraffic();
    }

    public void drawTraffic() {
        System.out.println("\t교통량 표시");
    }
}
public class Client {
    public static void main(String[] args) {
        Display road=new RoadDisplay();
        Display roadWithLaneWithTraffic=new LaneDecorator(new TrafficDecorator(road));
        roadWithLaneWithTraffic.draw();
    }
}
