package offer;

/**
 * @FileName: Offer56SingleNumber03
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/6 20:37
 */

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Offer56SingleNumber03 {

    /**
     * 核心思路: 利用位运算，计算每个位的情况，然后余K
     * 由于只有一个数只出现一次，那么每个位为1的个数余K，只有0或者1两种情况
     * 为1说明唯一的那个数这位为1，需要进行重构
     *
     * 因为是int，所以可以用32位的数组来存储信息
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int []bits = new int[32];
        for (int num :nums){
            for (int i = 0; i < 32; i++) {
                bits[i]+=(num&1);
                num>>>=1;
            }
        }
        int ans = 0,mod =3;
        for (int i = 0; i < 32; i++) {
            ans<<=1;

            ans|=bits[31-i]%3;
        }

        return ans;
    }
}
