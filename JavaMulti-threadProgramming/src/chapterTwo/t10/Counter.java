package chapterTwo.t10;

/**
 * Created by Administrator on 2017/3/4.
 * 通过加synchronized，防止多个线程同时获取count的值，再进行加1，最后把值再传给count，其效果是count只加了1
 */
public class Counter {
    public static int count =0;
    public void inc(){
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //非静态上下文不能在静态方法中引用
        synchronized (this) {
            count++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        for(int i=0;i<1000;i++){
            new MyThreadCount(counter).start();
        }

        Thread.sleep(1000);
        System.out.println("运行结果："+Counter.count);
    }
}
