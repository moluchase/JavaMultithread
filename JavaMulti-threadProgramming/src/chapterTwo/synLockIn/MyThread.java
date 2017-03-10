package chapterTwo.synLockIn;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread extends Thread {
    private  Sub sub;
    public MyThread(Sub sub){
        this.sub=sub;
    }

    @Override
    public void run() {
        super.run();
        sub.operateISubMethod();
    }
}
