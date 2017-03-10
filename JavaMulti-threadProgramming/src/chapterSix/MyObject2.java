package chapterSix;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/3/6.
 */
public enum MyObject2 {
    connectionFactory;//枚举变量

    private Connection connection;//枚举变量的属性

    private MyObject2(){
        //在此处完成属性的赋值
        //connection=.....
    }
    //返回该属性
    public Connection getConnection(){
        return connection;
    }
}
