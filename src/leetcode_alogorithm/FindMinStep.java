package leetcode_alogorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: FindMinStep
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/11/10 17:23
 */

/**
 * 你正在参与祖玛游戏的一个变种。
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * 你的目标是 清空 桌面上所有的球。每一回合：
 *          从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 *          接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 *          如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
 *          如果桌面上所有球都被移除，则认为你赢得本场游戏。
 *          重复这个过程，直到你赢了游戏或者手中没有更多的球。
 * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
************************************核心思路
 * 回溯法+记忆化搜索
 */
public class FindMinStep {
    // 手中最多只有5个球，所以，操作次数不会多于5
    int INF = 6;

    public int findMinStep(String board, String hand) {
        // 记忆化缓存
        Map<String, Integer> memo = new HashMap<>();
        // 开始寻找结果
        int ans = dfs(board, hand.toCharArray(), memo);
        // 判断结果
        return ans >= INF ? -1 : ans;
    }

    private int dfs(String board, char[] hand, Map<String, Integer> memo) {
        // 如果board全部消除完了，直接返回
        if (board.length() == 0) {
            return 0;
        }

        // 如果缓存中已经处理过了，直接返回
        if (memo.containsKey(board)) {
            return memo.get(board);
        }

        // 存储本次递归的结果
        int ans = INF;

        // 将手中的球放到board的任意位置尝试去消除
        //这是一个回溯
        for (int i = 0; i < hand.length; i++) {
            char c = hand[i];
            //不为‘0’才可以进行使用
            if (c != '0') {
                for (int j = 0; j < board.length(); j++) {
                    // 构造新的board，插入到旧board的任意位置
                    StringBuilder newBoard = new StringBuilder()
                            .append(board.substring(0, j))
                            .append(c)
                            .append(board.substring(j));
                    // 尝试消除
                    //从j开始也就是从新插入的位置开始
                    removeSame(newBoard, j);
                    // 表示这个球已经用过了
                    hand[i] = '0';
                    // 进入下一次递归
                    ans = Math.min(ans, dfs(newBoard.toString(), hand, memo) + 1);
                    // 回溯，恢复状态
                    hand[i] = c;
                }
            }
        }

        // 缓存board字符串能够得到的最佳次数
        memo.put(board, ans);
        // 返回结果
        return ans;
    }

    /**
     * 消除连续球的算法
     * @param board
     * @param index
     */
    private void removeSame(StringBuilder board, int index) {
        // 移除三个以上连续的
        if (index < 0 ) {
            return;
        }
        // 从index的位置向两边扩散
        //双指针的方式
        int left = index, right = index;
        char c = board.charAt(index);
        // left为寻找从index开始左边第一个不等于c的索引
        // right 为寻找从index开始右边第一个不等于c的索引
        while (--left >= 0 && board.charAt(left) == c) ;
        while (++right < board.length() && board.charAt(right) == c) ;

        // 扩散完了两边的right和left位置的值都是不等于 c 的，需要减一表示 c 出现的次数
        int count = right - left - 1;
        // 大于等于3才消除
        if (count >= 3) {
            board.delete(left + 1, right);
            // 连锁反应，比如 YYGGGY，移除了中间的G，三个Y挨一块了，也要移除
            removeSame(board, left);
        }
    }

    public static void main(String[] args) {
        FindMinStep findMinStep = new FindMinStep();
        System.out.println(findMinStep.findMinStep("WWRRBBWW", "WRBRW"));
        /**
         * 输出结果:
         * 2
         */
    }
}
