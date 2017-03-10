package chapterOne.t15;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        super.run();
        try{
            for (int i=0;i<50000;i++){
                if(this.isInterrupted()){
                    System.out.print("已经停止了");
                    throw new InterruptedException();
                }
                System.out.println("i"+i);
            }
        }catch (InterruptedException e){
            System.out.println("进入catch中了");
        }
    }
}
