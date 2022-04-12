package zhouyang;

import java.util.concurrent.CountDownLatch;

/**
 * @FileName: VolatileFail
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/23 20:50
 */

class Numb{
    private  volatile int num = 0 ;


    public void setNum(){
        num++;
    }
    public int getNum(){
       return num;
    }
}

/**
 * 为什么这里打印的值会小于100w
 * 这个要结合MESI协议来看，两个线程同时读取到了5，然后+1，都等于6，然后由于MESI协议，只有一个能完成写操作，获取到总线，而另外一个线程里面的此次
 * 修改就会被丢失，会重新从主内存读取，读取到6，然后写回，还是6
 *
 * 而如果用CAS，因为CAS是加1 之前去判断，所以不会影响
 */
public class VolatileFail {


    public static Numb n = new Numb();
    public static CountDownLatch c  = new CountDownLatch(100);
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    n.setNum();
                }
                c.countDown();
            }).start();
        }


        c.await();

        System.out.println(n.getNum());



    }
}
