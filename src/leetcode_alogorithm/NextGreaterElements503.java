package leetcode_alogorithm;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: NextGreaterElements503
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/19 11:41
 */

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 *
 * 两次循环即可。
 */
public class NextGreaterElements503 {
    public int[] nextGreaterElements(int[] nums) {

        Deque<Integer> deque = new LinkedList<>();
        int []ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()&&nums[deque.peek()]<nums[i]){
                ans[deque.peek()] = nums[i];
                deque.pop();
            }
            deque.push(i);
        }

        if (deque.isEmpty()) return ans;

         //再进行一次处理
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()&&nums[deque.peek()]<nums[i]){
                ans[deque.peek()] = nums[i];
                deque.pop();
            }
            deque.push(i);
        }

        return ans;

    }
}
