package Chpater12;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private List<ElevatorController> controllers;
    private ThroughtputScheduler scheduler;

    private ElevatorManager(int controllerCount){
        controllers = new ArrayList<ElevatorController>(controllerCount);
        for(int i=0;i<controllerCount;i++){
            ElevatorController controller=new ElevatorController(i);
            controllers.add(controller);
        }
        scheduler=new ThroughtputScheduler();
    }

    void requestElevator(int destination,Direction direction){
        int selectedElevator = scheduler.selectedElevator(this, destination, direction);
    }
}
