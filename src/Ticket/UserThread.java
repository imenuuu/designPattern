package Ticket;

public class UserThread extends Thread{
    private Ticket myTicket;

    public UserThread(String name) {
        super(name);
    }

    public void run() { //스레드 실행 부분
        TicketManager mgr = TicketManager.getTicketManager();
        myTicket = mgr.getTicket();//티켓 구입 요청
    }

    public Ticket getMyTicket() {
        return myTicket;
    }
}
