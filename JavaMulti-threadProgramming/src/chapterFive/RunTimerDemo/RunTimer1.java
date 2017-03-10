package chapterFive.RunTimerDemo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/3/6.
 */
public class RunTimer1 {
    private static Timer timer=new Timer(true);//传进去的参数为true，表示timer为守护线程，即非守护线程只要一执行完，守护线程不管执行到哪都会退出
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("has run"+new Date());
        }
    }

    public static void main(String[] args) {
        try{
            MyTask task=new MyTask();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("time： "+sdf.format(new Date()));
            String dateString="2015-10-12 12:05:00";
            Date date=sdf.parse(dateString);
            //在指定的时间date下执行task中的run()方法，
            // 如果指定的时间早于当前的时间，立刻执行task中的run方法
            //如果task为守护线程，当非守护线程执行完后，会立马退出不再执行
            timer.schedule(task,date);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("------");
        }
    }
}
