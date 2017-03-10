package chapterThree.stackpc;

/**
 * Created by Administrator on 2017/3/5.
 */
public class P_Thread extends Thread {
    private P p;
    public P_Thread(P p){
        super();
        this.p=p;
    }

    @Override
    public void run() {
        while(true){
            p.pushService();
        }
    }
}
