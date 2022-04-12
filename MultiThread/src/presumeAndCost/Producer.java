package presumeAndCost;

import static presumeAndCost.PCTest.MAX_POOL;

/**
 * @FileName: Producer
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/2 11:10
 */
public class Producer implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (PCTest.queue) {

                if (PCTest.queue.size()<MAX_POOL) {
                    PCTest.queue.add(new Goods("商品",1));
                    System.out.println(Thread.currentThread().getName()+"生产商品");

                } else {
                    try {
                        PCTest.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}
