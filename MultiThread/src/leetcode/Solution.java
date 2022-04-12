package leetcode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    ReentrantLock rlock;
    Condition f;
    Condition s;
    public Solution() {
        rlock = new ReentrantLock();
        f = rlock.newCondition();
        s = rlock.newCondition();

    }

    public void first(Runnable printFirst) throws InterruptedException {

        rlock.lock();
        try {
            printFirst.run();
            f.signalAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            rlock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        rlock.lock();
        try {
            f.await();
            printSecond.run();
            s.signalAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            rlock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        rlock.lock();
        try {
            s.await();
            printThird.run();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            rlock.unlock();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

    }
}
