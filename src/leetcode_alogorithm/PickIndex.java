package leetcode_alogorithm;

import java.util.Arrays;

/**
 * @author : LuckKAnn
 * @date : 9:54 PM 9/1/2021
 * @email: 1546165200@qq.com
 */

/**
 * 力扣528题
 *
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。

 */
public class PickIndex {
    int[] pre;
    int total;

    /**
     * 这道题采用前缀和的方式，通过数学表达是的计算
     * 对于任意一个x，x是随机产生的用于选取随机数
     * 当   pre[i]-w[I]+1<=x<=pre[i]时，那么就应该选这第i个数目
     * 所以当计算出pre之后，可以直接通过二分法，找到第一个不小于x的pre数组，就得到了i的结果
     *
     * 为什么是 pre[I]-W[I]+1呢，可以通过举例子来看，这是计算的方式
     * @param w
     */
    public PickIndex(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        // 该方法直接用来计算数组和
        total = Arrays.stream(w).sum();
    }

    public int pickIndexRandom() {
//        Math.random 用来产生[0,1)的随机数，乘以total之后，可以得到[0,total)的随机数
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
