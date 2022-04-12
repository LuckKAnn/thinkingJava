import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author : LuckKAnn
 * @date : 20:06 2021/9/21
 * @email: 1546165200@qq.com
 */
public class TestCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            count+=i;
            TimeUnit.MILLISECONDS.sleep(110);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        TestCallable testCallable = new TestCallable();
        new Thread(new FutureTask<>(testCallable),"A").start();
        // testCallable.call();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("main结束");
        System.out.println();
    }
}
