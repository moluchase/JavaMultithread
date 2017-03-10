package chapterTwo.synNotExtends;



/**
 * Created by Administrator on 2017/3/3.
 */
public class Sub extends Main {
    @Override
    public void serviceMethod() {
        try{
            System.out.println("int sub 下一步 sleep begin threadName="
                    +Thread.currentThread().getName()+" time="
                    +System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int sub 下一步 sleep end threadName="
                    +Thread.currentThread().getName()+" time="
                    +System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
