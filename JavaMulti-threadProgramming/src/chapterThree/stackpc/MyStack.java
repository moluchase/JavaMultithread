package chapterThree.stackpc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */
public class MyStack {
    private List list=new ArrayList<>();
    synchronized  public void push(){
        try{
            while(list.size()==1){
                this.wait();
            }
            list.add("anyString="+Math.random());
            this.notify();
            System.out.println("push="+list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String returnValue="";
        try{
            while(list.size()==0){
                System.out.println("poping "+Thread.currentThread().getName()+"wait ...");
                this.wait();
            }
            returnValue+=list.get(0);
            list.remove(0);
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
