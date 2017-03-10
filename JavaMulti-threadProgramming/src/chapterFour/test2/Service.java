package chapterFour.test2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/5.
 */
public class Service {
    public ReentrantLock lock=new ReentrantLock();
    public void serviceMethod1(){
        try{
            lock.lock();
            System.out.println("ThreadName="+Thread.currentThread().getName()+"start");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void serviceMethod2(){
        try {
            lock.lock();
            System.out.println("dsdsdsdsd");
        }finally {
            lock.unlock();
        }
    }
}
