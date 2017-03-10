package chapterThree.waitInterruptException;

/**
 * Created by Administrator on 2017/3/4.
 */
public class Service {
    public void testMethod(Object lock)  {
            synchronized (lock){
                try{
                System.out.println("begin wait()");
                lock.wait();
                System.out.println("end wait()");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("synchronized function");
        }

        System.out.println("interrupted function");
    }
    public void synNotifyMethod(Object lock){
            synchronized (lock){
                System.out.println("start notify");
                lock.notify();
                System.out.println("end notify");
            }
    }
}
