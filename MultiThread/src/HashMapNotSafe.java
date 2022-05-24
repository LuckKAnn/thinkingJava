import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @FileName: HashMapNotSafe
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/23 19:22
 */
public class HashMapNotSafe {
    /**
     * HashMap线程不安全的原因
     * 1. hashMap put过程中的modCount，涉及modCount++操作，这个操作不是原子性的，可能导致调用Put方法时计算结果不准确
     * 2. 扩容时的错误，在扩容期间，它会新建一个新的空数组，并且用旧的项填充到这个新的数组中去。所以在扩容的时候，并发的进行读取
     时，可能会获取到null值
     */
    public static void situation02(String[] args) {
        final Map<Integer, String> map = new HashMap<>();

        final Integer targetKey = 0b1111_1111_1111_1111; // 65 535
        final String targetValue = "v";
        map.put(targetKey, targetValue);

        new Thread(() -> {
            IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"));
        }).start();

        while (true) {
            if (null == map.get(targetKey)) {
                throw new RuntimeException("HashMap is not thread safe.");
            }
            else{
                System.out.println(map.get(targetKey));
            }
        }
    }
    static Map<String,String> map = new HashMap<>();

    public static class AddThread implements Runnable{

        int start;
        public AddThread(int start){
            this.start=start;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            //添加元素
            for(int i = start ; i<10000000;i+=2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //开启两个线程
        Thread t1 = new Thread(new AddThread(0));
        Thread t2 = new Thread(new AddThread(1));
        t1.start();
        t2.start();
        //主线程等待两个线程执行完
        t1.join();
        t2.join();
        System.out.println(map.size());
    }



}
