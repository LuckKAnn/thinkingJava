

import org.w3c.dom.Node;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * @author : LuckKAnn
 * @date : 9:43 PM 7/5/2021
 * @email: 1546165200@qq.com
 */

public class Solution {
    public static void main(String[] args) {
       BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(1);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();;

        reentrantLock.unlock();;

    }


}