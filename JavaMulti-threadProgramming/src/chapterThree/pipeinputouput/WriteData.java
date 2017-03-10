package chapterThree.pipeinputouput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2017/3/5.
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out){
        try{
            System.out.println("write:");
            for(int i=0;i<300;i++){
                String outData=""+(i+1);
                out.write(outData.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
