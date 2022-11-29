package Ticket;

public class Main {
    private static final int TICKET_NUM = 15; //티켓 개수 정의
    public static void main(String[] args) {
        TicketManager mgr = TicketManager.getTicketManager();
        mgr.setTicketLimits(5); //최대 티켓 개수
        UserThread[] user = new UserThread[TICKET_NUM];

        for(int i = 0; i<TICKET_NUM; i++) {
            user[i] = new UserThread((i + 1) + "-thread");
            user[i].start(); //스레드 실행
        }

        for(int i = 0; i<TICKET_NUM; i++) {
            try { //예외처리 부분
                user[i].join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i< TICKET_NUM; i++) { //결과 출력 부분
            if (user[i].getMyTicket().getTicketNum() != 0) //티켓 번호가 0번이 아니라면
                System.out.println("Consumer" + i +" get ticket" + user[i].getMyTicket().getTicketNum()); //결과 출력
        }
    }
}
