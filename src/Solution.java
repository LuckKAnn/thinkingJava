

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
    Map<Integer,List<Integer>> data = new HashMap<>();
    Random random = new Random();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = data.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            data.put(nums[i],list);
        }
    }

    public int pick(int target) {
        List<Integer> dataList = data.get(target);
        int len = dataList.size();
        int i = random.nextInt(len);

        return dataList.get(i);
    }


    public static void main(String[] args) {
        Random tmp = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(tmp.nextInt(10));

        }
    }

}
