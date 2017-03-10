package chapterTwo.t9;

/**
 * Created by Administrator on 2017/3/4.
 */
public class MyService {
    public MyOneList addServiceMethod(MyOneList list,String data){
        try{
            synchronized (list){
                if(list.getSize()<1){
                    Thread.sleep(2000);//这个是模拟远程访问数据
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
