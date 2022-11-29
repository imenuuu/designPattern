package Chapter10;

/*
public abstract class Motor {
    protected Door door;
    private MotorStatus motorStatus;

    public Motor(Door door) {
        this.door = door;
        motorStatus=MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    protected void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus=motorStatus;
    }
    public void move(Direction direction) {
        MotorStatus status = getMotorStatus();

        if(getMotorStatus() == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();

        if(doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

    // 훅 메서드
    protected abstract void moveMotor(Direction direction);
}

)
 */