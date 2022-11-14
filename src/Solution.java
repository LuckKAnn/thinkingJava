

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
    static ArrayList<List<String>> arrayList = new ArrayList<>();

    static {
        for (int i = 0; i <= 10; i++) {
            arrayList.add(new ArrayList<>());
        }


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k <= 10; k++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == k) {
                        if (j < 10) {
                            arrayList.get(k).add("" + i + ":0" + j);
                        } else {
                            arrayList.get(k).add("" + i + ":" + j);
                        }
                    }
                }
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        return arrayList.get(turnedOn);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.readBinaryWatch(5));
    }
}
