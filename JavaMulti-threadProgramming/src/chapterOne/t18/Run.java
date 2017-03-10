package chapterOne.t18;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Run {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            MyThread1 thread1=new MyThread1();
            //优先级由1到10，NORM_PRIORITY=5
            thread1.setPriority(10);
            thread1.start();

            MyThread2 thread2=new MyThread2();
            thread2.setPriority(1);
            thread2.start();
        }
    }
}
