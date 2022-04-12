import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @FileName: TestThread
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/4 15:48
 */
public class TestThread extends Thread{

    public void  run(){


        System.out.println("xxxxxxxxx");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer>linkedList = new LinkedList<>();
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1100);


    }

}
