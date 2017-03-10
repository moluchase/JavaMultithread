package chapterThree.stackpc;

/**
 * Created by Administrator on 2017/3/5.
 */
public class P {
    private MyStack myStack;
    public P(MyStack myStack){
        super();
        this.myStack=myStack;
    }

    public void pushService(){
        myStack.push();
    }
}
