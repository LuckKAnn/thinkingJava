package printCycle;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @FileName: ReentrantLock_Condition_ABC
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/23 16:15
 */
public class ReentrantLock_Condition_ABC {
    private int num;
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    private void printABC(int targetNum, Condition currentThread, Condition nextThread) {
        for (;; ) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {
                    currentThread.await();  //阻塞当前线程
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                nextThread.signal();    //唤醒下一个线程
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock_Condition_ABC reentrantLockConditionAbc = new ReentrantLock_Condition_ABC();
        new Thread(() -> {
            reentrantLockConditionAbc.printABC(0, c1, c2);
        }, "A").start();
        new Thread(() -> {
            reentrantLockConditionAbc.printABC(1, c2, c3);
        }, "B").start();
        new Thread(() -> {
            reentrantLockConditionAbc.printABC(2, c3, c1);
        }, "C").start();
    }
}
