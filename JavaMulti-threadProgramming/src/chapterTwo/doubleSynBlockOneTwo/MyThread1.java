package chapterTwo.doubleSynBlockOneTwo;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread1 extends Thread {
    private Task task;
    public MyThread1(Task task){
        super();
        this.task=task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
