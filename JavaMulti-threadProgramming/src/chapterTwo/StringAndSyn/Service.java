package chapterTwo.StringAndSyn;

/**
 * Created by Administrator on 2017/3/4.
 */
public class Service {

    public static void print(String stringParam){
        try{
            synchronized (stringParam){
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}