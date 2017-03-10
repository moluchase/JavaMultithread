package chapterTwo.doubleSynBlockOneTwo;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Task {
    synchronized public void otherMethod(){
        System.out.println("-----------run----otherMethod");
    }
    public void doLongTimeTask(){
        synchronized (this){
            for(int i=0;i<10000;i++){
                System.out.println("synchronized threadName="
                        +Thread.currentThread().getName()+"i="+(i+1)
                );
            }
        }
    }
}
