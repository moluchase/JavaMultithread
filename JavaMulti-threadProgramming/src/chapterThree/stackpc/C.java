package chapterThree.stackpc;

/**
 * Created by Administrator on 2017/3/5.
 */
public class C {
    private MyStack myStack;
    public C(MyStack myStack){
        super();
        this.myStack=myStack;
    }
    public void popService(){
        System.out.println("pop="+myStack.pop());
    }
}
