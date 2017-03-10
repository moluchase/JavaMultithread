package chapterThree.waitInterruptException;

/**
 * Created by Administrator on 2017/3/4.
 */
public class ThreadB extends Thread {
    private Object lock;
    public ThreadB(Object lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("ThreadB start");
        }

    }
}
