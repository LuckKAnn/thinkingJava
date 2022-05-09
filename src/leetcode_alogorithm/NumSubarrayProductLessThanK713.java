package leetcode_alogorithm;

/**
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 */
public class NumSubarrayProductLessThanK713 {
    /***
     * 用双指针来做是最方便的
     * 为什么这么做，这和元素的取值有关，这里所有的取值都是大于1的数，也就是说所取的范围越大，值就越大，越可能大于K
     * 我们枚举右指针，看有多少中方案，但是这里，由于上面的特性，不用每次都从最低位找low，只需要从上次结束的地方开始即可(因为递增的特性，往前一定不行)
     * 最后，算有多少种方案，直接利用区间长度即可。至于为什么，可以用抽样的思路，因为最高位必须是i，low必须在区间内，区间长度为i-low+1,也就是说low有那么多种取法
     *
     * LK:这种方案的思路很不错，十分的节约时间，不是单个的去算，而是利用了整体的性质。
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int cnt = 0;
        int low=0,tmp=1;

        for (int i = 0; i < nums.length; i++) {
            tmp*=nums[i];
            while (low<=i&&tmp>=k){
                tmp/=nums[low];
                low++;
            }

            cnt+=i-low+1;
        }
        return cnt;

    }
}
