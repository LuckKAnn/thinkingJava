package leetcode_alogorithm;

import java.util.Arrays;

/**
 * @author : LuckKAnn
 * @date : 8:31 PM 7/14/2021
 * @email: 1546165200@qq.com
 *
 * 力扣1818题
 * 二分查找的方法
 * 同时，利用数学的方法，解决寻找最小值的问题
 */
public class MinAbsoluteSumDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            //记住要在sum加和之后进行取模，否则的话可能溢出
            sum=(sum+Math.abs((nums1[i]-nums2[i])))%MOD;
        }
        int[] copy = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(copy);
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            //偏大的
            int near = binarySearch(copy, nums2[i]);
            int ori = Math.abs((nums1[i]-nums2[i])%MOD);
            int tmp = Math.abs((copy[near]-nums2[i])%MOD);
            max = Math.max(max,ori-tmp);
            if (near-1>=0){
                tmp = Math.abs((copy[near-1]-nums2[i])%MOD);
                max = Math.max(max,ori-tmp);
            }
        }
        //这样能够把结果控制在MOD范围内，且对于负数也同样适用
        return ( sum-max+ MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        /**
         * 寻找插入位置的二分查找方法。要记住模版
         */
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
