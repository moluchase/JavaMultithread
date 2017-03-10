package chapterOne.t19;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread=new MyThread();
        //将thread设置为守护线程
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //当这条语句执行完成时，main线程就结束了，就没有线程了，守护线程也会停止
        System.out.println("离开了。。。");
    }
}
