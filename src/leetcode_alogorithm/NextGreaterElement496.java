package leetcode_alogorithm;

/**
 * @FileName: NextGreaterElement
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/26 14:50
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 * **************************
 * 利用单调栈来解决在数组当中，在某个数右边的比其更大的数值。
 */
public class NextGreaterElement496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //实现单调栈
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length-1; i >=0 ; i--) {
            int tmp = nums2[i];
            //小于等于当前元素的全部出栈
            while (!stack.isEmpty()&&tmp>=stack.peek()){
                stack.pop();
            }
            //栈为空代表右边没有元素比起更大
            map.put(tmp,stack.isEmpty()?-1:stack.peek());
            //把自己加进去
            stack.push(tmp);
        }
        int []ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return  ans;
    }


    public int[] nextGreaterElement02(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //实现单调栈
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < nums2.length; i++) {
        //    从前开始
            while (!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                Integer pop = stack.pop();
                map.put(nums2[pop],nums2[i]);
            }
            stack.push(i);
        }
        int []ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        return  ans;
    }
}
