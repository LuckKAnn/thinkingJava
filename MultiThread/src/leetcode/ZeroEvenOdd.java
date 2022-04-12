package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @FileName: ZeroEvenOdd
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/21 16:24
 */
public class ZeroEvenOdd {


    private int n;

    private Condition zeroCondition = new ReentrantLock().newCondition();
    private Condition evenCondition = new ReentrantLock().newCondition();
    private Condition oddCondition = new ReentrantLock().newCondition();

    private static int evenNum = 1;
    private static int oddNum = 2;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(0);
        evenCondition.signal();
        zeroCondition.await();

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        evenCondition.await();
        printNumber.accept(evenNum);
        evenNum+=2;
        oddCondition.signal();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        oddCondition.await();
        printNumber.accept(oddNum);
        evenNum+=2;
    }


    public static void main(String[] args) {


    }




}
