package chapterThree.ThreadLocak11;



/**
 * Created by Administrator on 2017/3/5.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try{
            Tools.t1.set("ThreadA");
            Thread.sleep(200);
            System.out.println("ThreadA:  "+Tools.t1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
