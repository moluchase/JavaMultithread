package chapterOne.t17;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        long begintime=System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            //不加yield用时40毫秒，加了之后用时101毫秒
            //当该线程获取CPU时，立马释放CPU，再进行竞争CPU
            this.yield();
            System.out.println("i="+i);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("time:"+(endTime-begintime)+"毫秒");
    }
}
