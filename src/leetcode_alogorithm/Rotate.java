package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 9:42 PM 8/12/2021
 * @email: 1546165200@qq.com
 *
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */

/**
 * 旋转数组，用的方法是使用不断的反转，
 * 原来的数组反转一遍，变反
 * 原来后面的k个，会跑到前面去，但是顺序不对，故再返
 * 同样，原来前面的n-k个，到后面去了，顺序也是逆的，故再返
 */
public class Rotate {
    public  void reverse(int []num,int low,int high){
        while (low<=high){
            int tmp = num[low];
            num[low++] = num[high];
            num[high--] = tmp;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;

        reverse(nums,0,nums.length-1);
//        0到k-1已经有k个数
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}
