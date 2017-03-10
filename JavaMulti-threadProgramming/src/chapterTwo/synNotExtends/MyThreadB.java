package chapterTwo.synNotExtends;



/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThreadB extends Thread {
    private Sub sub;

    public MyThreadB(Sub sub){
        this.sub=sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
