package leetcode_alogorithm;

/**
 * @FileName: CanJump55
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 19:07
 */

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  TODO:字节面试题
 */
public class CanJump55 {
    /**
     * 直接用贪心的思想就可以
     * 因为这题存在一个，最远到达的问题，只需要维护一个最远到达的指标就可以了
     *
     *其实这道题的价值在于，如果要顺序访问数组，存在一个范围内的数据能够被访问，那这个区间不应该保存区间数组，而应该仅仅保存上下限即可。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int far = 0;
        int index = 0;
        while (index<=far&&index<nums.length){
            far = Math.max(index+nums[index],far);
            index++;
        }
        return far>=nums.length;
    }
}
