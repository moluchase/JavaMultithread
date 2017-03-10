package chapterFour.reentranttest;

/**
 * Created by Administrator on 2017/3/5.
 * 使用condition实现等待/通知
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service=new MyService();
        ThreadA a=new ThreadA(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}
