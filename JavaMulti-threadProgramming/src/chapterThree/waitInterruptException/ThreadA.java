package chapterThree.waitInterruptException;



/**
 * Created by Administrator on 2017/3/4.
 */
public class ThreadA extends Thread {
    private Object lock;
    public ThreadA(Object lock){
        super();
        this.lock=lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.testMethod(lock);
        System.out.println("start threada run.....");
    }
}
