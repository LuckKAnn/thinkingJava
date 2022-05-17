package leetcode_alogorithm;

/**
 * @FileName: MaxProfit122
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/17 10:51
 */

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
public class MaxProfit122 {


    /**
     * LK 买卖股票的最佳时机 系列二
     *
     * 如果用动态规划的思想:
     * 在当前情形下，只有两种状态
     * 当前结束的时候，没有股票在手上
     * 当天结束的时候，有股票在手上
     * 用dp来表示累计收益
     * dp边界，dp[0][0]= -prices[0]
     * dp[0][1] = 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        dp[0][0]= - prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //当天结束的时候有股票在手上
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }

    /**
     * 空间优化,似乎这道题，动态规划并不是最快的方式
     * @param prices
     * @return
     */
    public int maxProfit02(int[] prices) {

        int lstHave= - prices[0];
        int lstNot= 0;
        int tmpHav,tmpNot;
        for (int i = 1; i < prices.length; i++) {
            //当天结束的时候有股票在手上
             tmpHav = Math.max(lstHave,lstNot-prices[i]);
            tmpNot= Math.max(lstHave+prices[i],lstNot);
           lstHave = tmpHav;
           lstNot = tmpNot;
        }
        return lstNot;
    }

    /**
     * 这种方法算是一种取巧的方式，但是思路还是有道理的，利用的是炒股的原理
     * 要求能获得的最大利润，且交易的次数不限制，那么用上帝视角，如果能找到每次升值的机会，那每次升值都买卖，那不就能赚钱了。
     * @param arr
     * @return
     */
    public int maxProfit03(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {  // 卖出有利可图
                ans += (arr[i] - arr[i-1]);
            }
        }

        return ans;
    }

}
