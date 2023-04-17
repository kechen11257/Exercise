package multiThread.ticket;

/*
使用多线程，模拟3个窗口同时售票100张票
 */

public class SellTicket {

    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();

        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();
    }
}

class SellTicket01 extends Thread{

    private static int ticketNum = 100;

    @Override
    public void run() {
        while(true){

            if(ticketNum <= 0){
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出了1张票" + "剩余票数" +  (--ticketNum));
        }

    }
}