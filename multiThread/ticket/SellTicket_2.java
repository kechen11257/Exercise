package multiThread.ticket;

/*
使用多线程，模拟3个窗口同时售票100张票

改进：使用同步机制，将锁加在方法上
 */

public class SellTicket_2 {

    public static void main(String[] args) {
        SellTicket02 sellTicket01 = new SellTicket02();
        SellTicket02 sellTicket02 = new SellTicket02();
        SellTicket02 sellTicket03 = new SellTicket02();

        Thread thread01 = new Thread(sellTicket01);
        Thread thread02 = new Thread(sellTicket02);
        Thread thread03 = new Thread(sellTicket03);

        thread01.start();  //第1个线程窗口
        thread02.start();  //第2个线程窗口
        thread03.start();  //第3个线程窗口
    }
}

//使用synchronized实现线程同步
class SellTicket02 implements Runnable{

    private static int ticketNum = 100;
    private static boolean loop = true;

    public synchronized void sell(){ //同步方法，在同一个时刻只能有一个线程来执行sell方法
        if(ticketNum == 0){
            System.out.println("售票结束");
            loop = false;
            return;
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出了1张票" + "剩余票数" +  (--ticketNum));
    }

    @Override
    public void run() {
        while(loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sell();

        }

    }
}