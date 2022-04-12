package presumeAndCost;

/**
 * @FileName: Consumer
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/2 11:15
 */
public class Consumer  implements  Runnable{


    @Override
    public void run() {
        while (true){
            try { //为了让每个消费者均匀消费，同时模拟消费耗时
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (PCTest.queue){

                if(!PCTest.queue.isEmpty()){
                    PCTest.queue.poll();
                    System.out.println(Thread.currentThread().getName()+"消费商品");
                }
                else {
                    PCTest.queue.notify();
                }
            }
        }


    }
}
