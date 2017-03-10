package chapterFour.test2;



/**
 * Created by Administrator on 2017/3/5.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final Service service=new Service();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                service.serviceMethod1();
            }
        };
        Thread[] threads=new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    service.serviceMethod2();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(200);
        System.out.println("有线程数 "+service.lock.getQueueLength());
    }
}
