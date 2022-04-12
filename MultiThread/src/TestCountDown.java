import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @FileName: TestCountDown
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/18 10:27
 */
public class TestCountDown {


    private  static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static  CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        cyclicBarrier.await();
        System.out.println("end");
    }
}
