package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : LuckKAnn
 * @date : 9:14 PM 8/10/2021
 * @email: 1546165200@qq.com
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 */

/**
 * 该算法比较简单，但是涉及到一些挺好的用法，一个是利用二分查找的方法，查找两种元素的分界线位置
 * 另外一个是如何重写comparator来实现多元素的排序，并且对于取前k个元素的问题，应该想到用最大最小堆
 */
public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> power = new ArrayList<int[]>();
//        利用二分查找的方法查找分界线
        for (int i = 0; i < m; ++i) {
//            pos记录分界线位置
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }
//这里重写comparator方法，试想应该对于某个class可以按照同样的方法重写
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
//                    在前，就是从低到高，升序
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });
        for (int[] pair : power) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }

}
