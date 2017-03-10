package chapterOne.t18;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime=System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            //
        }
        long endTiem=System.currentTimeMillis();
        System.out.println("##### MyThread1 :"+(endTiem-beginTime));
    }
}
