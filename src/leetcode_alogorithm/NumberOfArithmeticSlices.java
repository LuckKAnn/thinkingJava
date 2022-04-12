package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 7:25 PM 8/10/2021
 * @email: 1546165200@qq.com
 *
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/***
 * 该方法的理论在于，我们将数组的前两项固定，计算得到差d，然后枚举数组的结尾j，如果达到j时，能够仍然满足等差，
 * 那此时t要++，因为相较于前一个j，其多出了一个元素
 * 当碰到不满足等差的时候，直接更换前两项，因为前面已经加完了，直接到这里即可。
 *
 * 可以通过1，2，3，4，5来理解
 * 一开始，123，t=1；
 * 下一次，1234，t=2，因为较上一次多了一个234，而1234也是一个
 * 下一次12345，t=3，新的是12345，345，2345，
 *
 */
public class NumberOfArithmeticSlices {
  
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

}
