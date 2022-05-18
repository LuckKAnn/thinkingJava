

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
    public int[] sortedSquares(int[] nums) {
        int []ans = new int[nums.length];
        int divide = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0){
                divide = i;
                break;
            }
        }

        if (nums[nums.length-1]<0) divide = nums.length-1;

        int left = divide-1,right = divide;
        int index = 0;
        while (left>=0||right<nums.length){
            if (left==0){
            //    到达分界线了，只管右边
                ans[index++] = nums[right]*nums[right];
                right++;
            }
            if (right==nums.length){
            //    右边到了，只管左边
                ans[index++] = nums[left]*nums[left];
                left--;
            }

        //    都没到的话要进行比较
            else if (Math.abs(nums[left])>nums[right]){
            //    先right
                ans[index++] = nums[right]*nums[right];
                right++;
            }
            else{
            //    先left
                ans[index++] = nums[left]*nums[left];
                left--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int []arr = {-2,0};
        solution.sortedSquares(arr);
    }

}
