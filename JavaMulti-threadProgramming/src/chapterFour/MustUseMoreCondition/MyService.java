package chapterFour.MustUseMoreCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/5.
 */
public class MyService {
    private Lock lock=new ReentrantLock();
    //获取多个对象监视器
    public Condition conditionA=lock.newCondition();
    public Condition conditionB=lock.newCondition();
    public void awaitA(){
        try{
            lock.lock();
            System.out.println("begin awaitA"+System.currentTimeMillis());
            conditionA.await();
            System.out.println("end awaitA"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try{
            lock.lock();
            System.out.println("begin awaitB"+System.currentTimeMillis());
            conditionB.await();
            System.out.println("end awaitB"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void singalAll_A(){
        try{
            lock.lock();
            System.out.println("signalAll_A "+System.currentTimeMillis());
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){
        try{
            lock.lock();
            System.out.println("signalALL_B"+System.currentTimeMillis());
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
