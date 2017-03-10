package chapterThree.ThreadLocak11;

/**
 * Created by Administrator on 2017/3/5.
 */
public class ThreadB extends Thread {
    @Override
    public void run() {

        try {
            Tools.t1.set("ThreadB");
            Thread.sleep(200);
            System.out.println("ThreadB: "+Tools.t1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
