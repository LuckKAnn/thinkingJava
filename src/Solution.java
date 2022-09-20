

import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
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

        int [] arr = {1,2,3,4};
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };


    }

}
