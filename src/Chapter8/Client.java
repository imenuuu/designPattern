package Chapter8;

interface Command{
    abstract public void execute();
}
class Button {
    private Command theCommand;

    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }
    // 버튼이눌리면주어진Command의execute 메서드를호출함

    public void pressed() {
        theCommand.execute();
    }
}
class Lamp{
    public void turnOn(){
        System.out.println("Lamp On");
    }
}
class LampOnCommand implements Command { // 램프를켜는기능의캡슐화
    private Lamp theLamp;
    public LampOnCommand(Lamp theLamp) {
        this.theLamp= theLamp;
    }

    public void execute() { theLamp.turnOn() ; }}
class Alarm {
    public void start() {
        System.out.println("Alarming...") ;}
}

class AlarmOnCommand implements Command { // 알람을울리는기능의캡슐
    private Alarm theAlarm;
    public AlarmOnCommand(Alarm theAlarm) {
        this.theAlarm= theAlarm;
    }
    public void execute() {
        theAlarm.start() ;
    }}

public class Client {
    public static void main(String[] args) {
        Lamp lamp= new Lamp() ;
        Command lampOnCommand= new LampOnCommand(lamp) ;
        Button button1 = new Button(lampOnCommand) ; // 램프를켜는기능을설정함
        button1.pressed() ;


        Alarm alarm= new Alarm() ;Command alarmOnCommand= new AlarmOnCommand(alarm) ; // 알람을울리는기능을설정함
        Button button2 = new Button(alarmOnCommand);
        button2.pressed() ;
        button2.setCommand(lampOnCommand); // 램프를켜는기능으로변경button2.pressed()
    }
}
