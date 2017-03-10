package chapterFour.MustUseMoreCondition;

/**
 * Created by Administrator on 2017/3/5.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service=new MyService();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.singalAll_A();//只会唤醒由condtionA等待的线程
    }
}
