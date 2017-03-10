package chapterThree.wait_notify_insert_test;




/**
 * Created by Administrator on 2017/3/5.
 */
public class Run {
    public static void main(String[] args) {
        DBTools dbTools=new DBTools();
        for(int i=0;i<10;i++){
            ThreadA a=new ThreadA(dbTools);
            a.setName("*"+(i+1));
            a.start();
            ThreadB b=new ThreadB(dbTools);
            b.setName("&"+(i+1));
            b.start();
        }
    }
}
