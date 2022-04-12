package leetcode_alogorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: LoudAndRich
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/12/15 21:03
 */

/**
 * 851. 喧闹和富有
 *
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 *
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 *
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 ********************************************
 * 如何通过拓扑排序遍历有向无环图
 * 如何通过两点的关系，构造有向无环图，进行拓扑排序
 */
public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            //记录每个点的出边
            g[i] = new ArrayList<Integer>();
        }
        //记录每个点的入度
        int[] inDeg = new int[n];
        for (int[] r : richer) {
            g[r[0]].add(r[1]);
            ++inDeg[r[1]];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = i;
        }
        //开始遍历
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            //寻找一个起始点
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (quiet[ans[x]] < quiet[ans[y]]) {
                    ans[y] = ans[x]; // 更新 x 的邻居的答案
                }
                if (--inDeg[y] == 0) {
                    q.offer(y);
                }
            }
        }
        return ans;
    }

}
