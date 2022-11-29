package Ticket;

public class TicketManager {

    private static TicketManager mgr=null;
    private int limits;// 발행할 수 있는 티켓 수량
    private int count; //현재 발행되어 있는 티켓의 수량

    private TicketManager() {
        count = 0; //티켓 개수 초기화
    }

//한개의 티켓 발행기를 만들고 임계구역을 만들기 위해 동기화
    public synchronized static TicketManager getTicketManager() {
        if (mgr == null) {
            mgr = new TicketManager();
        }
        return mgr;
    }

//최대 티켓 개수
    public synchronized void setTicketLimits(int limits) {
        this.limits = limits;
    }
//발행된 티켓의 수량이 최대치에 도달했는지 확인
    public synchronized Ticket getTicket() {
        if(this.count < this.limits)
            return new NormalTicket(++this.count);
        return new NullTicket();

    }
}
