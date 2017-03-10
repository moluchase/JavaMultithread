package chapterTwo.t9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
public class MyOneList {
    private List list=new ArrayList();
    synchronized public void add(String data){
        list.add(data);
    }
    synchronized public int getSize(){
        return list.size();
    }
}
