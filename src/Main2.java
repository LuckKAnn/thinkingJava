import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @FileName: Main2
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/8/13 16:21
 */
public class Main2 {


    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(200);
        SynchronousQueue<Integer> queue1 = new SynchronousQueue<>();

        queue1.put(1);
    }
}
