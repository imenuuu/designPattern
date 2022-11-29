package Ticket;

public class NormalTicket implements Ticket {
    private int num;

    public NormalTicket(int num) {
        this.num = num;
    }

    public int getTicketNum() {
        return this.num;
    }
}
