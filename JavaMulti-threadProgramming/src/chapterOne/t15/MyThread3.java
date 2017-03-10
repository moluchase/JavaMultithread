package chapterOne.t15;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread3 extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            if(this.isInterrupted()){
                return;
            }
        }
    }
}
