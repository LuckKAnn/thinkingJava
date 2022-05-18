package leetcode_alogorithm;

/**
 * @FileName: MaxProfit123
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/17 11:10
 */

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit123 {


    /**
     * LK: 买卖股票的最佳时机 III
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
       int firstBuy = -prices[0];
       int firstSell  = 0;
       int sBuy = -prices[0];
       int sSell = 0;


        for (int i = 1; i < prices.length; i++) {

            firstBuy = Math.max(firstBuy,-prices[i]);
            firstSell = Math.max(firstSell,firstBuy+prices[i]);
            sBuy = Math.max(sBuy,firstSell-prices[i]);
            sSell = Math.max(sSell,sBuy+prices[i]);
        }


        return sSell;
    }
}
