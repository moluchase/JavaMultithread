package chapterSix;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MyObject {
    private volatile static MyObject myObject;
    public static MyObject getInstance(){
        try{
            if(myObject!=null){
                //
            }else{
                Thread.sleep(3000);//模拟创建对象的准备性工作
                synchronized (MyObject.class){
                    //再次判断是为了保证可能有多个线程停在上面一步，为了确保只new一个实例；
                    //可能当该线程第一次if时为null，在sleep过程中，刚好已经有线程new实例了，需要再次判断
                    if(myObject==null){
                        myObject=new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
