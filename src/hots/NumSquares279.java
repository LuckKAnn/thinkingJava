package hots;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: NumSquares279
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/16 11:30
 */

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class NumSquares279 {


    Set<Integer> set = new HashSet<>();
    public int numSquares(int n) {
    //    用数组暂存离得最近的完全平方数

       int []dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int sqrt =(int) Math.sqrt(i);
            int tmp  = (int) Math.pow(sqrt,2);
            if (tmp==i){
            //    这个数是一个完全平方数
                set.add(i);
                dp[i]=1;

            }
            else{
                dp[i]=Integer.MAX_VALUE;
                //如果不是，就找一个最近的,需要遍历
                for(int q :set){
                    dp[i] = Math.min(dp[i],dp[i-q]+1);
                }
            }

        }

        return dp[n];
    }


    /**
     * dp的解法
     * 用的相当于是一种零钱兑换的思路
     * @param n
     * @return
     */
    public int numSquares02(int n) {
        //   如何考虑平方数呢？
        //所有的平方数，其实可以通过从1到某个数，1*1 2*2 3*3这样得到所有的平方数
        int []dp = new int[n+1];

        for (int i = 1; i <=n; i++) {
            //先全部用1来兑换
            dp[i] = i;

            //用每个可满足的平方数进行兑换
            for (int j = 1;i-j*j>=0; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);

            }
        }
        return  dp[n];
    }

    public static void main(String[] args) {
        NumSquares279 numSquares279 = new NumSquares279();
        System.out.println(numSquares279.numSquares(12));
    }
}
