package printCycle;

/**
 * @FileName: printCycle.MultiPrintCycle
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/23 16:07
 */
public class MultiPrintCycle {

    private  volatile int num=0;
    private static final Object Lock = new Object();

    private void print_ABC(int target) {
        synchronized (Lock) {
            //循环打印
            for (;;) {

                while (num!= target) {
                    try {
                        Lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                if (num==100) num = 0;
                //System.out.print(Thread.currentThread().getName());
                System.out.println(target+1);
                //多线程的虚假唤醒，可能存在并不是到它，但是实际上被唤醒了
                Lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        MultiPrintCycle wait_notify_abc = new MultiPrintCycle();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                wait_notify_abc.print_ABC(finalI);
            }, "A"+i).start();
        }
    }
}
