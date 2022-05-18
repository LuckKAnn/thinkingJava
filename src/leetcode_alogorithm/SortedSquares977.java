package leetcode_alogorithm;

/**
 * @FileName: SortedSquares977
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 16:29
 */
public class SortedSquares977 {

    /**
     * 用双指针的方法让这道题更简单
     * 因为最大的平方数应该是从两边开始向中间的，所以直接双指针即可
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
