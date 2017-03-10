package chapterThree.waitInterruptException;




/**
 * Created by Administrator on 2017/3/4.
 */
public class Test {
    public static void main(String[] args) {
        try{
            Object lock=new Object();
            ThreadA a=new ThreadA(lock);
            a.start();
            Thread.sleep(1000);
            a.interrupt();
//            Service service=new Service();
//            service.synNotifyMethod(lock);
            //Thread.sleep(2000);
            ThreadB b=new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
