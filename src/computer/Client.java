package computer;

public class Client {
    public static void main(String[] args) {
        //컴퓨터 부품으로 keyboard, body, monitor 객체 생성
        KeyBoard keyBoard = new KeyBoard(5, 2); //가격 5, 전력 2
        Mouse mouse = new Mouse(3, 1); //가격 3, 전력 1
        Monitor monitor = new Monitor(30, 20); //가격30, 전력 20
        Body body = new Body(14,10);

        //Computer 객체를 생성하고 addComponent를 통해 부품 객체 설정
        Computer computer = new Computer();
        //아래의 구문을 실행할때는
        //private List<ComputerDevice> components = new ArrayList<ComputerDevice>();
        //가 이미 Computer클래스안에 객체로 만들어져 있기 때문에 addComponent를 하게 되면
        // 생성된 List객체에 값이 하나씩 담아지게 되는 것이다.
        computer.addComponent(keyBoard);
        computer.addComponent(mouse);
        computer.addComponent(monitor);
        computer.addComponent(body);

        //컴퓨터의 가격과 전력 소비량 구하기
        int computerPrice = computer.getPrice();
        int computerPower = computer.getPower();
        System.out.println("컴퓨터 가격 : " + computerPrice+"만 원");
        System.out.println("컴퓨터 전력 : " + computerPower+"W");
    }
}