package leetcode_alogorithm;

import java.util.Map;
import java.util.TreeMap;

/**
 * @FileName: SummaryRanges
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/9 12:18
 */

/**
 * 352. 将数据流变为多个不相交区间
 *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 实现 SummaryRanges 类：
 *
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 * ***********************************************
 * 这道题直接利用数据量的缘故，直接声明足够大的数组来进行遍历也是可以做的，但是这里更方便的是利用TreeMap进行区间合并
 *
 * ***************记住这种方法，因为TreeMap有序，且提供了API找到第一个大于或等于给定key的Map.entry，找到第一个小于或等于给定key的Map.entry，能够根据不同条件判断应该插入到哪个集合。
 *
 */
public class SummaryRanges {

    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<Integer, Integer>();
    }

    public void addNum(int val) {
        // 找到 l1 最小的且满足 l1 > val 的区间 interval1 = [l1, r1]
        // 如果不存在这样的区间，interval1 为尾迭代器

        /**
         * ceilingEntry找到第一个大于或等于给定key的Map.entry
         *
         *
         */
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
        // 找到 l0 最大的且满足 l0 <= val 的区间 interval0 = [l0, r0]
        // 在有序集合中，interval0 就是 interval1 的前一个区间
        // 如果不存在这样的区间，interval0 为尾迭代器

        /**
         * floorEntry找到第一个小于或等于给定key的Map.entry
         *
         */
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);

        if (interval0 != null && interval0.getKey() <= val && val <= interval0.getValue()) {
            // 情况一
            //已经存在于区间内
            return;
        } else {
            boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
            boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
            if (leftAside && rightAside) {
                // 情况四
                int left = interval0.getKey(), right = interval1.getValue();
                intervals.remove(interval0.getKey());
                intervals.remove(interval1.getKey());
                intervals.put(left, right);
            } else if (leftAside) {
                // 情况二
                intervals.put(interval0.getKey(), interval0.getValue() + 1);
            } else if (rightAside) {
                // 情况三
                int right = interval1.getValue();
                intervals.remove(interval1.getKey());
                intervals.put(val, right);
            } else {
                // 情况五
                intervals.put(val, val);
            }
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            int left = entry.getKey(), right = entry.getValue();
            ans[index][0] = left;
            ans[index][1] = right;
            ++index;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
