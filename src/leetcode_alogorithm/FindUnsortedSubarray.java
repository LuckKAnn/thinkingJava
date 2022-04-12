package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 8:06 PM 8/3/2021
 * @email: 1546165200@qq.com
 * *************581. 最短无序连续子数组
 * 主要是这道题考验的思路，以及利用Arrays类中的一些方法
 */

/***
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 *
 * ****************************这道题，重点在于在on的时间复杂度内 解决，其方式在于利用从左边的数都小于右边数里面的最小值，右边数都大于左边数的最大值，
 * 左右的分界线就是所求
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int rightMin  = Integer.MAX_VALUE,leftMax = Integer.MIN_VALUE;
        int left = -1,right =-1;
        for(int i =0;i<nums.length;i++){
            //i是从左往右升的，应该找到的是right，所有这个数要比左边最大的小
            if(nums[i]<leftMax){
                right = i;
            }
            else {
                leftMax = Math.max(nums[i],leftMax);
            }
            // len-i-1是从右往左降的，故找到的是left，left要大于右边最小
            if(nums[len-i-1]>rightMin){
                left = len-i-1;
            }
            else{
                rightMin = Math.min(rightMin,nums[len-i-1]);
            }
        }

        return  right==-1?0:right-left+1;

    }
}
