package chapterTwo.synLockIn;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Main {
    public int i=10;
    synchronized public void operateIMainMethod(String s){
        try{
            i--;
            System.out.println("main print i="+i+s);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
