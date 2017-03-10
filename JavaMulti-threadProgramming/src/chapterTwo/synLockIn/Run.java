package chapterTwo.synLockIn;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Run {
    public static void main(String[] args) {
        Sub sub=new Sub();
        MyThread t=new MyThread(sub);
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sub.operateIMainMethod("main线程");
    }
}
