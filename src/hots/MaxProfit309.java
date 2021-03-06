package hots;

/**
 * @FileName: MaxProfit309
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/16 11:50
 */

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit309 {

    /**
     *
     *
     *
     * LK 最佳买卖股票时机含冷冻期 系列五
     * 动态规划:
     * 该情况下，每一天结束时刻的状态有三种
     * 0. 当前持有股票(一定是不在冷冻期的)
     * 1.当前没有持有股票，且处在冷冻期吗，指的是后面一天无法购买
     * 2.当前没有持有股票，不在冷冻期
     *
     * 假设用dp[i][0-2]分别表示上面的情况时，对应的累计最大收益。
     *
     * 那么dp[i][0]=max(dp[i-1][0],dp[i-1][2]-prices[i])
     * dp[i][1] = dp[i-1][0]+prices[i]
     * dp[i][2] = max(dp[i-1][2],dp[i-1][1])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int lstHave = -prices[0];
        int notIce = 0;
        int notNotIce = 0 ;

        int tmp1,tmp2,tmp3;
        for (int i = 1; i < prices.length; i++) {
            tmp1 = Math.max(lstHave,notNotIce-prices[i]);
            tmp2 = lstHave+prices[i];
            tmp3 = Math.max(notIce,notNotIce);

            lstHave=tmp1;
            notIce = tmp2;
            notNotIce=tmp3;
        }

    return Math.max(notIce,notNotIce);
    }
}
