package chapterFour.MustUseMoreCondition;



/**
 * Created by Administrator on 2017/3/5.
 */
public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
