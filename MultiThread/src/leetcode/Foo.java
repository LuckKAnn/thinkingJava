package leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 1114. 按序打印
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * *******************************************
 * 这道题就是执行屏障的问题。即方法的执行顺序必须按照规定的顺序
 * 这道题也可以通过双semphore，双Condition
 */
public class Foo {
    private AtomicInteger flag =new AtomicInteger(0) ;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {


            printFirst.run();
            flag.incrementAndGet();

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
       while (flag.get()!=1);
            printSecond.run();
            flag.incrementAndGet();


    }

    public void third(Runnable printThird) throws InterruptedException {
            while (flag.get()!=2) ;
            printThird.run();
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1");
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r2");
            }
        };
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r3");
            }
        };
        Foo foo = new Foo();
        new Thread(()->{
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
