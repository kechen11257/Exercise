package multiThread.ticket;
    /*
    1。 主线程每隔1秒，输出hi，一共10次
    2。 当输出到hi5时，启动一个子线程（要求实现runnable），每隔1s输出hello，等该线程输出10次hello后，退出
    3。 主线程继续输出hi，直到主线程退出
    */


public class join {
    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        Thread thread = new Thread(t);

        for(int i = 0; i < 10; i++){
            System.out.println("hi" + i);
            thread.sleep(1000);
            if(i == 5){
                thread.start();
                thread.join();
            }
        }

    }
}

class T implements Runnable{

    int count = 0;

    @Override
    public void run() {

        while(true){
            System.out.println("hello" + (count++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count == 10){
                break;
            }
        }
    }
}
