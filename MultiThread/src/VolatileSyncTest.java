import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @FileName: VolatileSyncTest
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/11/6 17:00
 */
public class VolatileSyncTest {

     private  static volatile int  num = 0;

     public static void main(String[] args) throws InterruptedException {
          new Thread(()->{
               for (int i = 0; i < 100000; i++) {
                    num++;
               }
          }).start();
          new Thread(()->{
               for (int i = 0; i < 100000; i++) {
                    num++;
               }
          }).start();

          TimeUnit.SECONDS.sleep(10);

          System.out.println(num);

     }
}
