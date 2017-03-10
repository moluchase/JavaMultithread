package chapterTwo.t10;

/**
 * Created by Administrator on 2017/3/4.
 */
public class Run {
    public static void main(String[] args) {
        PrintString printString=new PrintString();
        new Thread(printString).start();
        System.out.println("stop this"+Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
