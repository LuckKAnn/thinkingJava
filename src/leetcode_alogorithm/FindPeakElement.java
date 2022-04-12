package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 19:45 2021/9/16
 * @email: 1546165200@qq.com
 */

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * *********************************************
 * 思路：水往低处流，人往高处走，这里虽然是无序的，但是我们从中间位置开始，比较两边元素，哪边大就往哪边走，一定能找到峰值。
 * 这样一次就能够减少一半的元素，可以达到 O(log n)的复杂度
 * 为什么往高处走一定能有峰值呢？
 * 比如是 mid =a ，mid+1=b
 * 加入右边无峰值，那么说明 右边递增。这时最后一个元素就是峰值
 * 注意这里着logN的算法，最终还是落到了二分法的思想上面
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        
        if(nums.length==1) return 0;
        int low = 0;
        int high = nums.length-1;
        while(true){
            int mid = low+(high-low)/2;
            if(mid==nums.length-1&&nums[mid]>nums[mid-1]) return mid;
            if(mid==0&&nums[mid]>nums[mid+1]) return mid;

            if(nums[mid]<nums[mid+1]){
                low = mid+1;
                continue;
            }
            else if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]) return mid;
            else{
                high = mid-1;

            }
        }

    }
}
