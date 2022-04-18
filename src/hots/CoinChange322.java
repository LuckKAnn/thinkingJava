package hots;

/**
 * @FileName: CoinChange322
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 11:49
 */
public class CoinChange322 {


    /**
     * 这里dp[i-coin[j]] 一定是已经计算过了的（按照计算规律）
     * dp[i]  = Min(dp[i-coin[0]],dp[i-coin[1]].......)+1
     * dp[0] = 0 ;
     * dp[coin[0]]=1;
     * @param coins
     * @param amount
     * @return
     */
    public static  int coinChange(int[] coins, int amount) {

        int[]dp = new int[amount+1];
        dp[0]=0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
           if (coins[i]<=amount) dp[coins[i]]=1;
        }

        for (int i = 1; i <=amount; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]>=0&&i-coins[j]<=amount){
                    if (dp[i-coins[j]]!=-1){
                        min = Math.min(min,dp[i-coins[j]]+1);
                    }
                     // 否则的话，相当于不可用进行这样的更换
                }
            }

            dp[i] = min==Integer.MAX_VALUE?-1:min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int []arr = {1,2,5};
        System.out.println(CoinChange322.coinChange(arr,11));
        int []arrr={2,4,1,5};
        System.out.println(CoinChange322.coinChange(arrr,8));
    }
}
