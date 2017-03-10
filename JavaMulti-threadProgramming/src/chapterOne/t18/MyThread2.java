package chapterOne.t18;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            //
        }
        long endTime=System.currentTimeMillis();
        System.out.println("@@@@@ MyThread2 :"+(endTime-startTime));
    }
}
