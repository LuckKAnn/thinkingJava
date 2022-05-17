package leetcode_alogorithm;

/**
 * @FileName: MaxProfit121
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/17 10:46
 */
public class MaxProfit121 {


    /**
     * LK 买卖股票的最佳时机，系列1
     *
     * K2 方法比较简单，简单的来说就是一次遍历，找历史低点,计算利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for (int i=1;i<prices.length;i++)
        {
            if (prices[i]>min){
                ans = Math.max(ans,prices[i]-min);
            }
            else{
                min = prices[i];
            }
        }
        return ans;
    }
}
