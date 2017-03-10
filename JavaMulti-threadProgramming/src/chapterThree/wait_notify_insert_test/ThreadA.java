package chapterThree.wait_notify_insert_test;

/**
 * Created by Administrator on 2017/3/5.
 */
public class ThreadA extends Thread {
    private DBTools dbTools;
    public ThreadA(DBTools dbTools){
        this.dbTools=dbTools;
    }

    @Override
    public void run() {
            dbTools.backupA();
    }
}
