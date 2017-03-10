package chapterThree.wait_notify_insert_test;

/**
 * Created by Administrator on 2017/3/5.
 */
public class DBTools {

    volatile private static boolean prevIsA=false;
    synchronized public void backupA(){
        try{
            while(prevIsA==false){
                wait();
            }
            System.out.println("**********"+Thread.currentThread().getName());
            prevIsA=false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){
        try{
            while(prevIsA==true){
                wait();
            }
            System.out.println("&&&&&&&&&&"+Thread.currentThread().getName());
            prevIsA=true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
