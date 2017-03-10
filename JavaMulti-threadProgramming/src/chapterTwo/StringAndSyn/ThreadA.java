package chapterTwo.StringAndSyn;



/**
 * Created by Administrator on 2017/3/4.
 */
public class ThreadA extends Thread {

    private Service service;
    public ThreadA(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run() {
        service.print("aa");
    }
}
