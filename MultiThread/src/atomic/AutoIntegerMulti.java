package atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @FileName: AutoIntegerMulti
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/8/14 15:18
 */
class Sources{
    public AtomicInteger num = new AtomicInteger(0);
}
public class AutoIntegerMulti {

    private static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
        Sources sources = new Sources();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    sources.num.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();;
        System.out.println(sources.num);

    }


}
