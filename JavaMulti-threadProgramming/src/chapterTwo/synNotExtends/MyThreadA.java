package chapterTwo.synNotExtends;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThreadA extends Thread {
    private Sub sub;
    public MyThreadA(Sub sub){
        this.sub=sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
