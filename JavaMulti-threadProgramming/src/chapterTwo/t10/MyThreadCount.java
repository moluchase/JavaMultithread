package chapterTwo.t10;

/**
 * Created by Administrator on 2017/3/4.
 */
public class MyThreadCount extends Thread {
    private Counter counter;
    public MyThreadCount(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        counter.inc();
    }
}
