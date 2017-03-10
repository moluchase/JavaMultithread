package chapterFive.RunTimerDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/3/6.
 * 测试scheduleAtFixedRate
 */
public class Run3 {
    private static Timer timer = new Timer();
    private static int runCount = 0;

    static public class MyTask1 extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("1 begin 运行了！ " + new Date());
                Thread.sleep(3000);
                System.out.println("1 end 结束了" + new Date());
                runCount++;
                if (runCount >= 5) {
                    timer.cancel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            MyTask1 task1=new MyTask1();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("time： " + sdf.format(new Date()));
            String dateString = "2017-3-06 15:05:00";
            Date date = sdf.parse(dateString);
            timer.scheduleAtFixedRate(task1,date,2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
