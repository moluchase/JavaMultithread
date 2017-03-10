package chapterOne.t12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyThread extends Thread{
    FileOutputStream fo;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        for(int i=0;i<500000;i++){
            try {
                fo=new FileOutputStream("console.txt",true);
                fo.write(i+1);
                System.out.println(i+1);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            fo.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
