package chapterTwo.synNotExtends;

/**
 * Created by Administrator on 2017/3/3.
 */
public class Test {
    public static void main(String[] args) {
        Sub sub=new Sub();
        MyThreadA a=new MyThreadA(sub);
        a.setName("A");
        a.start();
        MyThreadB b=new MyThreadB(sub);
        b.setName("B");
        b.start();
    }
}
