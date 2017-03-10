package chapterFour.reentranttest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/5.
 */
public class MyService {
    private Lock lock=new ReentrantLock();//创建锁对象，和synchronized的效果一样，
    private Condition condition=lock.newCondition();//获取对象监视器，可以理解为锁对象
    public void await(){
        try{
            lock.lock();
            System.out.println("A");
            condition.await();//相当于wait()，抛中断异常
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        try{
            lock.lock();
            System.out.println("signal时间为"+System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
