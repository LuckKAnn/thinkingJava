package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: SubarraySum10
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/21 10:41
 */

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 */
public class SubarraySum10 {

    /**
     * 这道题不是用前缀和很好解决吗
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int tmp = 0;
        int ans = 0;
        preSum.put(0,1);//前缀和为0的初始有1个
        for(int num:nums){
            tmp+=num;
            ans+=preSum.getOrDefault(tmp-k,0);
            preSum.put(tmp,preSum.getOrDefault(tmp,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySum10 subarraySum10 = new SubarraySum10();
        System.out.println(subarraySum10.subarraySum(new int[]{-1,-1,1}, 0));
    }
}
