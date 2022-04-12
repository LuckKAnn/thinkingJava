import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/**
 * @author : LuckKAnn
 * @date : 17:55 2021/9/17
 * @email: 1546165200@qq.com
 */

public class VolatileTest {
    private static volatile int num = 0;
    // private static  int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num=010;
            System.out.println("数据设置完成");
        }).start();
        System.out.println("等待数据");
        while (num==0){
        //为什么这一行不能有代码逻辑
        }
        System.out.println("结束等待");

    }

}
