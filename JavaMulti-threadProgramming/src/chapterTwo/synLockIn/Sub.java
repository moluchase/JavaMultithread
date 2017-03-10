package chapterTwo.synLockIn;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Sub extends Main {
    synchronized public void operateISubMethod(){
        try{
//            while(i>0){
//                i--;
                System.out.println("sub print i="+0);
                Thread.sleep(2000);
                this.operateIMainMethod("子线程");
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
