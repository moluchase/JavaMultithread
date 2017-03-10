package chapterThree.stackpc;

/**
 * Created by Administrator on 2017/3/5.
 */
public class C_Thread extends Thread {
    private C r;
    public C_Thread(C r){
        super();
        this.r=r;
    }

    @Override
    public void run() {
        while(true){
            r.popService();
        }
    }
}
