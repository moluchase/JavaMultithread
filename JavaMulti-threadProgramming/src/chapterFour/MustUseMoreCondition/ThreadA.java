package chapterFour.MustUseMoreCondition;



/**
 * Created by Administrator on 2017/3/5.
 */
public class ThreadA extends Thread {
    private MyService service;
    public ThreadA(MyService service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
