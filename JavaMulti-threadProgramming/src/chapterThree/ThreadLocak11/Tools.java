package chapterThree.ThreadLocak11;

/**
 * Created by Administrator on 2017/3/5.
 */
public class Tools {
    //ThreadLocal解决每个线程绑定自己的值
    //该对象的初始值是null，如果要想使其有初始值，只用重写该类中的initalValue()方法即可
    public static ThreadLocal t1=new ThreadLocal();
}
