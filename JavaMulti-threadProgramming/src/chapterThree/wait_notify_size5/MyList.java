package chapterThree.wait_notify_size5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
public class MyList {
    private static List list=new ArrayList();
    public static void add(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}
