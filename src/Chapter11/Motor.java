package Chapter11;


public abstract class Motor {
    private Door door;                  // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
        System.out.println("Motor 생성자");
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    // 모터 구동 메서드
    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();

        if (doorStatus == DoorStatus.OPENED) {
            door.close();
            System.out.println("문 닫음");
        }

        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);

    }

    // 각각의 회사 모터에 따라 오버라이드 할 추상 메서드
    protected abstract void moveMotor(Direction direction);
}


