package mind;

import java.util.concurrent.CountDownLatch;

/**
 * @FileName: PrintUseCountDown
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/18 10:48
 */
public class PrintUseCountDown {

    private static CountDownLatch countDownLatch = new CountDownLatch(1000);
    private  static  int  i=0;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println(i++);
                new Thread(this).start();
            }
        };
      new Thread(runnable).start();

        countDownLatch.await();
        System.exit(0);

    }
}
