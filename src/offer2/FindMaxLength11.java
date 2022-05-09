package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: FindMaxLength11
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/21 11:13
 */

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class FindMaxLength11 {

    public int findMaxLength(int[] nums) {
        int ans = 0;
        //Map<Integer,Integer> preSum = new HashMap<>();
        int []preSume = new int[nums.length+1];
        preSume[0]=0;
        int tmp  = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp+=nums[i];
            preSume[i+1] = tmp;
            for (int j = 0; j <i; j++) {
                if ((preSume[i+1]-preSume[j])*2==((i+1-j))){
                    ans = Math.max(i+1-j,ans);
                    break;
                }
            }
        }
        return ans;
    }
}
