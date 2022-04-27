

import org.w3c.dom.Node;

import java.lang.reflect.Array;
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
    /**
     * 回溯的方式就行
     * @param nums
     * @return
     */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {


        ans.add(new ArrayList<Integer>());

        dfs(nums,new ArrayList<>(),0);
        return ans;
    }

    public void dfs(int []nums,List<Integer> tmp,int index){
        if (index==nums.length) return;
        tmp.add(nums[index]);
        ans.add(new ArrayList<>(tmp));
        dfs(nums,tmp,index+1);
        ans.remove(ans.size()-1);
        dfs(nums,tmp,index+1);

    }
    public static void main(String[] args) {
        Random tmp = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(tmp.nextInt(10));

        }
    }

}
