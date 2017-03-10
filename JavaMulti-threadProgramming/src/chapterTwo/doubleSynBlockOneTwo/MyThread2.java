package chapterTwo.doubleSynBlockOneTwo;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread2 extends Thread {
    private Task task;
    public MyThread2(Task task){
        super();
        this.task=task;
    }

    @Override
    public void run() {
        super.run();
        task.otherMethod();
    }
}
