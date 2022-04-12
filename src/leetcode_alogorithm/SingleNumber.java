package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 7:25 PM 9/2/2021
 * @email: 1546165200@qq.com
 */

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber {
    /**
     * 当涉及到线性的时间复杂度的时候，这里要用位运算来解答
     * 即利用异或的方式
     * 异或运算具有交换律和结合律，同时0和任何数异或都为0，任何两个相同的数异或的0
     * 由此，整个数组的数异或，最终得到的值就是仅仅出现一次的值
     * 因为相同的值由结合律得到0，0和单独值异或得到本身
     *
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {

        int ans = 0;
        for(int num:nums){
            ans^=num;
        }
        return ans;

    }
}
