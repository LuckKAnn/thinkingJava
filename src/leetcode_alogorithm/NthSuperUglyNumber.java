package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 6:08 PM 8/9/2021
 * @email: 1546165200@qq.com
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/***
 * \313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 *  关于丑数，有两种定义，一般指其质因数要么为2，3，5，要么为一个数组中的质数。
 *  可以采用以下的方法，利用质数乘以质数的方法来得到质数
 *
 */
public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> s = new HashSet<Long>();
//      这个可以模拟最大最小堆，一般默认是采用的最小顶推，因为从小排序到达
//        PriorityQueue<Long> p = new PriorityQueue<Long>();
//        这个方法可以是西咸最大顶堆
        PriorityQueue<Long> p = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o2-o1);
            }
        });
        s.add(1L);
        p.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = p.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
//                如果加入成功，说明还没有这个值
                if (s.add(next)) {
                    p.add(next);
                }
            }
        }
        return ugly;
    }
}
