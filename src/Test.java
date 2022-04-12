import java.util.*;

/**
 * @author : LuckKAnn
 * @date : 10:35 PM 7/6/2021
 * @email: 1546165200@qq.com
 */
class Resources{

    int num = 0;

    public   void increase() throws InterruptedException {
        if(num!=0) this.wait();
        num++;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        this.notifyAll();
    }


    public   void decrease() throws InterruptedException {
        if(num==0) this.wait();
        num--;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        this.notifyAll();
    }
}
public class Test {


    public static void main(String[] args) {
         ArrayDeque arrayDeque = new ArrayDeque<>();
         PriorityQueue p = new PriorityQueue<Integer>();
         Hashtable<String,String> hashtable = new Hashtable<>();
        Resources r = new Resources();
        Collections.synchronizedMap(new HashMap<>()) ;
       new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    r.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    r.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"B").start();

    }
}
