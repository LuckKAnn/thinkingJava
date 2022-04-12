import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : LuckKAnn
 * @date : 15:43 2021/9/11
 * @email: 1546165200@qq.com
 */
public class FlipChess {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1,2);
        System.out.println(atomicInteger.get());
        System.out.println();
    }

}
