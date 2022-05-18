package leetcode_alogorithm;

/**
 * @FileName: MaxProfit714
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 10:05
 */
public class MaxProfit714 {


    /**
     * LK 买卖股票的最佳时机含手续费 系列第六
     *
     *
     * 一天结束的时候的状态
     * 有股票
     *
     * 没有股票
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {

        int lstHave = -prices[0];
        int lstNot = 0;

        for (int i = 1; i < prices.length; i++) {
            lstHave  = Math.max(lstHave,lstNot-prices[i]);
            lstNot = Math.max(lstNot,lstHave+prices[i]-fee);
        }
        return lstNot;
    }
}
