package chapterThree.ThreadLocak11;

/**
 * Created by Administrator on 2017/3/5.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadA a=new ThreadA();
        ThreadB b=new ThreadB();

        b.start();
        //虽然t1为静态变量，但是每个线程进行set时，该对象会为每个线程开启一个空间来存放在该线程中的值
        Tools.t1.set("Main");
        Tools.t1.set("Main2");

        a.start();
        Thread.sleep(1000);
        //会获取最近的一次set的值，并返回
        System.out.println("Main:  "+Tools.t1.get());
    }
}
