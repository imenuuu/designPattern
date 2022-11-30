package Ticket;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

enum Direction {
    UP, DOWN
}

enum SchedulingStrategyID {
    RESPONSE_TIME, THROUGHPUT, DYNAMIC
}

class ElevatorController {
    private int id;
    private int curFloor;
    public ElevatorController(int id) {
        this.id = id;
        curFloor = 1;
    }
    public void gotoFloor(int destination) {
        System.out.print("Elevator [" + id + "] Floor : " + curFloor);
        curFloor = destination;
        System.out.println(" ==> " + curFloor);
    }
}

interface ElevatorScheduler {
    public int selectElevator(ElevatorManager manager, int destination, Direction direction);
}

class ResponseTimeScheduler implements ElevatorScheduler {
    @Override
    public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
        return 1;
    }
}

class ThroughputScheduler implements ElevatorScheduler {
    @Override
    public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
        return 0;
    }
}

class SchedulerFactory {
    public static ElevatorScheduler getScheduler(SchedulingStrategyID strategyID) {
        ElevatorScheduler scheduler = null;
        switch (strategyID) {
            case RESPONSE_TIME: scheduler = new ResponseTimeScheduler(); break;
            case THROUGHPUT: scheduler = new ThroughputScheduler(); break;
            case DYNAMIC: {
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (hour < 12) scheduler = new ResponseTimeScheduler();
                else scheduler = new ThroughputScheduler();
                break;
            }
        }
        return scheduler;
    }
}

class ElevatorManager {
    private List<ElevatorController> controllers;
    private SchedulingStrategyID strategyID;

    public ElevatorManager(int controllerCount, SchedulingStrategyID strategyID) {
        controllers = new ArrayList<>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i + 1);
            controllers.add(controller);
        }
        setStrategyID(strategyID);
    }

    public void setStrategyID(SchedulingStrategyID strategyID) {
        this.strategyID = strategyID;
    }

    public void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
        System.out.println(scheduler);
        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}

public class Client {
    public static void main(String[] args) {
        ElevatorManager emWithResponseTimeScheduler = new ElevatorManager(2, SchedulingStrategyID.RESPONSE_TIME);
        emWithResponseTimeScheduler.requestElevator(10, Direction.UP);

        ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, SchedulingStrategyID.THROUGHPUT);
        emWithThroughputScheduler.requestElevator(10, Direction.UP);

        ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, SchedulingStrategyID.DYNAMIC);
        emWithDynamicScheduler.requestElevator(10, Direction.UP);
    }
}