import java.util.concurrent.TimeUnit;


/**
 * @author : LuckKAnn
 * @date : 17:36 2021/9/17
 * @email: 1546165200@qq.com
 */
class resources{
    private  int num;
    resources(){
        num=0;
    }
    public int getNum() {
        return num;
    }

    public void setNum() {
        this.num = num+1;
        System.out.println(Thread.currentThread().getName()+"修改变量值为:"+num);
    }
}
public class JMMTest {
    private  static  volatile int time = 0;
    public static void main(String[] args) {
        resources r = new resources();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //去掉锁，由于JMM的原因，会导致多线程问题
                    synchronized (JMMTest.class){
                        time+=1;
                    }
                    // r.setNum();
                    System.out.println(Thread.currentThread().getName()+"修改变量值为:"+time);
                }
            }).start();
        }

        // new Thread(()->{
        //     for (int i = 0; i < 100; i++) {
        //         time+=1;
        //         System.out.println(Thread.currentThread().getName()+"修改变量值为:"+time);
        //         // r.setNum();
        //     }
        // }).start();

    }
}
