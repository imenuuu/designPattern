package Chapter6;

class Printer {
    private static Printer instance = null;
    private static int counter = 0;

    private Printer() {}

    public synchronized static Printer getInstance() {
        if (instance == null)
            instance = new Printer();
        return instance;
    }

    public synchronized void print(String str) {
        counter++;
        System.out.println(str + counter);
    }
}

class UserThread extends Thread {
    public UserThread(String name) {
        super(name);
    }
    public void run() {
        Printer printer = Printer.getInstance();
        printer.print(Thread.currentThread().getName() + " print using " + printer.toString() + ".");
    }

}

public class PrinterSingleton {
    private static final int User_NUM = 5;

    public static void main(String[] args) {
        UserThread[] user = new UserThread[User_NUM];
        for (int i = 0; i < User_NUM; i++) {
            user[i] = new UserThread((i + 1) + "-user");
            user[i].start();
        }
    }
}
